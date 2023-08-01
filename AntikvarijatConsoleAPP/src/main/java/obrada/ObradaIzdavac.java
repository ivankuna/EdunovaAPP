package obrada;

import model.Drzava;
import model.Grad;
import model.Izdavac;

import java.util.ArrayList;
import java.util.List;

public class ObradaIzdavac {
    private int idIzdavac = Pomocno.dev ? 3 : 1;
    private List<Izdavac> izdavaci;
    private Izbornik izbornik;

    public ObradaIzdavac(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaIzdavac() {
        izdavaci = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {
        izdavaci.add(new Izdavac(1, "Matica Hrvatska", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))));
        izdavaci.add(new Izdavac(1, "ABC Naklada", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))));
    }
    public List<Izdavac> getIzdavaci() {
        return izdavaci;
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Izdavač izbornik -----");
        System.out.println("1. Pregled postojećih izdavača");
        System.out.println("2. Unos novog izdavača");
        System.out.println("3. Promjena postoječeg izdavača");
        System.out.println("4. Brisanje postoječeg izdavača");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }

    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku izdavač izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledIzdavaca();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeIzdavaca();
                prikaziIzbornik();
                break;
            case 3:
                promjenaIzdavaca();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeIzdavaca();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledIzdavaca() {
        System.out.println("--------------------");
        System.out.println("----- Izdavači -----");
        System.out.println("--------------------");
        int i = 1;
        for(Izdavac iz : izdavaci) {
            System.out.println(i++ + ". " + iz + " (" + iz.getGrad() + ")");
        }
        System.out.println("--------------------");
    }
    private void dodavanjeIzdavaca() {
        Izdavac izdavac = new Izdavac();
        izdavac.setId(idIzdavac++);
        izdavac.setNazivIzdavaca(Pomocno.unosString("Unesi naziv izdavača: ","Pogrešan unos"));
        izdavac.setGrad(postaviGrad(izdavac));
        izdavaci.add(izdavac);
    }
    private void promjenaIzdavaca() {
        if (izdavaci.isEmpty()) {
            System.out.println("\n--- Nema unešenih izdavača za promjenu ---");
            return;
        }
        pregledIzdavaca();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj izdavača: ","Pogrešan unos",1,izdavaci.size());
        Izdavac izdavac = izdavaci.get(index-1);
        izdavac.setNazivIzdavaca(Pomocno.unosString("Unesi naziv izdavača (" + izdavac.getNazivIzdavaca() + "): ","Pogrešan unos"));
        izdavac.setGrad(postaviGrad(izdavac));
    }
    private void brisanjeIzdavaca() {
        if (izdavaci.isEmpty()) {
            System.out.println("\n--- Nema unešenih izdavača za brisanje ---");
            return;
        }
        pregledIzdavaca();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj izdavača: ", "Pogrešan unos", 1, izdavaci.size());
        izdavaci.remove(index-1);
    }
    public Grad postaviGrad(Izdavac izdavac) {
        String grad = izdavac.getGrad() != null ? " (" + izdavac.getGrad().toString() + ")" : "";
        izbornik.getObradaGrad().pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada" + grad + ": ","Pogrešan unos",1,izbornik.getObradaGrad().getGradovi().size());
        return izbornik.getObradaGrad().getGradovi().get(index-1);
    }
}
