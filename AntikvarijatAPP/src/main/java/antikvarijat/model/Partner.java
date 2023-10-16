package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partner extends Entitet {
    
    private String nazivPartnera;
    
    private String ulicaBroj;
    
    private String oib;
    
    private String email;
    
    private String telefon;
    
    @ManyToOne
    private Grad grad;
    
    @OneToMany(mappedBy = "partner")
    private List<ProdajaZaglavlje> prodaje = new ArrayList<>();
    
    @OneToMany(mappedBy = "partner")
    private List<OtkupZaglavlje> otkupi = new ArrayList<>();
    
    @OneToMany(mappedBy = "partner")
    private List<Rezervacija> rezervacije = new ArrayList<>();

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
        return nazivPartnera;
    }        
}
