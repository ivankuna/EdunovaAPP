package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ProdajaZaglavlje extends Entitet {
    
    private Integer brojProdaje;
    
    private Date datumProdaje;
    
    @ManyToOne
    private Partner partner;
    
    @ManyToOne
    private NacinPlacanja nacinPlacanja;
    
    @ManyToOne
    private Operater operater;

    public ProdajaZaglavlje(int id, Integer brojProdaje, Date datumProdaje, Partner partner, NacinPlacanja nacinPlacanja, Operater operater) {
        super(id);
        this.brojProdaje = brojProdaje;
        this.datumProdaje = datumProdaje;
        this.partner = partner;
        this.nacinPlacanja = nacinPlacanja;
        this.operater = operater;
    }
    
    public ProdajaZaglavlje() {
        
    }

    public Integer getBrojProdaje() {
        return brojProdaje;
    }

    public void setBrojProdaje(Integer brojProdaje) {
        this.brojProdaje = brojProdaje;
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
}
