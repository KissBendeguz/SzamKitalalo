package models;

import models.interfaces.INaploz;

public class BejaroTippelo extends GepiJatekos {
    int aktualis;

    @Override
    public int KovetkezoTipp() {
        int tipp = aktualis++;
        return tipp;
    }

    public void JatekIndul(int alsoHatar,int felsoHatar){
        super.JatekIndul(alsoHatar,felsoHatar);
        this.aktualis = alsoHatar;

    }


}
