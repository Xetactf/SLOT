
package slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Machine {
    private List<Rouleau> rouleaux;
    private Symbole lastVictorySymbol;
    private int lastVictoryCount;
    private List<Symbole> lastVictoryList;
    private int lastGameFreeSpinCount;

    public Machine() {
        // Initialisation des rouleaux de la machine
        this.rouleaux = new ArrayList<Rouleau>();
        this.rouleaux.add(new Rouleau(30, true, true));
        this.rouleaux.add(new Rouleau(30, true, false));
        this.rouleaux.add(new Rouleau(30, false, true));
        this.rouleaux.add(new Rouleau(30, true, false));
        this.rouleaux.add(new Rouleau(45, true, true));
    }

    public void print3lines() {
        // Affichage des trois lignes de symboles de la machine
        for (int i = 0; i < 3; i++) {
            for (Rouleau rouleau : rouleaux) {
                System.out.print(rouleau.getSymboleAtPosition(i).getNom() + " | ");
            }
            System.out.println();
        }
    }

    public void roll() {
        // Lancement des rouleaux avec un nombre aléatoire de décalage
        Random random = new Random();
        int nombreAleatoire = random.nextInt(16) + 5;

        for (Rouleau rouleau : rouleaux) {
            rouleau.roll(nombreAleatoire);
        }
    }


    public void detecterVictoire() {
        // Création d'une matrice représentant les symboles de la machine
        Symbole[][] matrix = new Symbole[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < rouleaux.size(); j++) {
                matrix[i][j] = rouleaux.get(j).getSymboleAtPosition(i);
            }
        }

        // Inversion de la matrice pour pouvoir effectuer la détection de victoire
        Symbole[][] revertedMatrix = new Symbole[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                revertedMatrix[i][j] = matrix[j][i];
            }
        }
        
        // Réinitialisation des compteurs de victoire et de free spins
        this.lastGameFreeSpinCount = 0;
        this.lastVictoryCount = 0;
        this.lastVictorySymbol = null;
        this.lastVictoryList = new ArrayList<Symbole>();

        // Boucle pour détecter les victoires dans la matrice
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {

                Symbole symbole = revertedMatrix[x][y];
                int count = 1;
                boolean breakd = false;
                ArrayList<Symbole> list = new ArrayList<Symbole>();
                list.add(symbole);
                for(int z = x+1; z < 5; z++) {
                    if(breakd) {
                        break;
                    }
                    for(int a = 0; a<3; a++) {
                        if(revertedMatrix[z][a].getId() == symbole.getId() || revertedMatrix[z][a].getId() == 102) {
                            count ++;
                            list.add(revertedMatrix[z][a]);
                            if(count > this.lastVictoryCount) {
                                this.lastVictoryCount = count;
                                this.lastVictorySymbol = symbole;
                                this.lastVictoryList = list;
                            }
                            break;
                        } else {
                            if(a == 2) {
                                breakd = true;
                                break;
                            }
                        }
                    }

                }
            }
        }  

        //Compter le nombre de Symboles "Free"
        int freeCount = 0;
        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 3; y++) {
                if(revertedMatrix[x][y].getId() == 101) {
                    freeCount++;
                    break;
                }
            }
        }
        this.lastGameFreeSpinCount = freeCount;
        
    }

    //Methode pour donner le Symbole du dernier Spin
    public Symbole getLastVictorySymbol() {
        return lastVictorySymbol;
    }
    
    //Methode pour donner le Nombre de hit du dernier Spin
    public int getLastVictoryCount() {
        return lastVictoryCount;
    }
    
    //Methode pour obtenir la liste des Symboles gagnants
    public List<Symbole> getLastVictoryList() {
        return lastVictoryList;
    }
    
    //Compter le nombre de Symboles Freespins dans le dernier lancer
    public int getLastGameFreeSpinCount() {
        return lastGameFreeSpinCount;
    }
    
    
}
