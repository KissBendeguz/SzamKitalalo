package models;
import models.interfaces.IOkosTippelo;

public class LogaritmikusKereso extends GepiJatekos implements IOkosTippelo{

    private int tipp;
    @Override
    public void Kisebb() {
        this.felsoHatar = tipp;
    }

    @Override
    public void Nagyobb() {
        this.alsoHatar = tipp;
    }

    @Override
    public int KovetkezoTipp() {
        this.tipp = (this.alsoHatar+this.felsoHatar)/2;
        return this.tipp;
    }
}
