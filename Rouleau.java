
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

    // Méthode pour calculer le gain en fonction d'une ligne de symboles
    public double calculerGain() {
        Symbole[] ligne = this.getLigne();
        int symbole1 = 0, symbole2 = 0, symbole3 = 0, symbole4 = 0, symbole5 = 0, symbole6 = 0, symbole7 = 0, symbole8 = 0;
        for (Symbole symbole : ligne) {
            if (symbole.getNom().equals("Bar")) {
                symbole1++;
            } else if (symbole.getNom().equals("seven")) {
                symbole2++;
            } else if (symbole.getNom().equals("Cherry")) {
                symbole3++;
            } else if (symbole.getNom().equals("Plum")) {
                symbole4++;
            } else if (symbole.getNom().equals("Bell")) {
                symbole5++;
            } else if (symbole.getNom().equals("Melon")) {
                symbole6++;
            } else if (symbole.getNom().equals("Orange")) {
                symbole7++;
            } else if (symbole.getNom().equals("Lemon")) {
                symbole8++;
            }
        }

	        double gain = 0.0;
	        if (symbole1 == 5) {
	            gain = 4000.0;
	        } else if (symbole1 == 4) {
	            gain = 2000.0;
	        } else if (symbole1 == 3) {
	            gain = 1000.0;
	        } else if (symbole2 == 5) {
	            gain = 3000.0;
	        } else if (symbole2 == 4) {
	            gain = 1500.0;
	        } else if (symbole2 == 3) {
	            gain = 750.0;
	        } else if (symbole3 == 5) {
	            gain = 1500.0;
	        } else if (symbole3 == 4) {
	        	gain = 750.0;
        	} else if (symbole3 == 3) {
        		gain = 500.0;
        	} else if (symbole4 == 5) {
        		gain = 1500.0;
        	} else if (symbole4 == 4) {
        		gain = 750.0;
        	} else if (symbole4 == 3) {
        		gain = 500.0;
        	} else if (symbole5 == 5) {
        		gain = 1000.0;
        	} else if (symbole5 == 4) {
        		gain = 500.0;
        	} else if (symbole5 == 3) {
        		gain = 300.0;
        	} else if (symbole6 == 5) {
        		gain = 1000.0;
        	} else if (symbole6 == 4) {
        		gain = 500.0;
        	} else if (symbole6 == 3) {
        		gain = 300.0;
        	} else if (symbole7 == 5) {
        		gain = 1000.0;
        	} else if (symbole7 == 4) {
        		gain = 500.0;
        	} else if (symbole7 == 3) {
        		gain = 300.0;
        	} else if (symbole8 == 5) {
        		gain = 1000.0;
        	} else if (symbole8 == 4) {
        		gain = 500.0;
        	} else if (symbole8 == 3) {
        		gain = 300.0;
        	}
	        return gain;
    }
}

