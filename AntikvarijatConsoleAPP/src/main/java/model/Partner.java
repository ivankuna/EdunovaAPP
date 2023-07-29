package model;

public class Partner extends Entitet {
    private String nazivPartnera;
    private String ulicaBroj;
    private String oib;
    private String email;
    private String telefon;
    private Grad grad;

    public Partner(int id, String nazivPartnera, String ulicaBroj, String oib, String email, String telefon, Grad grad) {
        super(id);
        this.nazivPartnera = nazivPartnera;
        this.ulicaBroj = ulicaBroj;
        this.oib = oib;
        this.email = email;
        this.telefon = telefon;
        this.grad = grad;
    }
    public Partner() {

    }
    public String getNazivPartnera() {
        return nazivPartnera;
    }
    public void setNazivPartnera(String nazivPartnera) {
        this.nazivPartnera = nazivPartnera;
    }
    public String getUlicaBroj() {
        return ulicaBroj;
    }
    public void setUlicaBroj(String ulicaBroj) {
        this.ulicaBroj = ulicaBroj;
    }
    public String getOib() {
        return oib;
    }
    public void setOib(String oib) {
        this.oib = oib;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public Grad getGrad() {
        return grad;
    }
    public void setGrad(Grad grad) {
        this.grad = grad;
    }
    @Override
    public String toString() {
        return null;
    }
}
