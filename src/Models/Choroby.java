package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





public class Choroby {
    
    
   
    private int id_choroby;
    
    
    private String nazwa;

    public Choroby(int id_choroby, String nazwa) {
        this.id_choroby = id_choroby;
        this.nazwa = nazwa;
    }

    public Choroby (){}

    public int getId_choroby() {
        return id_choroby;
    }

    public void setId_choroby(int id_choroby) {
        this.id_choroby = id_choroby;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return nazwa;
    }
    
    

  
    
    
    
}
