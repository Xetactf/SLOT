
package slot;

import java.util.Random;

	public class Rouleau {
	    private Symbole[] listeSymboles;
	    private int position;
	    private int taille;
	    private boolean freesymb;
	    private boolean supersymb;
	    
	    //Methode d'initialisation d'un rouleau
	    public Rouleau(int taille, boolean freesymb, boolean supersymb) {
	    this.taille = taille;
	    this.listeSymboles = new Symbole[taille];
	    
	    for (int i = 0; i < taille; i++) {
	        listeSymboles[i] = new Symbole(freesymb, supersymb);
	    }
	    
	    this.position = 0;
	    this.freesymb = freesymb;
	    this.supersymb = supersymb;
	}
    
	//Methode pour retourner le symbole à une position X par rapport à la position actuelle
    public Symbole getSymboleAtPosition(int position) {
        if(this.position + position >= this.taille) {
            return this.listeSymboles[(this.position + position) - this.taille];
        }else if(this.position + position < 0) {
            return this.listeSymboles[this.taille + (this.position + position)];
        } else {
            return this.listeSymboles[this.position + position];
        }
    }
    
    //Tourner le rouleau
    public void roll(int nombreAleatoire) {
        if(nombreAleatoire + this.position > this.taille) {
            this.position = (nombreAleatoire + this.position) - this.taille;
        } else {
            this.position += nombreAleatoire;
        }
    }
    
}
