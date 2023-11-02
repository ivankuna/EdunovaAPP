package antikvarijat.model;

import antikvarijat.util.Tools;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ProdajaZaglavlje extends Entitet {        
    
    private Date datumProdaje;
    
    @ManyToOne
    private Partner partner;
    
    @ManyToOne
    private NacinPlacanja nacinPlacanja;
    
    @ManyToOne
    private Operater operater;    

    public ProdajaZaglavlje(int id, Date datumProdaje, Partner partner, NacinPlacanja nacinPlacanja, Operater operater) {
        super(id);        
        this.datumProdaje = datumProdaje;
        this.partner = partner;
        this.nacinPlacanja = nacinPlacanja;
        this.operater = operater;
    }
    
    public ProdajaZaglavlje() {
        
    }
    
    public Date getDatumProdaje() {
        return datumProdaje;
    }

    public void setDatumProdaje(Date datumProdaje) {
        this.datumProdaje = datumProdaje;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public NacinPlacanja getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }

    public Operater getOperater() {
        return operater;
    }

    public void setOperater(Operater operater) {
        this.operater = operater;
    }
    
    @Override
    public String toString() {
        return "ID: " + String.valueOf(getId()) + " | " + Tools.DATE_FORMAT.format(datumProdaje) + " | partner: " + partner.getNazivPartnera();
    }
}
