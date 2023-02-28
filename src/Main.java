import controllers.SzamKitalaloJatek;
import controllers.SzamKitalaloJatekKaszino;
import models.BejaroTippelo;
import models.EmberiJatekos;
import models.LogaritmikusKereso;
import models.VeletlenTippelo;
import models.interfaces.ITippelo;


public class Main {

    public static void main(String[] args) {
        SzamKitalaloJatek szamKitalaloJatek = new SzamKitalaloJatek(10,50);
        SzamKitalaloJatekKaszino szamKitalaloJatekKaszino = new SzamKitalaloJatekKaszino(1,100,6);

        ITippelo[] jatekosok = {new VeletlenTippelo(),
                                new BejaroTippelo(),
                                new LogaritmikusKereso()};
                                //new EmberiJatekos()};

        for (ITippelo jatekos:jatekosok) {
            //szamKitalaloJatek.VersenyzoFelvetele(jatekos);
            szamKitalaloJatekKaszino.VersenyzoFelvetele(jatekos);
        }

        //szamKitalaloJatek.Jatek();
        //szamKitalaloJatek.Statisztika(1000);
        szamKitalaloJatekKaszino.Statisztika(1000);


    }

}