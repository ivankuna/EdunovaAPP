package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drzava extends Entitet {

    private String nazivDrzave;
    
    @OneToMany(mappedBy = "drzava")
    private List<Grad> gradovi = new ArrayList<>();

    public Drzava(int id, String nazivDrzave) {
        super(id);
        this.nazivDrzave = nazivDrzave;
    }

    public Drzava() {

    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public List<Grad> getGradovi() {
        return gradovi;
    }

    public void setGradovi(List<Grad> gradovi) {
        this.gradovi = gradovi;
    }    

    @Override
    public String toString() {
        return nazivDrzave;
    }    
}
