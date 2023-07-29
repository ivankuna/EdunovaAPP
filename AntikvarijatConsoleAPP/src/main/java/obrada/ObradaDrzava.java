package obrada;

import model.Drzava;

import java.util.ArrayList;
import java.util.List;

public class ObradaDrzava {
    private List<Drzava> drzave;

    public ObradaDrzava() {
        drzave = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
//    ****** Testni podaci ******
    private void testniPodaci() {
        drzave.add(new Drzava(1, "Republika Hrvatska"));
        drzave.add(new Drzava(2, "Bosna i Hercegovina"));
    }
//    ***************************

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
        switch(Pomocno.unosRasponBroja("Odaberi stavku države izbornika: ",
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
        for(Drzava d : drzave) {
            System.out.println(i++ + ". " + d);
        }
        System.out.println("--------------------");
    }
    private void dodavanjeDrzava() {
        Drzava drzava = new Drzava();
        drzava.setId(Pomocno.unosRasponBroja("Unesi šifru države: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        drzava.setNazivDrzave(Pomocno.unosString("Unesi naziv države: ","Pogrešan unos"));
        drzave.add(drzava);
    }
    private void promjenaDrzava() {
        pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države: ","Pogrešan unos",1,drzave.size());
        Drzava drzava = drzave.get(index-1);
        drzava.setNazivDrzave(Pomocno.unosString("Unesi naziv države (" + drzava.getNazivDrzave() + "): ","Pogrešan unos"));
    }
    private void brisanjeDrzava() {
        pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države: ", "Pogrešan unos", 1, drzave.size());
        drzave.remove(index-1);
    }
}
