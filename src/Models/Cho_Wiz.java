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
    
    private int id_choroby;
    private int id_wizyty;

    public Cho_Wiz(int id_choroby, int id_wizyty) {
        this.id_choroby = id_choroby;
        this.id_wizyty = id_wizyty;
    }
    
    public Cho_Wiz(){};

    public int getId_choroby() {
        return id_choroby;
    }

    public void setId_choroby(int id_choroby) {
        this.id_choroby = id_choroby;
    }

    public int getId_wizyty() {
        return id_wizyty;
    }

    public void setId_wizyty(int id_wizyty) {
        this.id_wizyty = id_wizyty;
    }
    
}
