package model;

import java.time.LocalDateTime;

public class ProdajaZaglavlje extends Entitet {
    private int brojProdaje;
    private static LocalDateTime datum;
    private Partner partner;
    private String zki;
    private String jir;
    private NacinPlacanja nacinPlacanja;
    private Operater operater;

    public ProdajaZaglavlje(int id, int brojProdaje, Partner partner, String zki, String jir, NacinPlacanja nacinPlacanja, Operater operater) {
        super(id);
        this.brojProdaje = brojProdaje;
        this.partner = partner;
        this.zki = zki;
        this.jir = jir;
        this.nacinPlacanja = nacinPlacanja;
        this.operater = operater;
    }
    public ProdajaZaglavlje() {

    }
    public int getBrojProdaje() {
        return brojProdaje;
    }
    public void setBrojProdaje(int brojProdaje) {
        this.brojProdaje = brojProdaje;
    }
    public static LocalDateTime getDatum() {
        return datum;
    }
    public static void setDatum(LocalDateTime datum) {
        ProdajaZaglavlje.datum = datum;
    }
    public Partner getPartner() {
        return partner;
    }
    public void setPartner(Partner partner) {
        this.partner = partner;
    }
    public String getZki() {
        return zki;
    }
    public void setZki(String zki) {
        this.zki = zki;
    }
    public String getJir() {
        return jir;
    }
    public void setJir(String jir) {
        this.jir = jir;
    }
    public NacinPlacanja getNacinPlacanja() {
        return nacinPlacanja;
    }
    public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
    }
    public Operater getOperater() {
        return operater;
    }
    public void setOperater(Operater operater) {
        this.operater = operater;
    }

    @Override
    public String toString() {
        return String.valueOf(brojProdaje);
    }
}
