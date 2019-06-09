package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Collection;


public class Leki {
   
  
    private int id_leku;
    
    private String nazwa;
    
   

    public Leki(int id_leku, String nazwa) {
        this.id_leku = id_leku;
        this.nazwa = nazwa;
       
    }
    
    public Leki(){}

    public int getId_leku() {
        return id_leku;
    }

    public void setId_leku(int id_leku) {
        this.id_leku = id_leku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

  
   
}
