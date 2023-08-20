package obrada;

import model.Autor;
import model.Drzava;
import model.Grad;

import java.util.ArrayList;
import java.util.List;

public class ObradaDrzava {
    private int idDrzava = Pomocno.dev ? 3 : 1;
    private List<Drzava> drzave;
    private Izbornik izbornik;

    public ObradaDrzava(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }

    public ObradaDrzava() {
        drzave = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }

    private void testniPodaci() {
        drzave.add(new Drzava(1, "Republika Hrvatska"));
        drzave.add(new Drzava(2, "Bosna i Hercegovina"));
    }

    public List<Drzava> getDrzave() {
        return drzave;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Države izbornik -----");
        System.out.println("1. Pregled postojećih država");
        System.out.println("2. Unos nove države");
        System.out.println("3. Promjena postojeće države");
        System.out.println("4. Brisanje postojeće države");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }

    private void ucitajStavkuIzbornika() {
        switch (Pomocno.unosRasponBroja("Odaberi stavku države izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledDrzava();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeDrzava();
                prikaziIzbornik();
                break;
            case 3:
                promjenaDrzava();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeDrzava();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }

    public void pregledDrzava() {
        System.out.println("--------------------");
        System.out.println("------ Države ------");
        System.out.println("--------------------");
        int i = 1;
        for (Drzava d : drzave) {
            System.out.println(i++ + ". ID:" + d.getId() + " | " + d);
        }
        System.out.println("--------------------");
    }

    private void dodavanjeDrzava() {
        Drzava drzava = new Drzava();
        drzava.setId(idDrzava++);
        drzava.setNazivDrzave(Pomocno.unosString("Unesi naziv države: ", "Pogrešan unos"));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            drzave.add(drzava);
        } else {
            idDrzava--;
        }
    }

    private void promjenaDrzava() {
        if (drzave.isEmpty()) {
            System.out.println("\n--- Nema unešenih država za promjenu ---");
            return;
        }
        pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države: ", "Pogrešan unos", 1, drzave.size());
        Drzava drzava = new Drzava();
        drzava.setId(drzave.get(index-1).getId());
        drzava.setNazivDrzave(Pomocno.unosString("Unesi naziv države (" + drzave.get(index-1).getNazivDrzave() + "): ", "Pogrešan unos"));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabir == 1) {
            drzave.set(index-1, drzava);
        }
    }

    private void brisanjeDrzava() {
        if (drzave.isEmpty()) {
            System.out.println("\n--- Nema unešenih država za brisanje ---");
            return;
        }
        pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države: ", "Pogrešan unos", 1, drzave.size());

        int odlukaOBrisanju = Pomocno.unosRasponBroja("Jeste li sigurni? \n1. Da \n2. Ne \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odlukaOBrisanju == 1) {
            if (koristenjeDrzava(index-1)) {
                System.out.println("\n--- Nemoguće obrisati državu u korištenju ---");
            } else {
                drzave.remove(index-1);
            }
        }
    }

    private boolean koristenjeDrzava(int index) {
        boolean koristiSe = false;
        for (Grad g : izbornik.getObradaGrad().getGradovi()) {
            if (drzave.get(index).equals(g.getDrzava())) {
                koristiSe = true;
                break;
            }
        }
        for (Autor a : izbornik.getObradaAutor().getAutori()) {
            if (drzave.get(index).equals(a.getDrzava())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
}
