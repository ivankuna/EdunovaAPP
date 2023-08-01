package model;

import java.time.LocalDateTime;

public class OtkupZaglavlje extends Entitet {
    private int brojOtkupa;
    private LocalDateTime datumOtkupa;
    private Partner partner;
    private Operater operater;

    public OtkupZaglavlje(int id, int brojOtkupa, LocalDateTime datumOtkupa, Partner partner, Operater operater) {
        super(id);
        this.brojOtkupa = brojOtkupa;
        this.datumOtkupa = datumOtkupa;
        this.partner = partner;
        this.operater = operater;
    }
    public OtkupZaglavlje() {

    }
    public int getBrojOtkupa() {
        return brojOtkupa;
    }
    public void setBrojOtkupa(int brojOtkupa) {
        this.brojOtkupa = brojOtkupa;
    }
    public LocalDateTime getDatumOtkupa() {
        return datumOtkupa;
    }
    public void setDatumOtkupa(LocalDateTime datumOtkupa) {
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

    @Override
    public String toString() {
        return String.valueOf(brojOtkupa);
    }
}
