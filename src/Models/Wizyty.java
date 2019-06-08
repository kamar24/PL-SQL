package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Wizyty  {
    
   
    private int id_wizyty;
   
    private String objawy;
    
    private Date nast_wizyta;
    
    private Date data_wizyty;
    
    public Lekarze lekarze;
    
    public Pacjenci pacjenci;

    @Override
    public String toString() {
        return data_wizyty + ", lekarz: "+lekarze.getImie()+ lekarze.getNazwisko() + ", pacjent: "+pacjenci.getImie()+pacjenci.getNazwisko();
    }

   

    public Wizyty(int id_wizyty, String objawy, Date nast_wizyta, Date data_wizyty, Lekarze lekarze, Pacjenci pacjenci) {
        this.id_wizyty = id_wizyty;
        this.objawy = objawy;
        this.nast_wizyta = nast_wizyta;
        this.data_wizyty = data_wizyty;
        this.lekarze = lekarze;
        this.pacjenci = pacjenci;
    }
    public Wizyty(){}

    public int getId_wizyty() {
        return id_wizyty;
    }

    public void setId_wizyty(int id_wizyty) {
        this.id_wizyty = id_wizyty;
    }

    public String getObjawy() {
        return objawy;
    }

    public void setObjawy(String objawy) {
        this.objawy = objawy;
    }

    public Date getNast_wizyta() {
        return nast_wizyta;
    }

    public void setNast_wizyta(Date nast_wizyta) {
        this.nast_wizyta = nast_wizyta;
    }

    public Date getData_wizyty() {
        return data_wizyty;
    }

    public void setData_wizyty(Date data_wizyty) {
        this.data_wizyty = data_wizyty;
    }

    public Lekarze getLekarze() {
        return lekarze;
    }

    public void setLekarze(Lekarze lekarze) {
        this.lekarze = lekarze;
    }

    public Pacjenci getPacjenci() {
        return pacjenci;
    }

    public void setPacjenci(Pacjenci pacjenci) {
        this.pacjenci = pacjenci;
    }

   

   
    
   
}
