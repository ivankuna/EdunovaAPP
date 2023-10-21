package antikvarijat.model;

import antikvarijat.util.Tools;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
public class OtkupZaglavlje extends Entitet {

    private Date datumOtkupa;

    @ManyToOne
    private Partner partner;

    @ManyToOne
    private Operater operater;

    @OneToMany(mappedBy = "otkupZaglavlje")
    private List<OtkupStavka> otkupi = new ArrayList<>();

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

    public List<OtkupStavka> getOtkupi() {
        return otkupi;
    }

    public void setOtkupi(List<OtkupStavka> otkupi) {
        this.otkupi = otkupi;
    }

    @Override
    public String toString() {
        return "Br. otkupa: " + String.valueOf(getId()) + " | " + "formatirati datum" + " | "
                + operater.getIme() + " " + operater.getPrezime() + " (" + operater.getUloga() + ")";

    }
}
