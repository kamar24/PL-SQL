/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Lukasz
 */
public class Lek_Spec {
    public Lekarze lekarz;
    public Specjalizacje specjalizacja;

    public Lek_Spec(Lekarze lekarz, Specjalizacje specjalizacja) {
        this.lekarz = lekarz;
        this.specjalizacja = specjalizacja;
    }
    public Lek_Spec (){}

    public Lekarze getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarze lekarz) {
        this.lekarz = lekarz;
    }

    public Specjalizacje getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(Specjalizacje specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    @Override
    public String toString() {
        return lekarz.getImie()+ " "+lekarz.getNazwisko()+" "+lekarz.getPesel() ;
    }
    
    
    
}
