package antikvarijat.model;

import jakarta.persistence.Entity;

@Entity
public class Operater extends Entitet {
    
    private String ime;
    
    private String prezime;
    
    private String oib;
    
    private String email;
    
    private String korisnickoIme;
    
    private String lozinka;

    public Operater(int id, String ime, String prezime, String oib, String email, String korisnickoIme, String lozinka) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    
    public Operater() {
        
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }    
}

