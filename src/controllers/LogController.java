package controllers;

import models.interfaces.INaploz;

public class LogController implements INaploz {
    @Override
    public void naplobalr(String szoveg) {
        System.out.println(szoveg);
    }
}
