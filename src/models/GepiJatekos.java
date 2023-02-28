package models;

import models.interfaces.IStatisztikatSzolgaltat;
import models.interfaces.ITippelo;

public abstract class GepiJatekos implements ITippelo, IStatisztikatSzolgaltat {
    public int alsoHatar, felsoHatar;
    int nyertDB, veszitettDB;

    public int HanyszorNyert(){
        return this.nyertDB;
    }
    public int HanyszorVeszitett(){
        return this.veszitettDB;
    }

    public void JatekIndul(int alsoHatar,int felsoHatar){
        this.alsoHatar = alsoHatar;
        this.felsoHatar = felsoHatar;
    }

    public void Nyert(){
        this.nyertDB++;
    };

    public void Veszitett(){
        this.veszitettDB++;
    }

}
