package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NacinPlacanja extends Entitet {    
    
    private String nazivNacinaPlacanja;
    
    private String oznakaNacinaPlacanja;
    
    @OneToMany(mappedBy = "nacinPlacanja")
    private List<ProdajaZaglavlje> prodaje = new ArrayList<>();

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

    public List<ProdajaZaglavlje> getProdaje() {
        return prodaje;
    }

    public void setProdaje(List<ProdajaZaglavlje> prodaje) {
        this.prodaje = prodaje;
    }    

    @Override
    public String toString() {
        return nazivNacinaPlacanja;
    }        
}
