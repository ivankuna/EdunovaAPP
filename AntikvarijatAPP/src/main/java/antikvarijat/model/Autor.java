package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor extends Entitet {
    
    private String nazivAutora;
    
    @ManyToOne
    private Drzava drzava;
    
    @OneToMany(mappedBy = "autor")
    private List<Knjiga> knjige = new ArrayList<>();

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

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }    

    @Override
    public String toString() {
        return nazivAutora;
    }        
}
