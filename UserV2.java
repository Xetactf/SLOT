public class UserV2 {
    private int cagnotte;

    public User() {
        this.cagnotte = 250000;
    }

    public int getCagnotte() {
        return cagnotte;
    }

    public void setCagnotte(int cagnotte) {
        this.cagnotte = cagnotte;
    }

    public boolean spin(int mise) {
        // Vérifier si la mise est valide
        if (mise != 2000 && mise != 4000 && mise != 6000 && mise != 10000) {
            System.out.println("Mise invalide !");
            return false;
        }

        // Calculer les gains ou les pertes
        int gains = 0;

        if (symbole1 == symbole2 && symbole2 == symbole3) {
            gains = mise * 10;
        } else if (symbole1 == symbole2 || symbole1 == symbole3 || symbole2 == symbole3) {
            gains = mise * 3;
        }

        if (gains > 0) {
            // Afficher les gains
            System.out.println("Gagné ! Vous avez gagné " + gains + " jetons.");

            // Mettre à jour la cagnotte
            cagnotte += gains;
        } else {
            // Afficher la perte
            System.out.println("Perdu ! Vous avez perdu " + mise + " jetons.");

            // Mettre à jour la cagnotte
            cagnotte -= mise;
        }

        // Afficher la cagnotte
        System.out.println("Cagnotte : " + cagnotte + " jetons.");

        // Retourner true si le joueur a gagné, false sinon
        return gains > 0;
    }
}
