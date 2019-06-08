package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class Urlopy {
    
    
    private int id_urlopu;
      
   
    private String data_pocz;
    
 
    private String data_kon;
    
       
    public Lekarze lekarze;

    public Urlopy(int id_urlopu, String data_pocz, String data_kon, Lekarze lekarze) {
        this.id_urlopu = id_urlopu;
        this.data_pocz = data_pocz;
        this.data_kon = data_kon;
        this.lekarze = lekarze;
    }

   public Urlopy (){}

    public int getId_urlopu() {
        return id_urlopu;
    }

    public void setId_urlopu(int id_urlopu) {
        this.id_urlopu = id_urlopu;
    }

    public String getData_pocz() {
        return data_pocz;
    }

    public void setData_pocz(String data_pocz) {
        this.data_pocz = data_pocz;
    }

    public String getData_kon() {
        return data_kon;
    }

    public void setData_kon(String data_kon) {
        this.data_kon = data_kon;
    }

    public Lekarze getLekarze() {
        return lekarze;
    }

    public void setLekarze(Lekarze lekarze) {
        this.lekarze = lekarze;
    }
   
   
    
}
