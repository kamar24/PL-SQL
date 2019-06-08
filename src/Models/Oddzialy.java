package Models;



public class Oddzialy {
    
    
    private int id_oddzialu;
    
    
    private String nazwa;

    public Oddzialy(int id_oddzialu, String nazwa) {
        this.id_oddzialu = id_oddzialu;
        this.nazwa = nazwa;
    }
    
   
    public Oddzialy(){}

    public int getId_oddzialu() {
        return id_oddzialu;
    }

    public void setId_oddzialu(int id_oddzialu) {
        this.id_oddzialu = id_oddzialu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
   
        
    
        
        
}

