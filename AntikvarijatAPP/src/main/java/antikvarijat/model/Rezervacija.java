package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Rezervacija extends Entitet {
    
    @ManyToOne
    private Partner partner;
    
    @ManyToOne
    private Knjiga knjiga;
    
    private String stanje;
    
    @ManyToOne
    private Operater operater;
    
    private Date datumRezervacije;

    public Rezervacija(int id, Partner partner, Knjiga knjiga, String stanje, Operater operater, Date datumRezervacije) {
        super(id);
        this.partner = partner;
        this.knjiga = knjiga;
        this.stanje = stanje;
        this.operater = operater;
        this.datumRezervacije = datumRezervacije;
    }
    
    public Rezervacija() {
        
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    public Operater getOperater() {
        return operater;
    }

    public void setOperater(Operater operater) {
        this.operater = operater;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }
    
    @Override
    public String toString() {
        return "ID: " + String.valueOf(getId()) + " | " + knjiga.getAutor().getNazivAutora() + ", " + knjiga.getNazivKnjige() + " | partner: " 
                + partner.getNazivPartnera() + " | stanje rezervacije: " + stanje;
    }       
}
