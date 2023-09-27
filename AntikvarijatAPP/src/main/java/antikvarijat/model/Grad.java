package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grad extends Entitet {
    
    private String nazivGrada;
    
    private String postanskiBroj;
    
    @ManyToOne
    private Drzava drzava;
    
    @OneToMany(mappedBy = "grad")
    private List<Izdavac> izdavaci = new ArrayList<>();
    
    @OneToMany(mappedBy = "grad")
    private List<Partner> partneri = new ArrayList<>();

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

    public List<Izdavac> getIzdavaci() {
        return izdavaci;
    }

    public void setIzdavaci(List<Izdavac> izdavaci) {
        this.izdavaci = izdavaci;
    }

    public List<Partner> getPartneri() {
        return partneri;
    }

    public void setPartneri(List<Partner> partneri) {
        this.partneri = partneri;
    }    
}
