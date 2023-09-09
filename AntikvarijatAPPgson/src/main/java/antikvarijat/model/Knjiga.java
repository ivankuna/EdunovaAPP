package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Knjiga extends Entitet {
    
    private String nazivKnjige;
    
    @ManyToOne
    private Autor autor;
    
    private String godinaIzdanja;
    
    @ManyToOne
    private Izdavac izdavac;
    
    private String jezik;
    
    private Integer brojStranica;
    
    private String vrstaUveza;
    
    private String dimenzije;
    
    private BigDecimal cijena;

    public Knjiga(int id, String nazivKnjige, Autor autor, String godinaIzdanja, Izdavac izdavac, 
            String jezik, Integer brojStranica, String vrstaUveza, String dimenzije, BigDecimal cijena) {
        super(id);
        this.nazivKnjige = nazivKnjige;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
        this.izdavac = izdavac;
        this.jezik = jezik;
        this.brojStranica = brojStranica;
        this.vrstaUveza = vrstaUveza;
        this.dimenzije = dimenzije;
        this.cijena = cijena;
    }
    
    public Knjiga() {
        
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(String godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public Integer getBrojStranica() {
        return brojStranica;
    }

    public void setBrojStranica(Integer brojStranica) {
        this.brojStranica = brojStranica;
    }

    public String getVrstaUveza() {
        return vrstaUveza;
    }

    public void setVrstaUveza(String vrstaUveza) {
        this.vrstaUveza = vrstaUveza;
    }

    public String getDimenzije() {
        return dimenzije;
    }

    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }    
}
