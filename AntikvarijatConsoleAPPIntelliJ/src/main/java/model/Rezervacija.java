package model;

public class Rezervacija extends Entitet {
    private Partner partner;
    private Knjiga knjiga;
    private String stanje;
    private Operater operater;

    public Rezervacija(int id, Partner partner, Knjiga knjiga, String stanje, Operater operater) {
        super(id);
        this.partner = partner;
        this.knjiga = knjiga;
        this.stanje = stanje;
        this.operater = operater;
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

    @Override
    public String toString() {
        return stanje;
    }
}
