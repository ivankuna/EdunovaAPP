package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ObradaGrad {
    private int idGrad = Pomocno.dev ? 3 : 1;
    private List<Grad> gradovi;
    private Izbornik izbornik;

    public ObradaGrad(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }

    public ObradaGrad() {
        gradovi = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }

    private void testniPodaci() {
        gradovi.add(new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska")));
        gradovi.add(new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina")));
    }

    public List<Grad> getGradovi() {
        return gradovi;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Gradovi izbornik -----");
        System.out.println("1. Pregled postojećih gradova");
        System.out.println("2. Unos novog grada");
        System.out.println("3. Promjena postojećih gradova");
        System.out.println("4. Brisanje postojećih gradova");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }

    private void ucitajStavkuIzbornika() {
        switch (Pomocno.unosRasponBroja("Odaberi stavku grad izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledGradova();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeGradova();
                prikaziIzbornik();
                break;
            case 3:
                promjenaGradova();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeGradova();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }

    public void pregledGradova() {
        System.out.println("-------------------");
        System.out.println("----- Gradovi -----");
        System.out.println("-------------------");
        int i = 1;
        for (Grad g : gradovi) {
            System.out.println(i++ + ". ID:" + g.getId() + " | " + g + " (" + g.getPostanskiBroj() + ", " + g.getDrzava() + ")");
        }
        System.out.println("-------------------");
    }

    private void dodavanjeGradova() {
        if (izbornik.getObradaDrzava().getDrzave().isEmpty()) {
            System.out.println("\n--- Unos grada nemoguć bez unešenih država ---");
            return;
        }
        Grad grad = new Grad();
        grad.setId(idGrad++);
        grad.setNazivGrada(Pomocno.unosString("Unesi naziv grada: ", "Pogrešan unos"));
        grad.setPostanskiBroj(Pomocno.unosString("Unesi poštanski broj grada: ", "Pogrešan unos"));
        grad.setDrzava(postaviDrzavu(grad));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            gradovi.add(grad);
        } else {
            idGrad--;
        }
    }

    private void promjenaGradova() {
        if (gradovi.isEmpty()) {
            System.out.println("\n--- Nema unešenih gradova za promjenu ---");
            return;
        }
        pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada: ", "Pogrešan unos", 1, gradovi.size());
        Grad grad = new Grad();
        grad.setId(gradovi.get(index-1).getId());
        grad.setNazivGrada(Pomocno.unosString("Unesi naziv grada (" + gradovi.get(index-1).getNazivGrada() + "): ", "Pogrešan unos"));
        grad.setPostanskiBroj(Pomocno.unosString("Unesi poštanski broj grada (" + gradovi.get(index-1).getPostanskiBroj() + "): ", "Pogrešan unos"));
        grad.setDrzava(postaviDrzavu(gradovi.get(index-1)));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            gradovi.set(index-1, grad);
        }
    }

    private void brisanjeGradova() {
        if (gradovi.isEmpty()) {
            System.out.println("\n--- Nema unešenih gradova za brisanje ---");
            return;
        }
        pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada: ", "Pogrešan unos", 1, gradovi.size());

        int odlukaOBrisanju = Pomocno.unosRasponBroja("Jeste li sigurni? \n1. Da \n2. Ne \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odlukaOBrisanju == 1) {
            if (koristenjeGrad(index-1)) {
                System.out.println("\n--- Nemoguće obrisati grad u korištenju ---");
            } else {
                gradovi.remove(index-1);
            }
        }
    }

    private Drzava postaviDrzavu(Grad grad) {
        String drzava = grad.getDrzava() != null ? " (" + grad.getDrzava().toString() + ")" : "";
        izbornik.getObradaDrzava().pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države" + drzava + ": ", "Pogrešan unos", 1, izbornik.getObradaDrzava().getDrzave().size());
        return izbornik.getObradaDrzava().getDrzave().get(index-1);
    }

    private boolean koristenjeGrad(int index) {
        boolean koristiSe = false;
        for (Izdavac i : izbornik.getObradaIzdavac().getIzdavaci()) {
            if (gradovi.get(index).equals(i.getGrad())) {
                koristiSe = true;
                break;
            }
        }
        for (Partner p : izbornik.getObradaPartner().getPartneri()) {
            if (gradovi.get(index).equals(p.getGrad())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
}
