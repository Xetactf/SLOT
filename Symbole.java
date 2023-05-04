
package slot;

import java.util.Random;

public class Symbole {
    private String nom;
    private int id;
    private int gain5;
    private int gain4;
    private int gain3;
    private boolean freesymb;
    private boolean supersymb;

    public Symbole(boolean freesymb, boolean supersymb) {
        this.freesymb = freesymb;
        this.supersymb = supersymb;
        setData();
    }

    public void regeneratesymb(){
        setData();
    }

    public void setData(){
        String[] symblist;
        if (this.freesymb && this.supersymb) {
            symblist = new String[]{"Bonus    ", "Free     ", "Super    ", "Symbole 1", "Symbole 2", "Symbole 3", "Symbole 4", "Symbole 5", "Symbole 6", "Symbole 7", "Symbole 8"};
        } else if (this.freesymb) {
            symblist = new String[]{"Bonus    ", "Free     ", "Symbole 1", "Symbole 2", "Symbole 3", "Symbole 4", "Symbole 5", "Symbole 6", "Symbole 7", "Symbole 8"};
        } else if (this.supersymb) {
            symblist = new String[]{"Bonus    ", "Super    ", "Symbole 1", "Symbole 2", "Symbole 3", "Symbole 4", "Symbole 5", "Symbole 6", "Symbole 7", "Symbole 8"};
        } else {
            symblist = new String[]{"Bonus    ", "Symbole 1", "Symbole 2", "Symbole 3", "Symbole 4", "Symbole 5", "Symbole 6", "Symbole 7", "Symbole 8"};
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(symblist.length);
        this.nom = symblist[randomIndex];

        if (nom.contains("Symbole 1")) {
            this.gain5 = 4000;
            this.gain4 = 2000;
            this.gain3 = 1000;
            this.id = 1;
        } else if (nom.contains("Symbole 2")) {
            this.gain5 = 3000;
            this.gain4 = 1500;
            this.gain3 = 750;
            this.id = 2;
        } else if (nom.contains("Symbole 3")) {
            this.gain5 = 1500;
            this.gain4 = 750;
            this.gain3 = 500;
            this.id = 3;
        } else if (nom.contains("Symbole 4")) {
            this.gain5 = 1500;
            this.gain4 = 1000;
            this.gain3 = 1000;
            this.id = 4;
        } else if (nom.contains("Symbole 5")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 5;
        } else if (nom.contains("Symbole 6")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 6;
        } else if (nom.contains("Symbole 7")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 7;
        } else if (nom.contains("Symbole 8")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 8;
        } else if (nom.contains("Bonus")) {
            this.id = 100;
        } else if (nom.contains("Free")) {
            this.id = 101;
        } else if (nom.contains("Super")) {
            this.id = 102;
        }

    }

    public String getNom() {
        return this.nom;
    }
        
    public int getId() {
        return this.id;
    }

    public int getGain5() {
        return this.gain5;
    }

    public int getGain4() {
        return this.gain4;
    }

    public int getGain3() {
        return this.gain3;
    }
}


