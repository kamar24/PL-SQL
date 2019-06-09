/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author cp24
 */
public class Cho_Wiz {
    
    public Wizyty wizyta;
    public Choroby choroba;

    public Cho_Wiz(Wizyty wizyta, Choroby choroba) {
        this.wizyta = wizyta;
        this.choroba = choroba;
    }
    public Cho_Wiz(){}
    

    public Wizyty getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyty wizyta) {
        this.wizyta = wizyta;
    }

    public Choroby getChoroba() {
        return choroba;
    }

    public void setChoroba(Choroby choroba) {
        this.choroba = choroba;
    }

    @Override
    public String toString() {
        return  choroba.getNazwa();
    }
    
    
    
    

  
  

   

    

    

    
    

  
    
    
}
