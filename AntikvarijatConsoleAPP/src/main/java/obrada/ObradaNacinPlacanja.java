package obrada;

import model.NacinPlacanja;
import model.ProdajaZaglavlje;

import java.util.ArrayList;
import java.util.List;

public class ObradaNacinPlacanja {
    private int idNacinPlacanja = Pomocno.dev ? 3 : 1;
    private List<NacinPlacanja> nacinPlacanjaList;
    private Izbornik izbornik;

    public ObradaNacinPlacanja(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaNacinPlacanja() {
        nacinPlacanjaList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {
        nacinPlacanjaList.add(new NacinPlacanja(1, "Prvi način plačanja", "Oznaka 1"));
        nacinPlacanjaList.add(new NacinPlacanja(2, "Drugi način plačanja", "Oznaka 2"));
    }
    public List<NacinPlacanja> getNacinPlacanjaList() {
        return nacinPlacanjaList;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("--- Način plačanja izbornik ---");
        System.out.println("1. Pregled postojećih načina plačanja");
        System.out.println("2. Unos novog načina plačanja");
        System.out.println("3. Promjena postojećih načina plačanja");
        System.out.println("4. Brisanje postojećih načina plačanja");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku način plačanja izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledNacinaPlacanja();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeNacinaPlacanja();
                prikaziIzbornik();
                break;
            case 3:
                promjenaNacinaPlacanja();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeNacinaPlacanja();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledNacinaPlacanja() {
        System.out.println("-----------------------");
        System.out.println("--- Načini plačanja ---");
        System.out.println("-----------------------");
        int i = 1;
        for(NacinPlacanja n : nacinPlacanjaList) {
            System.out.println(i++ + ". " + n);
        }
        System.out.println("-----------------------");
    }
    private void dodavanjeNacinaPlacanja() {
        NacinPlacanja nacinPlacanja = new NacinPlacanja();
        nacinPlacanja.setId(idNacinPlacanja++);
        nacinPlacanja.setNazivNacinaPlacanja(Pomocno.unosString("Unesi naziv načina plačanja: ","Pogrešan unos"));
        nacinPlacanja.setOznakaNacinaPlacanja(Pomocno.unosString("Unesi oznaku načina plačanja: ","Pogrešan unos"));
        nacinPlacanjaList.add(nacinPlacanja);
    }
    private void promjenaNacinaPlacanja() {
        if (nacinPlacanjaList.isEmpty()) {
            System.out.println("\n--- Nema unešenih načina plačanja za promjenu ---");
            return;
        }
        pregledNacinaPlacanja();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj načina plačanja: ","Pogrešan unos",1,nacinPlacanjaList.size());
        NacinPlacanja nacinPlacanja = nacinPlacanjaList.get(index-1);
        nacinPlacanja.setNazivNacinaPlacanja(Pomocno.unosString("Unesi naziv načina plačanja (" + nacinPlacanja.getNazivNacinaPlacanja() + "): ","Pogrešan unos"));
        nacinPlacanja.setOznakaNacinaPlacanja(Pomocno.unosString("Unesi oznaku načina plačanja (" + nacinPlacanja.getOznakaNacinaPlacanja() + "): ","Pogrešan unos"));
    }
    private void brisanjeNacinaPlacanja() {
        if (nacinPlacanjaList.isEmpty()) {
            System.out.println("\n--- Nema unešenih načina plačanja za brisanje ---");
            return;
        }
        pregledNacinaPlacanja();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj načina plačanja: ", "Pogrešan unos", 1, nacinPlacanjaList.size());
        if (koristenjeNacinPlacanja(index-1)) {
            System.out.println("\n--- Nemoguće obrisati način plačanja u korištenju ---");
        } else {
            nacinPlacanjaList.remove(index-1);
        }
    }
    private boolean koristenjeNacinPlacanja(int index) {
        boolean koristiSe = false;
        for (ProdajaZaglavlje p : izbornik.getObradaProdaja().getProdajaZaglavljeList()) {
            if (nacinPlacanjaList.get(index).equals(p.getNacinPlacanja())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
}
