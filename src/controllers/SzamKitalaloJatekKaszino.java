package controllers;

import models.interfaces.IStatisztikatSzolgaltat;

public class SzamKitalaloJatekKaszino extends SzamKitalaloJatek implements IStatisztikatSzolgaltat{
    int kaszinoNyert;
    int kaszinoVeszitett;
    int korokSzama;


    public SzamKitalaloJatekKaszino(int alsoHatar, int felsoHatar,int korokSzama) {
        super(alsoHatar, felsoHatar);
        this.korokSzama = korokSzama;
    }

    @Override
    public int HanyszorNyert() {
        return this.kaszinoNyert;
    }

    @Override
    public int HanyszorVeszitett() {
        return this.kaszinoVeszitett;
    }

    @Override
    @SuppressWarnings({"StatementWithEmptyBody"})
    public void Jatek() {
        super.VersenyIndul();

        int i=0;
        while(!MindenkiTippel() && i++<this.korokSzama);
        if (i<this.korokSzama){
            this.kaszinoVeszitett++;
        }else{
            this.kaszinoNyert++;
        }
    }


    public void Statisztika(int korokSzama) {
        super.Statisztika(korokSzama);
        System.out.printf("Kaszino, NY:%d V:%d",this.HanyszorNyert(),this.HanyszorVeszitett());
    }
}
