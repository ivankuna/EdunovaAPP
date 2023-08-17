package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ObradaPartner {
    private int idPartner = Pomocno.dev ? 3 : 1;
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
    private void testniPodaci() {
        partneri.add(new Partner(1, "Beta Studio d.o.o", "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com",
                "091321123", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))));
        partneri.add(new Partner(2, "PartnerTemp d.o.o", "Ulica Republike 150", "32165498721", "partner.temp@pgmail.com",
                "098462713", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))));
    }
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
                pregledPartnera(false);
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
    public void pregledPartnera(boolean otkupProdaja) {
        System.out.println("--------------------");
        System.out.println("----- Partneri -----");
        System.out.println("--------------------");
        int i = 1;
        for(Partner p : partneri) {
            System.out.println(i++ + ". ID:" + p.getId() + " | " + p + " (" + p.getUlicaBroj() + ", " + p.getGrad() + ")");
        }
        if (otkupProdaja) {
            System.out.println(i + ". Nastavi bez unosa partnera");
        }
        System.out.println("--------------------");
    }
    private void dodavanjePartnera() {
        if (izbornik.getObradaGrad().getGradovi().isEmpty()) {
            System.out.println("\n--- Unos partnera nemoguć bez unešenih gradova ---");
            return;
        }
        Partner partner = new Partner();
        partner.setId(idPartner++);
        partner.setNazivPartnera(Pomocno.unosString("Unesi naziv naziv partnera: ", "Pogrešan unos"));
        partner.setUlicaBroj(Pomocno.unosString("Unesi adresu partnera: ", "Pogrešan unos"));
        partner.setOib(Pomocno.unosString("Unesi OIB partnera: ", "Pogrešan unos"));
        partner.setEmail(Pomocno.unosString("Unesi Email partnera: ", "Pogrešan unos"));
        partner.setTelefon(Pomocno.unosString("Unesi telefon partnera: ", "Pogrešan unos"));
        partner.setGrad(postaviGrad(partner));

        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            partneri.add(partner);
        } else {
            idPartner--;
        }
    }
    private void promjenaPartnera() {
        if (partneri.isEmpty()) {
            System.out.println("\n--- Nema unešenih partnera za promjenu ---");
            return;
        }
        pregledPartnera(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj partnera: ","Pogrešan unos",1,partneri.size());
        Partner partner = new Partner();
        partner.setId(partneri.get(index-1).getId());
        partner.setNazivPartnera(Pomocno.unosString("Unesi naziv partnera (" + partneri.get(index-1).getNazivPartnera() + "): ","Pogrešan unos"));
        partner.setUlicaBroj(Pomocno.unosString("Unesi adresu partnera (" + partneri.get(index-1).getUlicaBroj() + "): ","Pogrešan unos"));
        partner.setOib(Pomocno.unosString("Unesi OIB partnera (" + partneri.get(index-1).getOib() + "): ","Pogrešan unos"));
        partner.setEmail(Pomocno.unosString("Unesi Email partnera (" + partneri.get(index-1).getEmail() + "): ","Pogrešan unos"));
        partner.setTelefon(Pomocno.unosString("Unesi telefon partnera (" + partneri.get(index-1).getTelefon() + "): ","Pogrešan unos"));
        partner.setGrad(postaviGrad(partneri.get(index-1)));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            partneri.set(index-1, partner);
        }
    }
    private void brisanjePartnera() {
        if (partneri.isEmpty()) {
            System.out.println("\n--- Nema unešenih partnera za brisanje ---");
            return;
        }
        pregledPartnera(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj partnera: ", "Pogrešan unos", 1, partneri.size());

        int odlukaOBrisanju = Pomocno.unosRasponBroja("Jeste li sigurni? \n1. Da \n2. Ne \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odlukaOBrisanju == 1) {
            if (koristenjePartner(index-1)) {
                System.out.println("\n--- Nemoguće obrisati partnera u korištenju ---");
            } else {
                partneri.remove(index-1);
            }
        }
    }
    public Grad postaviGrad(Partner partner) {
        String grad = partner.getGrad() != null ? " (" + partner.getGrad().toString() + ")" : "";
        izbornik.getObradaGrad().pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada" + grad + ": ","Pogrešan unos",1,izbornik.getObradaGrad().getGradovi().size());
        return izbornik.getObradaGrad().getGradovi().get(index-1);
    }
    private boolean koristenjePartner(int index) {
        boolean koristiSe = false;
        for (OtkupZaglavlje o : izbornik.getObradaOtkup().getOtkupZaglavljeList()) {
            if (partneri.get(index).equals(o.getPartner())) {
                koristiSe = true;
                break;
            }
        }
        for (ProdajaZaglavlje p : izbornik.getObradaProdaja().getProdajaZaglavljeList()) {
            if (partneri.get(index).equals(p.getPartner())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
}
