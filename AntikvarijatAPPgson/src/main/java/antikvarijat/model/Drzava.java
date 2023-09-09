package antikvarijat.model;

import jakarta.persistence.Entity;

@Entity
public class Drzava extends Entitet {

    private String nazivDrzave;

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
}
