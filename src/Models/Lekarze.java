package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Lekarze {
    
    private int id_lekarza;
       
    private String imie;
       
    private String nazwisko;
     
    private String pesel;
    
    private String nr_tel;
      
    private Date data_zat;
       
    private Integer wynagrodzenie;
      
    private Integer nr_gabinetu;

    public Lekarze(int id_lekarza, String imie, String nazwisko, String pesel, String nr_tel, Date data_zat, Integer wynagrodzenie, Integer nr_gabinetu) {
        this.id_lekarza = id_lekarza;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nr_tel = nr_tel;
        this.data_zat = data_zat;
        this.wynagrodzenie = wynagrodzenie;
        this.nr_gabinetu = nr_gabinetu;
    }
 public Lekarze(){}

    public int getId_lekarza() {
        return id_lekarza;
    }

    public void setId_lekarza(int id_lekarza) {
        this.id_lekarza = id_lekarza;
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

    public Date getData_zat() {
        return data_zat;
    }

    public void setData_zat(Date data_zat) {
        this.data_zat = data_zat;
    }

    public Integer getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(Integer wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public Integer getNr_gabinetu() {
        return nr_gabinetu;
    }

    public void setNr_gabinetu(Integer nr_gabinetu) {
        this.nr_gabinetu = nr_gabinetu;
    }

    @Override
    public String toString() {
         return  imie + " " + nazwisko + " " + pesel ;
    }

  

    
 
   
    
    
    
   
}
