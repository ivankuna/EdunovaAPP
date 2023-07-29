package obrada;

import model.Autor;
import model.Drzava;

import java.util.ArrayList;
import java.util.List;

public class ObradaAutor {
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
    //    ****** Testni podaci ******
    private void testniPodaci() {
        autori.add(new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")));
        autori.add(new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")));
    }
    //    ***************************

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
            System.out.println(i++ + ". " + a + " (" + a.getDrzava() + ")");
        }
        System.out.println("--------------------");
    }
    private void dodavanjeAutora() {
        Autor autor = new Autor();
        autor.setId(Pomocno.unosRasponBroja("Unesi šifru autora: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        autor.setNazivAutora(Pomocno.unosString("Unesi naziv autora: ","Pogrešan unos"));
        autor.setDrzava(postaviDrzavu(autor));
        autori.add(autor);
    }
    private void promjenaAutora() {
        pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora: ","Pogrešan unos",1,autori.size());
        Autor autor = autori.get(index-1);
        autor.setNazivAutora(Pomocno.unosString("Unesi naziv autora (" + autor.getNazivAutora() + "): ","Pogrešan unos"));
        autor.setDrzava(postaviDrzavu(autor));
    }
    private void brisanjeAutora() {
        pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora: ", "Pogrešan unos", 1, autori.size());
        autori.remove(index-1);
    }
    private Drzava postaviDrzavu(Autor autor) {
        String drzava = autor.getDrzava() != null ? autor.getDrzava().toString() : "";
        izbornik.getObradaDrzava().pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države (" + drzava + "): ","Pogrešan unos",1,izbornik.getObradaDrzava().getDrzave().size());
        return izbornik.getObradaDrzava().getDrzave().get(index-1);
    }
}
