package controllers;


import models.interfaces.INaploz;
import models.interfaces.IOkosTippelo;
import models.interfaces.IStatisztikatSzolgaltat;
import models.interfaces.ITippelo;

import java.util.Random;

public class SzamKitalaloJatek {
    final byte MAX_VERSENYZO = 5;
    ITippelo[] versenyzok = new ITippelo[MAX_VERSENYZO];
    int versenyzoN = 0;
    int alsoHatar;
    int felsoHatar;
    int cel;

    INaploz iNaploz;


    public void VersenyzoFelvetele(ITippelo versenyzo){
        if(versenyzoN<5) {
            versenyzok[versenyzoN++] = versenyzo;
        }
    }

    public void VersenyIndul() {
        if (iNaploz != null) {
            iNaploz.naplobalr("VersenyIndul");
        }

        Random rnd = new Random();

        this.cel = rnd.nextInt((this.felsoHatar-this.alsoHatar)+1)+this.alsoHatar;
        if (iNaploz != null) {
            iNaploz.naplobalr("\tcel: "+cel);
        }

        for (ITippelo jatekos:this.versenyzok) {
            if(jatekos == null){ break; }
            jatekos.JatekIndul(this.alsoHatar,this.felsoHatar);
        }
    }

    public boolean MindenkiTippel(){
        if (iNaploz != null) {
            iNaploz.naplobalr("MindenkiTippel");
        }
        boolean voltNyertes = false;
        for (int i = 0; i < versenyzoN; i++) {
            ITippelo jatekos = versenyzok[i];
            int tipp = jatekos.KovetkezoTipp();
            if (iNaploz != null) {
                iNaploz.naplobalr("\t"+jatekos.getClass().getSimpleName()+" tippje: "+tipp);
            }
            if (tipp == this.cel){
                voltNyertes = true;
                jatekos.Nyert();
                for (int j = 0; j < versenyzoN; j++) {
                    if(!jatekos.equals(versenyzok[j])){
                        versenyzok[j].Veszitett();
                    }
                }
            }else{
                if(jatekos instanceof IOkosTippelo) {
                    if(tipp > this.cel){
                        ((IOkosTippelo) jatekos).Kisebb();
                    }else{
                        ((IOkosTippelo) jatekos).Nagyobb();
                    }
                }
            }
        }

        return voltNyertes;
    }

    @SuppressWarnings({"StatementWithEmptyBody"})
    public void Jatek(){
        this.VersenyIndul();
        while(!MindenkiTippel());
    }

    public SzamKitalaloJatek(int alsoHatar,int felsoHatar){
        this.alsoHatar = alsoHatar;
        this.felsoHatar = felsoHatar;

        this.iNaploz = new LogController();
    }

    public void Statisztika(int korokSzama){
        for (int i = 0; i < korokSzama; i++) {
            this.Jatek();
        }
        for (int i = 0; i < versenyzoN; i++) {
            if (versenyzok[i] instanceof IStatisztikatSzolgaltat){
                if (iNaploz != null) {
                    iNaploz.naplobalr(
                            i+". játékos (Interfesz. "+
                            versenyzok[i].getClass().getSimpleName()+
                            "),\tNY: "+((IStatisztikatSzolgaltat) versenyzok[i]).HanyszorNyert()+
                            "\tV: "+((IStatisztikatSzolgaltat) versenyzok[i]).HanyszorVeszitett()
                    );
                }
            }
        }

    }


}
