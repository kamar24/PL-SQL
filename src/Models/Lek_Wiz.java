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
public class Lek_Wiz {
    public Leki lek;
    public Wizyty wizyta;

    public Lek_Wiz(Leki lek, Wizyty wizyta) {
        this.lek = lek;
        this.wizyta = wizyta;
    }
    public Lek_Wiz(){}

    public Leki getLek() {
        return lek;
    }

    public void setLek(Leki lek) {
        this.lek = lek;
    }

    public Wizyty getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyty wizyta) {
        this.wizyta = wizyta;
    }

    @Override
    public String toString() {
        return lek.getNazwa();
    }
    
}
