package models;

import java.util.Random;

public class VeletlenTippelo extends GepiJatekos {
    @Override
    public int KovetkezoTipp() {
        Random rnd = new Random();
        int tipp = rnd.nextInt((felsoHatar-alsoHatar)+1)+alsoHatar;
        return tipp;

    }
}
