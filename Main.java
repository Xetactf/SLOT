
package moneyGame;

public class Main {
	public static void main(String[] args) {
	    Rouleau rouleau1 = new Rouleau(8);
	    Rouleau rouleau2 = new Rouleau(8);
	    Rouleau rouleau3 = new Rouleau(8);
	    Rouleau rouleau4 = new Rouleau(8);
	    Rouleau rouleau5 = new Rouleau(8);

	    for (int i = 0; i < 5; i++) {
	        rouleau1.tourner();
	        rouleau2.tourner();
	        rouleau3.tourner();
	        rouleau4.tourner();
	        rouleau5.tourner();

	        Symbole[] ligne = {rouleau1.getSymboleAleatoire(),
	                           rouleau2.getSymboleAleatoire(),
	                           rouleau3.getSymboleAleatoire(),
	                           rouleau4.getSymboleAleatoire(),
	                           rouleau5.getSymboleAleatoire()};
	        for (Symbole symbole : ligne) {
	            System.out.printf("%-10s|", symbole.getNom());
	        }
	        System.out.println();
	    }
	}

}

