package Models;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class Urlopy {
    
    
    private int id_urlopu;
      
   
    private Date data_pocz;
    
 
    private Date data_konc;
    
       
    public Lekarze lekarze;

    public Urlopy(int id_urlopu, Date data_pocz, Date data_konc, Lekarze lekarze) {
        this.id_urlopu = id_urlopu;
        this.data_pocz = data_pocz;
        this.data_konc = data_konc;
        this.lekarze = lekarze;
    }

    public Urlopy(){}

    public int getId_urlopu() {
        return id_urlopu;
    }

    public void setId_urlopu(int id_urlopu) {
        this.id_urlopu = id_urlopu;
    }

    public Date getData_pocz() {
        return data_pocz;
    }

    public void setData_pocz(Date data_pocz) {
        this.data_pocz = data_pocz;
    }

    public Date getData_konc() {
        return data_konc;
    }

    public void setData_konc(Date data_konc) {
        this.data_konc = data_konc;
    }

    public Lekarze getLekarze() {
        return lekarze;
    }

    public void setLekarze(Lekarze lekarze) {
        this.lekarze = lekarze;
    }

    @Override
    public String toString() {
        return "Urlopy{" + "id_urlopu=" + id_urlopu + ", data_pocz=" + data_pocz + ", data_konc=" + data_konc + ", lekarze=" + lekarze + '}';
    }

   
   
   
    
}
