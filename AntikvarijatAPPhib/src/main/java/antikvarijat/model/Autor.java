package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Autor extends Entitet {
    
    private String nazivAutora;
    
    @ManyToOne
    private Drzava drzava;

    public Autor(int id, String nazivAutora, Drzava drzava) {
        super(id);
        this.nazivAutora = nazivAutora;
        this.drzava = drzava;
    }
    
    public Autor() {
        
    }

    public String getNazivAutora() {
        return nazivAutora;
    }

    public void setNazivAutora(String nazivAutora) {
        this.nazivAutora = nazivAutora;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }    
}
