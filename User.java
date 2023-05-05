package slot;

import java.util.Scanner;

public class User {
    // Propriétés de l'utilisateur
    private String username;
    private int balance;
    private Machine machine;
    private int mise;
    private Scanner scanner;
    private int multiplicateur;
    private int freeSpins;
    
    // Constructeur de l'utilisateur
    public User(Machine machine) {
        scanner = new Scanner(System.in);
        System.out.println("Entrez votre nom d'utilisateur: ");
        this.username = scanner.nextLine();
        this.balance = 250000;
        this.machine = machine;
        this.mise = -1;
        this.multiplicateur = 1;
        this.freeSpins = 0;
    }
    
    // Méthode pour imprimer le solde de l'utilisateur
    public void printSolde() {
        System.out.println("Votre solde est de " + this.balance + " credits.");
    }
    
    // Méthode pour lancer la machine
    public void lancerMachine() {
       // Si l'utilisateur a des free spins, on les utilise
        if(this.freeSpins > 0) {
            this.freeSpins--;
            System.out.println("\nLancement du free spin Suivant ... ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        // Si l'utilisateur n'a pas de free spins, il doit miser des crédits
        } else {
            this.mise = 0;
            this.multiplicateur = 1;
            while(this.mise < 1) {
                System.out.println("\nCombien de credits voulez-vous miser? (2k, 4k, 6k, 10k).");
                String result = scanner.nextLine();
                System.out.println("\n");
                switch (result) {
                    case "2k":
                        this.mise = 2000;
                        break;
                    case "4k":
                        this.mise = 4000;
                        break;
                    case "6k":
                        this.mise = 6000;
                        break;
                    case "10k":
                        this.mise = 10000;
                        break;
                    default:
                        System.out.println("Mise invalide.");
                        break;
                }
                if(this.mise > this.balance) {
                    System.out.println("Vous n'avez pas assez de credits.");
                }
            }
            System.out.println("Vous avez mise " + this.mise + " credits.");
        }
        this.machine.roll();
        this.machine.print3lines();

        this.machine.detecterVictoire();
        if(this.machine.getLastGameFreeSpinCount() >2) {
            // Si l'utilisateur vient de gagner des freespins, demander le mode 
            while(this.freeSpins < 1){
                System.out.println("\nVous avez gagne " + this.machine.getLastGameFreeSpinCount() + " free spins!");
                System.out.println("Choisissez votre nombre de free spins (15, 10, 5): ");
                String result2 = scanner.nextLine();
                switch (result2) {
                    case "15":
                        this.freeSpins += 15;
                        this.multiplicateur = 2;
                        break;
                    case "10":
                        this.freeSpins += 10;
                        this.multiplicateur = 3;
                        break;
                    case "5":
                        this.freeSpins += 5;
                        this.multiplicateur = 10;
                        break;
                    default:
                        System.out.println("Nombre de free spins invalide.");
                        break;
                }
            }
        } else if(this.machine.getLastVictoryCount() > 2) {
            // Si le joueur gagne avec 3 symboles ou plus
            System.out.println("\nVous avez gagne " + this.machine.getLastVictoryCount() + " fois " + this.machine.getLastVictorySymbol().getNom() + "!");
            int gain = 0;
            if(this.machine.getLastVictoryCount() == 3) {
                gain = this.machine.getLastVictorySymbol().getGain3() * (this.mise / 2000);
            } else if(this.machine.getLastVictoryCount() == 4) {
                gain = this.machine.getLastVictorySymbol().getGain4() * (this.mise / 2000);
            } else if(this.machine.getLastVictoryCount() == 5) {
                gain = this.machine.getLastVictorySymbol().getGain5() * (this.mise / 2000);
            }
            
            // Mettre à jour le solde du joueur
            this.balance += this.mise;
            this.balance += gain*this.multiplicateur;
            System.out.println("Vous avez gagne " + gain*multiplicateur + " credits.");

            // Réinitialiser chaque symbole de la liste
            for (Symbole symbole : this.machine.getLastVictoryList()) {
                symbole.regeneratesymb();
            }

        } else {
            // Si le joueur perd
            System.out.println("\nVous avez perdu.");
            this.balance -= this.mise;
            this.mise = -1;
        }
        // Afficher le solde et lancer la machine à sous pour un nouveau tour
        this.printSolde();
        this.lancerMachine();
        
    }

    // Méthode pour fermer le scanner
    public void closeScanner() {
        scanner.close();
    }
}
