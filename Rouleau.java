
package moneyGame;

import java.util.Random;

public class Rouleau {
    private Symbole[] listeSymboles;
    private int position;
    private int taille;

    public Rouleau(int taille) {
        this.taille = taille;
        this.position = 0;
        this.listeSymboles = new Symbole[8];
        this.initialiserSymboles(); // Appel de la méthode d'initialisation des symboles
    }
    
    public void initialiserSymboles() {
        this.listeSymboles[0] = new Symbole("Bar");
        this.listeSymboles[1] = new Symbole("Seven");
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
        int index = random.nextInt(8);
        return listeSymboles[index];
    }

    // Méthode pour récupérer la ligne de symboles affichée
    public Symbole[] getLigne() {
        Symbole[] ligne = new Symbole[this.taille];
        for (int i = 0; i < this.taille; i++) {
            ligne[i] = this.getSymboleAleatoire();
        }
        return ligne;
    }
}
