package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author Lukasz
 */

public class Specjalizacje {
    
    
    private int id_specjalizacji;
    
    
    private String nazwa;
    
   
    public Oddzialy oddzialy;

    public Specjalizacje(int id_specjalizacji, String nazwa, Oddzialy oddzialy) {
        this.id_specjalizacji = id_specjalizacji;
        this.nazwa = nazwa;
        this.oddzialy = oddzialy;
    }

   public Specjalizacje(){}

    public int getId_specjalizacji() {
        return id_specjalizacji;
    }

    public void setId_specjalizacji(int id_specjalizacji) {
        this.id_specjalizacji = id_specjalizacji;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Oddzialy getOddzialy() {
        return oddzialy;
    }

    public void setOddzialy(Oddzialy oddzialy) {
        this.oddzialy = oddzialy;
    }

    @Override
    public String toString() {
        return "Specjalizacje: " + nazwa + ", oddzialy: " + oddzialy.getNazwa();
    }
   
   
    
    

   
    
    
    
    
    
}
