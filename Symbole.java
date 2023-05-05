
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
            symblist = new String[]{"Bonus", "Free", "Super", "Bar", "Seven", "Cherry", "Plum", "Bell", "Melon", "Orange", "Lemon"};
        } else if (this.freesymb) {
            symblist = new String[]{"Bonus", "Free", "Bar", "Seven", "Cherry", "Plum", "Bell", "Melon", "Orange", "Lemon"};
        } else if (this.supersymb) {
            symblist = new String[]{"Bonus", "Super", "Bar", "Seven", "Cherry", "Plum", "Bell", "Melon", "Orange", "Lemon"};
        } else {
            symblist = new String[]{"Bonus", "Bar", "Seven", "Cherry", "Plum", "Bell", "Melon", "Orange", "Lemon"};
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(symblist.length);
        this.nom = symblist[randomIndex];

        if (nom.contains("Bar")) {
            this.gain5 = 4000;
            this.gain4 = 2000;
            this.gain3 = 1000;
            this.id = 1;
        } else if (nom.contains("Seven")) {
            this.gain5 = 3000;
            this.gain4 = 1500;
            this.gain3 = 750;
            this.id = 2;
        } else if (nom.contains("Cherry")) {
            this.gain5 = 1500;
            this.gain4 = 750;
            this.gain3 = 500;
            this.id = 3;
        } else if (nom.contains("Plum")) {
            this.gain5 = 1500;
            this.gain4 = 1000;
            this.gain3 = 1000;
            this.id = 4;
        } else if (nom.contains("Bell")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 5;
        } else if (nom.contains("Melon")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 6;
        } else if (nom.contains("Orange")) {
            this.gain5 = 1000;
            this.gain4 = 500;
            this.gain3 = 300;
            this.id = 7;
        } else if (nom.contains("Lemon")) {
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


