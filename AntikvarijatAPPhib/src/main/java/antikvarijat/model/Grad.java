package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Grad extends Entitet {
    
    private String nazivGrada;
    
    private String postanskiBroj;
    
    @ManyToOne
    private Drzava drzava;

    public Grad(int id, String nazivGrada, String postanskiBroj, Drzava drzava) {
        super(id);
        this.nazivGrada = nazivGrada;
        this.postanskiBroj = postanskiBroj;
        this.drzava = drzava;
    }
    
    public Grad() {
        
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }   
}
