package antikvarijat.model;

import jakarta.persistence.Entity;

@Entity
public class NacinPlacanja extends Entitet {    
    
    private String nazivNacinaPlacanja;
    
    private String oznakaNacinaPlacanja;

    public NacinPlacanja(int id, String nazivNacinaPlacanja, String oznakaNacinaPlacanja) {
        super(id);
        this.nazivNacinaPlacanja = nazivNacinaPlacanja;
        this.oznakaNacinaPlacanja = oznakaNacinaPlacanja;
    }
    
    public NacinPlacanja() {
        
    }

    public String getNazivNacinaPlacanja() {
        return nazivNacinaPlacanja;
    }

    public void setNazivNacinaPlacanja(String nazivNacinaPlacanja) {
        this.nazivNacinaPlacanja = nazivNacinaPlacanja;
    }

    public String getOznakaNacinaPlacanja() {
        return oznakaNacinaPlacanja;
    }

    public void setOznakaNacinaPlacanja(String oznakaNacinaPlacanja) {
        this.oznakaNacinaPlacanja = oznakaNacinaPlacanja;
    }
}
