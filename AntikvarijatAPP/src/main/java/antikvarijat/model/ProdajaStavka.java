package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class ProdajaStavka extends Entitet {
    
    @ManyToOne
    private ProdajaZaglavlje prodajaZaglavlje;
    
    @ManyToOne
    private Knjiga knjiga;
    
    private Integer kolicina;
    
    private BigDecimal cijenaProdaje;

    public ProdajaStavka(int id, ProdajaZaglavlje prodajaZaglavlje, Knjiga knjiga, Integer kolicina, BigDecimal cijenaProdaje) {
        super(id);
        this.prodajaZaglavlje = prodajaZaglavlje;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        this.cijenaProdaje = cijenaProdaje;
    }
    
    public ProdajaStavka() {
        
    }

    public ProdajaZaglavlje getProdajaZaglavlje() {
        return prodajaZaglavlje;
    }

    public void setProdajaZaglavlje(ProdajaZaglavlje prodajaZaglavlje) {
        this.prodajaZaglavlje = prodajaZaglavlje;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public BigDecimal getCijenaProdaje() {
        return cijenaProdaje;
    }

    public void setCijenaProdaje(BigDecimal cijenaProdaje) {
        this.cijenaProdaje = cijenaProdaje;
    }    
    
    @Override
    public String toString() {
        return "ID: " + String.valueOf(getId()) + " | " + knjiga.getAutor().getNazivAutora() + ", " + knjiga.getNazivKnjige() + " | količina: " + String.valueOf(kolicina) 
                + " | cijena: " + String.valueOf(knjiga.getCijena()) + " | iznos: " +  String.valueOf(cijenaProdaje);
    }
}

