package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class OtkupStavka extends Entitet {

    @ManyToOne
    private OtkupZaglavlje otkupZaglavlje;

    @ManyToOne
    private Knjiga knjiga;

    private Integer kolicina;

    private BigDecimal cijenaOtkupaArtikla;

    private BigDecimal cijenaOtkupa;

    public OtkupStavka(int id, OtkupZaglavlje otkupZaglavlje, Knjiga knjiga, Integer kolicina, BigDecimal cijenaOtkupaArtikla, BigDecimal cijenaOtkupa) {
        super(id);
        this.otkupZaglavlje = otkupZaglavlje;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        this.cijenaOtkupaArtikla = cijenaOtkupaArtikla;
        this.cijenaOtkupa = cijenaOtkupa;
    }

    public OtkupStavka() {

    }

    public OtkupZaglavlje getOtkupZaglavlje() {
        return otkupZaglavlje;
    }

    public void setOtkupZaglavlje(OtkupZaglavlje otkupZaglavlje) {
        this.otkupZaglavlje = otkupZaglavlje;
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

    public BigDecimal getCijenaOtkupaArtikla() {
        return cijenaOtkupaArtikla;
    }

    public void setCijenaOtkupaArtikla(BigDecimal cijenaOtkupaArtikla) {
        this.cijenaOtkupaArtikla = cijenaOtkupaArtikla;
    }

    public BigDecimal getCijenaOtkupa() {
        return cijenaOtkupa;
    }

    public void setCijenaOtkupa(BigDecimal cijenaOtkupa) {
        this.cijenaOtkupa = cijenaOtkupa;
    }

    @Override
    public String toString() {
        return "ID: " + String.valueOf(getId()) + " | " + knjiga.getAutor().getNazivAutora() + ", " + knjiga.getNazivKnjige() + " | količina: " + String.valueOf(kolicina) 
                + " | cijena: " + String.valueOf(cijenaOtkupaArtikla) + " | iznos: " +  String.valueOf(cijenaOtkupa);
    }
}
