package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ObradaAutor {
    private int idAutor = Pomocno.dev ? 3 : 1;
    private List<Autor> autori;
    private Izbornik izbornik;
    public ObradaAutor(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaAutor() {
        autori = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {
        autori.add(new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")));
        autori.add(new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")));
    }
    public List<Autor> getAutori() {
        return autori;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Autor izbornik -----");
        System.out.println("1. Pregled postojećih autora");
        System.out.println("2. Unos novog autora");
        System.out.println("3. Promjena postojećih autora");
        System.out.println("4. Brisanje postojećih autora");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku autor izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledAutora();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeAutora();
                prikaziIzbornik();
                break;
            case 3:
                promjenaAutora();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeAutora();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledAutora() {
        System.out.println("--------------------");
        System.out.println("------ Autori ------");
        System.out.println("--------------------");
        int i = 1;
        for(Autor a : autori) {
            System.out.println(i++ + ". ID:" + a.getId() + " | " + a + " (" + a.getDrzava() + ")");
        }
        System.out.println("--------------------");
    }
    private void dodavanjeAutora() {
        if (izbornik.getObradaDrzava().getDrzave().isEmpty()) {
            System.out.println("\n--- Unos autora nemoguć bez unešenih država ---");
            return;
        }
        Autor autor = new Autor();
        autor.setId(idAutor++);
        autor.setNazivAutora(Pomocno.unosString("Unesi naziv autora: ","Pogrešan unos"));
        autor.setDrzava(postaviDrzavu(autor));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ","Pogrešan unos", 1, 2);
        if (odabir == 1) {
            autori.add(autor);
        } else {
            idAutor--;
        }
    }
    private void promjenaAutora() {
        if (autori.isEmpty()) {
            System.out.println("\n--- Nema unešenih autora za promjenu ---");
            return;
        }
        pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora: ","Pogrešan unos",1,autori.size());
        Autor autor = new Autor();
        autor.setId(autori.get(index-1).getId());
        autor.setNazivAutora(Pomocno.unosString("Unesi naziv autora (" + autori.get(index-1).getNazivAutora() + "): ","Pogrešan unos"));
        autor.setDrzava(postaviDrzavu(autori.get(index-1)));
        int odabir = Pomocno.unosRasponBroja("1. Spremi \n2. Odustani \nOdabir: ","Pogrešan unos", 1, 2);
        if (odabir == 1) {
            autori.set(index-1, autor);
        }
    }
    private void brisanjeAutora() {
        if (autori.isEmpty()) {
            System.out.println("\n--- Nema unešenih autora za brisanje ---");
            return;
        }
        pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora: ", "Pogrešan unos", 1, autori.size());
        int odlukaOBrisanju = Pomocno.unosRasponBroja("Jeste li sigurni? \n1. Da \n2. Ne \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odlukaOBrisanju == 1) {
            if (koristenjeAutor(index-1)) {
                System.out.println("\n--- Nemoguće obrisati autora u korištenju ---");
            } else {
                autori.remove(index-1);
            }
        }
    }
    private Drzava postaviDrzavu(Autor autor) {
        String drzava = autor.getDrzava() != null ? " (" + autor.getDrzava().toString() + ")" : "";
        izbornik.getObradaDrzava().pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države" + drzava + ": ","Pogrešan unos",1,izbornik.getObradaDrzava().getDrzave().size());
        return izbornik.getObradaDrzava().getDrzave().get(index-1);
    }
    private boolean koristenjeAutor(int index) {
        boolean koristiSe = false;
        for (Knjiga k : izbornik.getObradaKnjiga().getKnjige()) {
            if (autori.get(index).equals(k.getAutor())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
}
