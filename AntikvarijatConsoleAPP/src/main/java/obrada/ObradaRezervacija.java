package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ObradaRezervacija {
    private final String[] stanjeField = {"Rezervirano", "Rezervacija izvršena"};
    private int idRezervacija = Pomocno.dev ? 3 : 1;
    private List<Rezervacija> rezervacijaList;
    private Izbornik izbornik;

    public ObradaRezervacija(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaRezervacija() {
        rezervacijaList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }
    private void testniPodaci() {
        rezervacijaList.add(new Rezervacija(1, new Partner(1, "Beta Studio d.o.o", "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com",
                "091321123", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))), new Knjiga(1, "Zlatarovo zlato",
                new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")), "1985", new Izdavac(1, "Matica Hrvatska",
                new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))), "Hrvatski", 475, "Tvrdi uvez",
                "13,97 x 21,59 cm", 13.99), stanjeField[0], new Operater(1, "Ivan", "Kuna", "89877641989", "ivankuna@gmail.com", "ivanK", "123")));
        rezervacijaList.add(new Rezervacija(2, new Partner(2, "PartnerTemp d.o.o", "Ulica Republike 150", "32165498721", "partner.temp@pgmail.com",
                "098462713", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))), new Knjiga(2, "Na Drini ćuprija",
                new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")), "1981", new Izdavac(1, "ABC Naklada",
                new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))), "Bošnjački", 400, "Tvrdi uvez",
                "13,97 x 21,59 cm", 14.99), stanjeField[1], new Operater(2, "Pero", "Nadoveza", "73917400273", "pero.nadoveza@gmail.com", "peroN", "321")));
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("---- Rezervacije izbornik ----");
        System.out.println("1. Pregled postojećih rezervacija");
        System.out.println("2. Unos nove rezervacije");
        System.out.println("3. Promjena postojećih rezervacija");
        System.out.println("4. Brisanje postojećih rezervacija");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku rezervacija izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledRezervacija();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeRezervacija();
                prikaziIzbornik();
                break;
            case 3:
                promjenaRezervacija();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeRezervacija();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledRezervacija() {
        System.out.println("-------------------");
        System.out.println("--- Rezervacije ---");
        System.out.println("-------------------");
        int i = 1;
        for(Rezervacija r : rezervacijaList) {
            System.out.println(i++ + ". " + r + " (" + r.getKnjiga() + ", " + r.getPartner() + ")");
        }
        System.out.println("-------------------");
    }
    private void dodavanjeRezervacija() {
        if (izbornik.getObradaPartner().getPartneri().isEmpty()) {
            System.out.println("\n--- Unos rezervacije nemoguć bez unešenih partnera ---");
            return;
        } else if (izbornik.getObradaKnjiga().getKnjige().isEmpty()) {
            System.out.println("\n--- Unos rezervacije nemoguć bez unešenih knjiga ---");
            return;
        } else if (izbornik.getObradaOperater().getOperateri().isEmpty()) {
            System.out.println("\n--- Unos rezervacije nemoguć bez unešenih operatera ---");
            return;
        } else if (!izbornik.getObradaKnjiga().provjeraRaspolozivihKnjiga()) {
            System.out.println("\n--- Unos rezervacije nemoguć bez raspoloživih knjiga ---");
            return;
        }
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setId(idRezervacija++);
        rezervacija.setPartner(postaviPartnera(rezervacija));
        rezervacija.setKnjiga(postaviKnjigu(rezervacija, true));
        rezervacija.setStanje(postaviStanje(rezervacija));
        rezervacija.setOperater(postaviOperatera(rezervacija));
        rezervacijaList.add(rezervacija);
    }
    private void promjenaRezervacija() {
        int index;
        if (rezervacijaList.isEmpty()) {
            System.out.println("\n--- Nema unešenih rezervacija za promjenu ---");
            return;
        }
        pregledRezervacija();
        while (true) {
            index = Pomocno.unosRasponBroja("Odaberi redni broj rezervacije: ","Pogrešan unos",1,rezervacijaList.size());
            if (rezervacijaList.get(index-1).getStanje().equals(stanjeField[1])) {
                System.out.println("\nNemoguće mijenjati sadržaj izvršene rezervacije!\n");
            } else {
                break;
            }
        }
        Rezervacija rezervacija = rezervacijaList.get(index-1);
        rezervacija.setPartner(postaviPartnera(rezervacija));

        rezervacija.setKnjiga(postaviKnjigu(rezervacija, false));
        rezervacija.setStanje(postaviStanje(rezervacija));
        rezervacija.setOperater(postaviOperatera(rezervacija));
    }
    private void brisanjeRezervacija() {
        if (rezervacijaList.isEmpty()) {
            System.out.println("\n--- Nema unešenih rezervacija za brisanje ---");
            return;
        }
        pregledRezervacija();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj rezervacije: ", "Pogrešan unos", 1, rezervacijaList.size());
        rezervacijaList.remove(index-1);
    }
    private Partner postaviPartnera(Rezervacija rezervacija) {
        String partner = rezervacija.getPartner() != null ? " (" + rezervacija.getPartner().toString() + ")" : "";
        izbornik.getObradaPartner().pregledPartnera(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj partnera" + partner + ": ", "Pogrešan unos", 1, izbornik.getObradaPartner().getPartneri().size());
        return  izbornik.getObradaPartner().getPartneri().get(index-1);
    }
    private Knjiga postaviKnjigu(Rezervacija rezervacija, boolean createUpdate) {
        int index;
        String knjiga = rezervacija.getKnjiga() != null ? " (" + rezervacija.getKnjiga().toString() + ")" : "";
        izbornik.getObradaKnjiga().pregledKnjiga(true, 0, rezervacija.getId());
        while (true) {
            index = Pomocno.unosRasponBroja("Odaberi redni broj knjige" + knjiga + ": ", "Pogrešan unos", 1, izbornik.getObradaKnjiga().getKnjige().size());
            if (createUpdate) {
                if (izbornik.getObradaStanje().brojRaspolozivo(izbornik.getObradaKnjiga().getKnjige().get(index-1).getId(), 0, 0 ) > 0) {
                    break;
                } else {
                    System.out.println("\nOdabrana knjiga nije raspoloživa!\n");
                }
            } else {
                if (izbornik.getObradaStanje().brojRaspolozivo(izbornik.getObradaKnjiga().getKnjige().get(index-1).getId(), 0, rezervacija.getId() ) > 0) {
                    break;
                } else {
                    System.out.println("\nOdabrana knjiga nije raspoloživa!\n");
                }
            }
        }
        return izbornik.getObradaKnjiga().getKnjige().get(index-1);
    }
    private String postaviStanje(Rezervacija rezervacija) {
        String stanjeRezervacije = rezervacija.getStanje() != null ? " (" + rezervacija.getStanje() + ")" : "";
        System.out.println("\n1. " + stanjeField[0] + "\n2. " + stanjeField[1]);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj stanja rezervacije" + stanjeRezervacije + ": ", "Pogrešan unos", 1, 2);
        return stanjeField[index-1];
    }
    private Operater postaviOperatera(Rezervacija rezervacija) {
        String operater = rezervacija.getOperater() != null ? " (" + rezervacija.getOperater().toString() + ")" : "";
        izbornik.getObradaOperater().pregledOperatera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj operatera" + operater + ": ", "Pogrešan unos", 1, izbornik.getObradaOperater().getOperateri().size());
        return izbornik.getObradaOperater().getOperateri().get(index-1);
    }
//    private boolean provjeraRaspolozivihKnjiga() {
//        boolean postojiRaspolozivaKnjiga = false;
//        for (Knjiga k : izbornik.getObradaKnjiga().getKnjige()) {
//            if (izbornik.getObradaStanje().brojRaspolozivo(k.getId(), 0, 0) > 0) {
//                postojiRaspolozivaKnjiga = true;
//            }
//        }
//        return postojiRaspolozivaKnjiga;
//    }
}
