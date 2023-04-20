
package moneyGame;

import java.util.Random;

public class Rouleau {
    private Symbole[] listeSymboles;
    private int position;
    private int taille;

    public Rouleau(int taille) {
        this.taille = taille;
        this.position = 0;
        this.listeSymboles = new Symbole[taille];
        // Initialiser la liste de symboles avec des symboles vides
        for (int i = 0; i < taille; i++) {
            this.listeSymboles[i] = new Symbole("");
        }
        this.initialiserSymboles(); // Appel de la méthode d'initialisation des symboles
    }
    
    public void initialiserSymboles() {
        this.listeSymboles[0] = new Symbole("Bar");
        this.listeSymboles[1] = new Symbole("seven");
        this.listeSymboles[2] = new Symbole("Cherry");
        this.listeSymboles[3] = new Symbole("Plum");
        this.listeSymboles[4] = new Symbole("Bell");
        this.listeSymboles[5] = new Symbole("Melon");
        this.listeSymboles[6] = new Symbole("Orange");
        this.listeSymboles[7] = new Symbole("Lemon");
    }


    // Méthode pour faire tourner le rouleau
    public void tourner() {
        this.position = (this.position + 1) % this.taille;
    }
    
    public Symbole getSymboleAleatoire() {
        Random random = new Random();
        int index = random.nextInt(taille);
        return listeSymboles[index];
    }

    // Méthode pour récupérer la ligne de symboles affichée
    public Symbole[] getLigne() {
        Symbole[] ligne = new Symbole[3];
        ligne[0] = this.listeSymboles[(this.position + this.taille - 2) % this.taille];
        ligne[1] = this.listeSymboles[(this.position + this.taille - 1) % this.taille];
        ligne[2] = this.listeSymboles[this.position];
        return ligne;
    }
}

