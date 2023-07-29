package model;

public class Knjiga extends Entitet {
    private String nazivKnjige;
    private Autor autor;
    private String godinaIzdanja;
    private Izdavac izdavac;
    private String jezik;
    private int brojStranica;
    private String vrstaUveza;
    private String dimenzije;
    private double cijena;

    public Knjiga(int id, String nazivKnjige, Autor autor, String godinaIzdanja, Izdavac izdavac, String jezik, int brojStranica, String vrstaUveza, String dimenzije, double cijena) {
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
    public int getBrojStranica() {
        return brojStranica;
    }
    public void setBrojStranica(int brojStranica) {
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
    public double getCijena() {
        return cijena;
    }
    public void setCijena(double cijena) {
        this.cijena = cijena;
    }
    @Override
    public String toString() {
        return null;
    }
}
