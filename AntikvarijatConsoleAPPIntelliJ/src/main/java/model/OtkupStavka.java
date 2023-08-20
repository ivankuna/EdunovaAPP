package model;

public class OtkupStavka extends Entitet {
    private OtkupZaglavlje otkupZaglavlje;
    private Knjiga knjiga;
    private int kolicina;
    private double cijenaOtkupaArtikla;
    private double cijenaOtkupa;

    public OtkupStavka(int id, OtkupZaglavlje otkupZaglavlje, Knjiga knjiga, int kolicina, double cijenaOtkupa, double cijenaOtkupaArtikla) {
        super(id);
        this.otkupZaglavlje = otkupZaglavlje;
        this.knjiga = knjiga;
        this.kolicina = kolicina;
        this.cijenaOtkupaArtikla = cijenaOtkupaArtikla;
        this.cijenaOtkupa = cijenaOtkupa;
    }
    public OtkupStavka() {

    }
    public OtkupZaglavlje getOtkupZaglavlje() {
        return otkupZaglavlje;
    }
    public void setOtkupZaglavlje(OtkupZaglavlje otkupZaglavlje) {
        this.otkupZaglavlje = otkupZaglavlje;
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
    public double getCijenaOtkupa() {
        return cijenaOtkupa;
    }
    public void setCijenaOtkupa(double cijenaOtkupa) {
        this.cijenaOtkupa = cijenaOtkupa;
    }
    public double getCijenaOtkupaArtikla() {
        return cijenaOtkupaArtikla;
    }
    public void setCijenaOtkupaArtikla(double cijenaOtkupaArtikla) {
        this.cijenaOtkupaArtikla = cijenaOtkupaArtikla;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
