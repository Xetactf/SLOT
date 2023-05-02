package moneyGame;

import java.util.ArrayList;
import java.util.List;

public class Machine {

    public void lancer() {
        Rouleau rouleau1 = new Rouleau(8);
        Rouleau rouleau2 = new Rouleau(8);
        Rouleau rouleau3 = new Rouleau(8);
        Rouleau rouleau4 = new Rouleau(8);
        Rouleau rouleau5 = new Rouleau(8);

        List<Symbole[]> lignes = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            rouleau1.tourner();
            rouleau2.tourner();
            rouleau3.tourner();
            rouleau4.tourner();
            rouleau5.tourner();

            Symbole[] ligne = { rouleau1.getSymboleAleatoire(), rouleau2.getSymboleAleatoire(),
                    rouleau3.getSymboleAleatoire(), rouleau4.getSymboleAleatoire(), rouleau5.getSymboleAleatoire() };

            lignes.add(ligne);

            for (Symbole symbole : ligne) {
                System.out.printf("%-10s|", symbole.getNom());
            }
            System.out.println();
        }
        System.out.println("\nGain total : " + verifierGain(lignes, 2000));
    }


    public double verifierGain(List<Symbole[]> lignes, int mise) {

        int gainMise;

        if (mise == 2000) {
            gainMise = 1;
        } else if (mise == 4000) {
            gainMise = 2;
        } else if (mise == 6000) {
            gainMise = 3;
        } else if (mise == 10000) {
            gainMise = 5;
        } else {
            gainMise = 0;

        }

        double gainTotal = 0.0;
        for (Symbole[] ligne : lignes) {
            int[] compteur = new int[8];

            for (Symbole symbole : ligne) {
                switch (symbole.getNom()) {
                case "Bar":
                    compteur[0]++;
                    break;
                case "Seven":
                    compteur[1]++;
                    break;
                case "Cherry":
                    compteur[2]++;
                    break;
                case "Plum":
                    compteur[3]++;
                    break;
                case "Bell":
                    compteur[4]++;
                    break;
                case "Melon":
                    compteur[5]++;
                    break;
                case "Orange":
                    compteur[6]++;
                    break;
                case "Lemon":
                    compteur[7]++;
                    break;
                }
            }

            double gainLigne = 0.0;
            if (compteur[0] == 5) {
                gainLigne = 4000 * gainMise;
            } else if (compteur[0] == 4) {
                gainLigne = 2000 * gainMise;
            } else if (compteur[0] == 3) {
                gainLigne = 1000 * gainMise;;
            } else if (compteur[1] == 5) {
                gainLigne = 3000 * gainMise;;
            } else if (compteur[1] == 4) {
                gainLigne = 1500 * gainMise;;
            } else if (compteur[1] == 3) {
                gainLigne = 750 * gainMise;;
            } else if (compteur[2] == 5) {
                gainLigne = 1500 * gainMise;;
            } else if (compteur[2] == 4) {
                gainLigne = 750 * gainMise;;
            } else if (compteur[2] == 3) {
                gainLigne = 500 * gainMise;;
            } else if (compteur[3] == 5) {
                gainLigne = 1500 * gainMise;;
            } else if (compteur[3] == 4) {
                gainLigne = 750 * gainMise;;
            } else if (compteur[3] == 3) {
                gainLigne = 500 * gainMise;;
            } else if (compteur[4] == 5) {
                gainLigne = 1000 * gainMise;;
            } else if (compteur[4] == 4) {
                gainLigne = 500 * gainMise;;
            } else if (compteur[4] == 3) {
                gainLigne = 300 * gainMise;;
            } else if (compteur[5] == 5) {
                gainLigne = 1000 * gainMise;;
            } else if (compteur[5] == 4) {
                gainLigne = 500 * gainMise;;
            } else if (compteur[5] == 3) {
                gainLigne = 300 * gainMise;;
            } else if (compteur[6] == 5) {
                gainLigne = 1000 * gainMise;;
            } else if (compteur[6] == 4) {
                gainLigne = 500 * gainMise;;
            } else if (compteur[6] == 3) {
                gainLigne = 300 * gainMise;;
            } else if (compteur[7] == 5) {
                gainLigne = 1000 * gainMise;
            } else if (compteur[7] == 4) {
                gainLigne = 500 * gainMise;
            } else if (compteur[7] == 3) {
                gainLigne = 300 * gainMise;
            } else {
                gainLigne = 0;
            }
            gainTotal += gainLigne;
        }
        return Math.abs(gainTotal);
    }

}


	

