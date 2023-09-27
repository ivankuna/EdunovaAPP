package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class OtkupZaglavlje extends Entitet {
       
    private Date datumOtkupa;
    
    @ManyToOne
    private Partner partner;

    @ManyToOne
    private Operater operater;

    public OtkupZaglavlje(int id, Date datumOtkupa, Partner partner, Operater operater) {
        super(id);        
        this.datumOtkupa = datumOtkupa;
        this.partner = partner;
        this.operater = operater;
    }
    
    public OtkupZaglavlje() {
        
    }
    
    public Date getDatumOtkupa() {
        return datumOtkupa;
    }

    public void setDatumOtkupa(Date datumOtkupa) {
        this.datumOtkupa = datumOtkupa;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Operater getOperater() {
        return operater;
    }

    public void setOperater(Operater operater) {
        this.operater = operater;
    }    
}
