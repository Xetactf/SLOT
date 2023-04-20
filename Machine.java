
package moneyGame;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Rouleau> rouleaux;

    public Machine() {
        rouleaux = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                rouleaux.add(new Rouleau(41));
            } else {
                rouleaux.add(new Rouleau(30));
            }
        }
    }

    public void lancer() {
        for (int i = 0; i < 3; i++) {
            for (Rouleau rouleau : rouleaux) {
                System.out.print(rouleau.getSymboleAleatoire() + " ");
            }
            System.out.println();
        }
    }
}


