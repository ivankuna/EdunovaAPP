package model;

public class ProdajaStavka extends Entitet {

    private ProdajaZaglavlje prodajaZaglavlje;
    private Knjiga knjiga;
    private int kolicina;
    private double cijenaProdaje;

    public ProdajaStavka(int id, ProdajaZaglavlje prodajaZaglavlje, Knjiga knjiga, int kolicina, double cijenaProdaje) {
        super(id);
        this.prodajaZaglavlje = prodajaZaglavlje;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        this.cijenaProdaje = cijenaProdaje;
    }
    public ProdajaStavka() {

    }
    public ProdajaZaglavlje getProdajaZaglavlje() {
        return prodajaZaglavlje;
    }
    public void setProdajaZaglavlje(ProdajaZaglavlje prodajaZaglavlje) {
        this.prodajaZaglavlje = prodajaZaglavlje;
    }
    public Knjiga getKnjiga() {
        return knjiga;
    }
    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
    public int getKolicina() {
        return kolicina;
    }
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    public double getCijenaProdaje() {
        return cijenaProdaje;
    }
    public void setCijenaProdaje(double cijenaProdaje) {
        this.cijenaProdaje = cijenaProdaje;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
