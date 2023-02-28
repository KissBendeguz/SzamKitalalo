package models;

import models.interfaces.IOkosTippelo;
import java.util.Scanner;

public class EmberiJatekos implements IOkosTippelo {
    @Override
    public void Nyert() {
        System.out.println("*Nyertél!");
    }

    @Override
    public void Veszitett() {
        System.out.println("*Veszítettél!");
    }

    @Override
    public void Kisebb() {
        System.out.println("*Az előző tippnél kisebb a keresett szám");
    }

    @Override
    public void Nagyobb() {
        System.out.println("*Az előző tippnél nagyobb a keresett szám");
    }

    @Override
    public void JatekIndul(int alsoHatar, int felsoHatar) {
        System.out.printf("*Jatek indul az alábbi határok között: [%d,%d]\n",alsoHatar,felsoHatar);
    }

    @Override
    public int KovetkezoTipp() {
        int tipp=0;
        System.out.print("*Add meg a következő tippet: ");
        Scanner in = new Scanner(System.in);
        tipp = in.nextInt();
        return tipp;
    }
}
