package obrada;

import model.Autor;
import model.Grad;
import model.Izdavac;
import model.Knjiga;

import java.util.ArrayList;
import java.util.List;
public class ObradaKnjiga {
    private List<Knjiga> knjige;
    private Izbornik izbornik;
    private String[] vrstaUveza = {"Tvrdi", "Meki", ""}

    public ObradaKnjiga(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaKnjiga() {
        knjige = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }
    //    ****** Testni podaci ******
    private void testniPodaci() {

    }
    //    ***************************
    public List<Knjiga> getKnjige() {
        return knjige;
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Knjige izbornik -----");
        System.out.println("1. Pregled postojećih knjiga");
        System.out.println("2. Unos nove knjige");
        System.out.println("3. Promjena postojeće knjige");
        System.out.println("4. Brisanje postojeće knjige");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {

        switch(Pomocno.unosRasponBroja("Odaberi stavku knjiga izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledKnjiga();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeKnjiga();
                prikaziIzbornik();
                break;
            case 3:
                promjenaKnjiga();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeKnjiga();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    private void pregledKnjiga() {
        System.out.println("------------------");
        System.out.println("----- Knjige -----");
        System.out.println("------------------");
        int i = 1;
        for(Knjiga k : knjige) {
            System.out.println(i++ + ". " + k + " (" + k.getAutor().getNazivAutora() + ")");
        }
        System.out.println("------------------");
    }
//    private String nazivKnjige;
//    private Autor autor;
//    private String godinaIzdanja;
//    private Izdavac izdavac;
//    private String jezik;
//    private int brojStranica;
//    private String vrstaUveza;
//    private String dimenzije;
//    private double cijena;
    private void dodavanjeKnjiga() {
        Knjiga knjiga = new Knjiga();
        knjiga.setId(Pomocno.unosRasponBroja("Unesi šifru knjige: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        knjiga.setNazivKnjige(Pomocno.unosString("Unesi naziv knjige: ","Unos obavezan"));
        knjiga.setAutor(postaviAutora(knjiga));
        knjiga.setGodinaIzdanja(Pomocno.unosString("Unesi godinu izdanja knjige (yyyy): ","Unos obavezan") + ".");
        knjiga.setIzdavac(postaviIzdavaca(knjiga));
        knjiga.setJezik(Pomocno.unosString("Unesi jezik na kojem je pisana knjiga: ","Unos obavezan"));
        knjiga.setBrojStranica(Pomocno.unosInt("Unesi broj stranica: ", "Unos obavezan"));
        knjiga.setVrstaUveza(Pomocno.unosString("Unesi vrstu uveza knjige: ","Unos obavezan"));
    }
    private void promjenaKnjiga() {
    }
    private void brisanjeKnjiga() {
    }
    private Autor postaviAutora(Knjiga knjiga) {
        String autor = knjiga.getAutor() != null ? knjiga.getAutor().toString() : "";
        izbornik.getObradaAutor().pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora (" + autor + "): ","Pogrešan unos",1,izbornik.getObradaAutor().getAutori().size());
        return izbornik.getObradaAutor().getAutori().get(index-1);
    }
    private Izdavac postaviIzdavaca(Knjiga knjiga) {
        String izdavac = knjiga.getIzdavac() != null ? knjiga.getIzdavac().toString() : "";
        izbornik.getObradaIzdavac().pregledIzdavaca();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj izdavaca (" + izdavac + "): ","Pogrešan unos",1,izbornik.getObradaIzdavac().getIzdavaci().size());
        return izbornik.getObradaIzdavac().getIzdavaci().get(index-1);
    }
}
