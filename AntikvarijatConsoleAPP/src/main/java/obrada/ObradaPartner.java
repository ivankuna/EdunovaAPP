package obrada;

import model.Drzava;
import model.Grad;
import model.Partner;

import java.util.ArrayList;
import java.util.List;

public class ObradaPartner {
    private List<Partner> partneri;
    private Izbornik izbornik;
    
    public ObradaPartner(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaPartner() {
        partneri = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }
    //    ****** Testni podaci ******
    private void testniPodaci() {
        partneri.add(new Partner(1, "Beta Studio d.o.o", "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com",
                "091321123", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))));
        partneri.add(new Partner(2, "PartnerTemp d.o.o", "Ulica Republike 150", "32165498721", "partner.temp@pgmail.com",
                "098462713", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))));
    }
    //    ***************************
    public List<Partner> getPartneri() {
        return partneri;
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Partneri izbornik -----");
        System.out.println("1. Pregled postojećih partnera");
        System.out.println("2. Unos novog partnera");
        System.out.println("3. Promjena postojećih partnera");
        System.out.println("4. Brisanje postojećih partnera");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku partner izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledPartnera();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjePartnera();
                prikaziIzbornik();
                break;
            case 3:
                promjenaPartnera();
                prikaziIzbornik();
                break;
            case 4:
                brisanjePartnera();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    private void pregledPartnera() {
        System.out.println("-------------------");
        System.out.println("----- Partneri -----");
        System.out.println("-------------------");
        int i = 1;
        for(Partner o : partneri) {
            System.out.println(i++ + ". " + o + " (" + o.getUlicaBroj() + ", " + o.getGrad() + ")");
        }
        System.out.println("-------------------");
    }
    private void dodavanjePartnera() {
        Partner partner = new Partner();
        partner.setId(Pomocno.unosRasponBroja("Unesi šifru partnera: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        partner.setNazivPartnera(Pomocno.unosString("Unesi naziv naziv partnera: ", "Unos obavezan"));
        partner.setUlicaBroj(Pomocno.unosString("Unesi adresu partnera: ", "Unos obavezan"));
        partner.setOib(Pomocno.unosString("Unesi OIB partnera: ", "Unos obavezan"));
        partner.setEmail(Pomocno.unosString("Unesi Email partnera", "Unos obavezan"));
        partner.setTelefon(Pomocno.unosString("Unesi telefon partnera", "Unos obavezan"));
        partner.setGrad(postaviGrad(partner));
        partneri.add(partner);
    }
    private void promjenaPartnera() {
        pregledPartnera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj partnera: ","Pogrešan unos",1,partneri.size());
        Partner partner = partneri.get(index-1);
        partner.setNazivPartnera(Pomocno.unosString("Unesi naziv partnera (" + partner.getNazivPartnera() + "): ","Unos je obavezan"));
        partner.setUlicaBroj(Pomocno.unosString("Unesi adresu partnera (" + partner.getUlicaBroj() + "): ","Unos je obavezan"));
        partner.setOib(Pomocno.unosString("Unesi OIB partnera (" + partner.getOib() + "): ","Unos je obavezan"));
        partner.setEmail(Pomocno.unosString("Unesi Email partnera (" + partner.getEmail() + "): ","Unos je obavezan"));
        partner.setTelefon(Pomocno.unosString("Unesi telefon partnera (" + partner.getTelefon() + "): ","Unos je obavezan"));
        partner.setGrad(postaviGrad(partner));
    }
    private void brisanjePartnera() {
        pregledPartnera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj partnera: ", "Pogrešan unos", 1, partneri.size());
        partneri.remove(index-1);
    }
    public Grad postaviGrad(Partner partner) {
        String grad = partner.getGrad() != null ? partner.getGrad().toString() : "";
        izbornik.getObradaGrad().pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada (" + grad + "): ","Pogrešan unos",1,izbornik.getObradaGrad().getGradovi().size());
        return izbornik.getObradaGrad().getGradovi().get(index-1);
    }
}
