package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author Lukasz
 */

public class Premie {


    private int id_premii;
    
    private String nazwa;
    
    private float wysokosc;

    public Premie(int id_premii, String nazwa, float wysokosc) {
        this.id_premii = id_premii;
        this.nazwa = nazwa;
        this.wysokosc = wysokosc;
    }

    
     public Premie(){}

    public int getId_premii() {
        return id_premii;
    }

    public void setId_premii(int id_premii) {
        this.id_premii = id_premii;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(float wysokosc) {
        this.wysokosc = wysokosc;
    }
     
}

