package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Operater extends Entitet {
    
    private String ime;
    
    private String prezime;
    
    private String oib;
    
    private String email;        
    
    private String lozinka;
    
    private String uloga;
    
    @OneToMany(mappedBy = "operater")
    private List<ProdajaZaglavlje> prodaje = new ArrayList<>();
    
    @OneToMany(mappedBy = "operater")
    private List<OtkupZaglavlje> otkupi = new ArrayList<>();
    
    @OneToMany(mappedBy = "operater")
    private List<Rezervacija> rezervacije = new ArrayList<>();

    public Operater(int id, String ime, String prezime, String oib, String email, String lozinka) {
        super(id);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.email = email;        
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }    

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public List<ProdajaZaglavlje> getProdaje() {
        return prodaje;
    }

    public void setProdaje(List<ProdajaZaglavlje> prodaje) {
        this.prodaje = prodaje;
    }

    public List<OtkupZaglavlje> getOtkupi() {
        return otkupi;
    }

    public void setOtkupi(List<OtkupZaglavlje> otkupi) {
        this.otkupi = otkupi;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }    

    @Override
    public String toString() {
        return ime + " " + prezime;
    }        
}

