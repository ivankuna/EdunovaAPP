package model;

public class Stanje extends Entitet {
    private String naslovKnjige;
    private String nazivAutora;
    private int ulaz;
    private int izlaz;
    private int rezervirano;
    private int stanje;
    private int raspolozivo;

    public Stanje(int id, String naslovKnjige, String nazivAutora, int ulaz, int izlaz, int rezervirano, int stanje, int raspolozivo) {
        super(id);
        this.naslovKnjige = naslovKnjige;
        this.nazivAutora = nazivAutora;
        this.ulaz = ulaz;
        this.izlaz = izlaz;
        this.rezervirano = rezervirano;
        this.stanje = stanje;
        this.raspolozivo = raspolozivo;
    }
    public Stanje() {

    }
    public String getNaslovKnjige() {
        return naslovKnjige;
    }
    public void setNaslovKnjige(String naslovKnjige) {
        this.naslovKnjige = naslovKnjige;
    }
    public String getNazivAutora() {
        return nazivAutora;
    }
    public void setNazivAutora(String nazivAutora) {
        this.nazivAutora = nazivAutora;
    }
    public int getUlaz() {
        return ulaz;
    }
    public void setUlaz(int ulaz) {
        this.ulaz = ulaz;
    }
    public int getIzlaz() {
        return izlaz;
    }
    public void setIzlaz(int izlaz) {
        this.izlaz = izlaz;
    }
    public int getRezervirano() {
        return rezervirano;
    }
    public void setRezervirano(int rezervirano) {
        this.rezervirano = rezervirano;
    }
    public int getStanje() {
        return stanje;
    }
    public void setStanje(int stanje) {
        this.stanje = stanje;
    }
    public int getRaspolozivo() {
        return raspolozivo;
    }
    public void setRaspolozivo(int raspolozivo) {
        this.raspolozivo = raspolozivo;
    }

    @Override
    public String toString() {
        return "ID: " + getId();
    }
}
