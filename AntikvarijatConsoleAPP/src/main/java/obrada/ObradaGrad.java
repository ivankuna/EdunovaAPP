package obrada;

import model.Drzava;
import model.Grad;

import java.util.ArrayList;
import java.util.List;

public class ObradaGrad {
    private List<Grad> gradovi;
    private Izbornik izbornik;

    public ObradaGrad(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaGrad() {
        gradovi = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    //    ****** Testni podaci ******
    private void testniPodaci() {
        gradovi.add(new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska")));
        gradovi.add(new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina")));
    }
    //    ***************************
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
        switch(Pomocno.unosRasponBroja("Odaberi stavku grad izbornika: ",
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
        for(Grad g : gradovi) {
            System.out.println(i++ + ". " + g + " (" + g.getPostanskiBroj() + ", " + g.getDrzava() + ")");
        }
        System.out.println("-------------------");
    }
    private void dodavanjeGradova() {
        Grad grad = new Grad();
        grad.setId(Pomocno.unosRasponBroja("Unesi šifru grada: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        grad.setNazivGrada(Pomocno.unosString("Unesi naziv grada: ","Unos obavezan"));
        grad.setPostanskiBroj(Pomocno.unosString("Unesi poštanski broj grada: ","Unos obavezan"));
        grad.setDrzava(postaviDrzavu(grad));
        gradovi.add(grad);
    }
    private void promjenaGradova() {
        pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada: ","Pogrešan unos",1,gradovi.size());
        Grad grad = gradovi.get(index-1);
        grad.setNazivGrada(Pomocno.unosString("Unesi naziv grada (" + grad.getNazivGrada() + "): ","Unos je obavezan"));
        grad.setPostanskiBroj(Pomocno.unosString("Unesi poštanski broj grada (" + grad.getPostanskiBroj() + "): ","Unos je obavezan"));
        grad.setDrzava(postaviDrzavu(grad));
    }
    private void brisanjeGradova() {
        pregledGradova();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj grada: ", "Pogrešan unos", 1, gradovi.size());
        gradovi.remove(index-1);
    }
    private Drzava postaviDrzavu(Grad grad) {
        String drzava = grad.getDrzava() != null ? grad.getDrzava().toString() : "";
        izbornik.getObradaDrzava().pregledDrzava();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj države (" + drzava + "): ","Pogrešan unos",1,izbornik.getObradaDrzava().getDrzave().size());
        return izbornik.getObradaDrzava().getDrzave().get(index-1);
    }
}
