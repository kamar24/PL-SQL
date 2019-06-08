package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class Pacjenci {
    
    private int id_pacjenta;
    
    private String imie;
    
    private String nazwisko;
    
    private String pesel;
    
    private String nr_tel;
    
    private String Ulica;
    
    private String Kod_pocztowy;
    
    private String Miasto;
   
    private String Ubezpieczenie;

    public Pacjenci(int id_pacjenta, String imie, String nazwisko, String pesel, String nr_tel, String Ulica, String Kod_pocztowy, String Miasto, String Ubezpieczenie) {
        this.id_pacjenta = id_pacjenta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nr_tel = nr_tel;
        this.Ulica = Ulica;
        this.Kod_pocztowy = Kod_pocztowy;
        this.Miasto = Miasto;
        this.Ubezpieczenie = Ubezpieczenie;
    }
    
    public Pacjenci(){}

    public int getId_pacjenta() {
        return id_pacjenta;
    }

    public void setId_pacjenta(int id_pacjenta) {
        this.id_pacjenta = id_pacjenta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String Ulica) {
        this.Ulica = Ulica;
    }

    public String getKod_pocztowy() {
        return Kod_pocztowy;
    }

    public void setKod_pocztowy(String Kod_pocztowy) {
        this.Kod_pocztowy = Kod_pocztowy;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String Miasto) {
        this.Miasto = Miasto;
    }

    public String getUbezpieczenie() {
        return Ubezpieczenie;
    }

    public void setUbezpieczenie(String Ubezpieczenie) {
        this.Ubezpieczenie = Ubezpieczenie;
    }

    @Override
    public String toString() {
        return  imie + " " + nazwisko + " " + pesel ;
    }

    
    
    

  
    
    
    
    
   
}

