package obrada;

import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObradaOtkup {
    private int idOtkupZaglavlje = Pomocno.dev ? 3 : 1;
    private int idOtkupStavka = Pomocno.dev ? 3 : 1;
    private int brojOtkupaCounter = Pomocno.dev ? 3 : 1;
    private List<OtkupZaglavlje> otkupZaglavljeList;
    private List<OtkupStavka> otkupStavkaList;
    private Izbornik izbornik;

    public ObradaOtkup(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaOtkup() {
        otkupZaglavljeList = new ArrayList<>();
        otkupStavkaList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    public List<OtkupZaglavlje> getOtkupZaglavljeList() {
        return otkupZaglavljeList;
    }
    public List<OtkupStavka> getOtkupStavkaList() {
        return otkupStavkaList;
    }

    private void testniPodaci() {
        LocalDateTime t1 = LocalDateTime.parse("01.05.2023. 17:35:00", Pomocno.formatter);
        LocalDateTime t2 = LocalDateTime.parse("15.08.2023. 09:44:00", Pomocno.formatter);
        otkupZaglavljeList.add(new OtkupZaglavlje(1, 1, t1, new Partner(1, "Beta Studio d.o.o",
                "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com", "091321123", new Grad(1, "Zagreb",
                "10000", new Drzava(1, "Republika Hrvatska"))), new Operater(1, "Ivan", "Kuna", "89877641989",
                "ivankuna@gmail.com", "ivanK", "123")));
        otkupZaglavljeList.add(new OtkupZaglavlje(2, 2, t2, new Partner(2, "PartnerTemp d.o.o",
                "Ulica Republike 150", "32165498721", "partner.temp@pgmail.com", "098462713", new Grad(2, "Sarajevo",
                "51000", new Drzava(2, "Bosna i Hercegovina"))), new Operater(2, "Pero", "Nadoveza", "73917400273",
                "pero.nadoveza@gmail.com", "peroN", "321")));
        otkupStavkaList.add(new OtkupStavka(1, new OtkupZaglavlje(1, 1, t1, new Partner(1, "Beta Studio d.o.o",
                "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com", "091321123", new Grad(1, "Zagreb",
                "10000", new Drzava(1, "Republika Hrvatska"))), new Operater(1, "Ivan", "Kuna", "89877641989",
                "ivankuna@gmail.com", "ivanK", "123")), new Knjiga(1, "Zlatarovo zlato", new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")), "1985",
                new Izdavac(1, "Matica Hrvatska", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))),
                "Hrvatski", 475, "Tvrdi uvez", "13,97 x 21,59 cm", 13.99), 2, 1.0 * 2, 1.0 * 1));
        otkupStavkaList.add(new OtkupStavka(2, new OtkupZaglavlje(2, 2, t2, new Partner(2, "PartnerTemp d.o.o",
                "Ulica Republike 150", "32165498721", "partner.temp@pgmail.com", "098462713", new Grad(2, "Sarajevo",
                "51000", new Drzava(2, "Bosna i Hercegovina"))), new Operater(2, "Pero", "Nadoveza", "73917400273",
                "pero.nadoveza@gmail.com", "peroN", "321")), new Knjiga(2, "Na Drini ćuprija", new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")), "1981",
                new Izdavac(1, "ABC Naklada", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))),
                "Bošnjački", 400, "Tvrdi uvez", "13,97 x 21,59 cm", 14.99), 2, 1.0 * 2, 1.0 * 1));
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Obrada Otkupa -----");
        System.out.println("1. Pregled otkupa");
        System.out.println("2. Unos novog otkupa");
        System.out.println("3. Promjena unešenih otkupa");
        System.out.println("4. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku obrade otkupa: ",
                "Odabir mora biti 1-4", 1, 4)) {
            case 1:
                pregledOtkupZaglavlje(true);
                prikaziIzbornik();
                break;
            case 2:
                unosOtkup();
                prikaziIzbornik();
                break;
            case 3:
                promjenaOtkup();
                prikaziIzbornik();
                break;
            case 4:
                break;
        }
    }
    // Parametar "jeLiPregledStavaka" -> true = Pregled stavaka odabranog zaglavlja || false = Pregled zaglavlja:
    private void pregledOtkupZaglavlje(boolean jeLiPregledStavaka) {
        System.out.println("--------------------");
        System.out.println("------ Otkupi ------");
        System.out.println("--------------------");
        int i = 1;
        for(OtkupZaglavlje o : otkupZaglavljeList) {
            System.out.println(i++ + ". Br. otkupa: " + o + ", " + o.getDatumOtkupa().format(Pomocno.formatter) + ", " + (o.getPartner() != null ? o.getPartner().toString() : "Partner nije unešen"));
        }
        System.out.println("--------------------");
        if (jeLiPregledStavaka) {
            System.out.println("1. Pregled stavaka otkupa \n2. Izlaz");
            int odabir = Pomocno.unosRasponBroja("Odabir: ", "Pogrešan unos", 1, 2);
            int zaglavljeIndex;
            if (odabir == 1) {
                if (otkupZaglavljeList.isEmpty()) {
                    System.out.println("\n--- Nema unešenih otkupa za pregled stavaka ---");
                } else {
                    zaglavljeIndex = Pomocno.unosRasponBroja("Odaberite redni broj otkupa za pregled stavaka: ", "Pogrešan unos", 1, otkupZaglavljeList.size());
                    if (provjeraPostojanjaStavaka(zaglavljeIndex - 1)) {
                        pregledOtkupStavka(otkupZaglavljeList.get(zaglavljeIndex - 1).getBrojOtkupa());
                    } else {
                        System.out.println("\n--- Nema unešenih stavaka za pregled ---");
                    }
                }
            }
        }
    }
    private void pregledOtkupStavka(int brojOtkupa) {
        System.out.println("-----------------------");
        System.out.println("---- Stavke Otkupa ----");
        System.out.println("-----------------------");
        int i = 1;
        for (OtkupStavka o : otkupStavkaList) {
            if (o.getOtkupZaglavlje().getBrojOtkupa() == brojOtkupa) {
                System.out.println(i++ + ". ID Stavke: " + o + ", " + o.getKnjiga() + ", " + o.getKolicina() + ", " + o.getCijenaOtkupa() + "€");
            }
        }
        System.out.println("-----------------------");
    }
    private void unosOtkup() {
        if (izbornik.getObradaPartner().getPartneri().isEmpty()) {
            System.out.println("\n--- Unos otkupa nemoguć bez unešenih partnera ---");
            return;
        } else if (izbornik.getObradaOperater().getOperateri().isEmpty()) {
            System.out.println("\n--- Unos otkupa nemoguć bez unešenih operatera ---");
            return;
        }
        OtkupZaglavlje otkupZaglavlje = unosPromjenaOtkupZaglavlje(0, true);
        int odabirNastavka = Pomocno.unosRasponBroja("\n1. Unos stavaka \n2. Nastavak bez unosa stavaka \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabirNastavka == 1) {
            if (izbornik.getObradaKnjiga().getKnjige().isEmpty()) {
                System.out.println("\n--- Unos stavke nemoguć bez unešenih knjiga ---");
                return;
            }
            while (true) {
                System.out.println("\n--- Unesite novu stavku otkupa ---");

                unosPromjenaOtkupStavka(otkupZaglavljeList.indexOf(otkupZaglavlje), 0, true);

                int odabir = Pomocno.unosRasponBroja("\n1. Unos nove stavke\n2. Izlaz \nOdabir: ", "Pogrešan unos", 1, 2);
                if (odabir == 2) {
                    break;
                }
            }
        }
    }
    private void promjenaOtkup() {
        if (otkupZaglavljeList.isEmpty()) {
            System.out.println("\n--- Nema unešenih otkupa za promjenu ---");
            return;
        }
        boolean mozeDalje = true;
        int odabirVrstePromjene;
        pregledOtkupZaglavlje(false);
        int brojOtkupZaglavlje = Pomocno.unosRasponBroja("Odaberi broj otkupa: ","Pogrešan unos",1,otkupZaglavljeList.size());
        int zaglavljeIndex = 0;
        for (OtkupZaglavlje o : otkupZaglavljeList) {
            if (o.getBrojOtkupa() == brojOtkupZaglavlje) {
                zaglavljeIndex = otkupZaglavljeList.indexOf(o);
            }
        }
        while(mozeDalje) {
            System.out.println("\n1. Promjena zaglavlja \n2. Promjena stavaka \n3. Izlaz");
            odabirVrstePromjene = Pomocno.unosInt("Odabir: ", "Pogrešan unos");
            switch (odabirVrstePromjene) {
                case 1:
                    unosPromjenaOtkupZaglavlje(zaglavljeIndex, false);
                    break;
                case 2:
                    promjenaOtkupStavka(zaglavljeIndex);
                    break;
                case 3:
                    mozeDalje = false;
                    break;
            }
        }
    }
    private void promjenaOtkupStavka(int zaglavljeIndex) {
        boolean mozeDalje = true;
        while (mozeDalje) {
            pregledOtkupStavka(otkupZaglavljeList.get(zaglavljeIndex).getBrojOtkupa());
            int odabir = Pomocno.unosRasponBroja("1. Unos nove stavke \n2. Promjena postojeće stavke " +
                    "\n3. Brisanje stavaka \n4. Izlaz \nOdabir: ", "Pogrešan unos", 1, 4);
            switch (odabir) {
                case 1:
                    unosPromjenaOtkupStavka(zaglavljeIndex, 0, true);
                    break;
                case 2:
                    if (provjeraPostojanjaStavaka(zaglavljeIndex)) {
                        unosPromjenaOtkupStavka(0, odabirStavka(zaglavljeIndex, true), false);
                        break;
                    } else {
                        System.out.println("\n--- Nema unešenih stavaka za brisanje ---\n");
                    }
                    break;
                case 3:
                    if (provjeraPostojanjaStavaka(zaglavljeIndex)) {
                        otkupStavkaList.remove(odabirStavka(zaglavljeIndex, false));
                        break;
                    } else {
                        System.out.println("\n--- Nema unešenih stavaka za brisanje ---\n");
                    }
                    break;
                case 4:
                    mozeDalje = false;
                    break;
            }
        }
    }
    // Parametar "jeLiUnos" -> true = Unos || false = Promjena:
    private OtkupZaglavlje unosPromjenaOtkupZaglavlje(int indexZaglavlje, boolean jeLiUnos) {
        OtkupZaglavlje otkupZaglavlje = jeLiUnos ? new OtkupZaglavlje() : otkupZaglavljeList.get(indexZaglavlje);

        String porukaDatum = jeLiUnos ? "" : " (" + otkupZaglavlje.getDatumOtkupa().format(Pomocno.formatter) + ")";

        otkupZaglavlje.setDatumOtkupa(Pomocno.unosDatum("\nUnesi datum otkupa (dd.MM.yyyy. HH:mm:ss)" + porukaDatum + ": "));
        otkupZaglavlje.setPartner(postaviPartnera(otkupZaglavlje));
        otkupZaglavlje.setOperater(postaviOperatera(otkupZaglavlje));

        if (jeLiUnos) {
            otkupZaglavlje.setId(idOtkupZaglavlje++);
            otkupZaglavlje.setBrojOtkupa(brojOtkupaCounter++);
            otkupZaglavljeList.add(otkupZaglavlje);
        }
        return otkupZaglavlje;
    }
    // Parametar "jeLiUnos" -> true = Unos || false = Promjena:
    private void unosPromjenaOtkupStavka(int indexZaglavlje, int indexStavka, boolean jeLiUnos) {
        OtkupStavka otkupStavka = jeLiUnos ? new OtkupStavka() : otkupStavkaList.get(indexStavka);

        String porukaKolicina = jeLiUnos ? "" : " (" + otkupStavka.getKolicina() + ")";
        String porukaCijenaArtikla = jeLiUnos ? "" : " (" + otkupStavka.getCijenaOtkupaArtikla() + ")";

        otkupStavka.setKnjiga(postaviKnjigu(otkupStavka));
        otkupStavka.setKolicina(Pomocno.unosInt("Unesi količinu" + porukaKolicina + ": ", "Pogrešan unos"));
        otkupStavka.setCijenaOtkupaArtikla(Pomocno.unosDouble("Unesi cijenu otkupa artikla" + porukaCijenaArtikla + ": ", "Pogrešan unos"));
        otkupStavka.setCijenaOtkupa(otkupStavka.getCijenaOtkupaArtikla() * otkupStavka.getKolicina());
        System.out.println("(" + otkupStavka.getKnjiga() + ") " + otkupStavka.getCijenaOtkupaArtikla() + " x "
                + otkupStavka.getKolicina() + " = " + otkupStavka.getCijenaOtkupaArtikla() * otkupStavka.getKolicina() + "€");

        if (jeLiUnos) {
            otkupStavka.setId(idOtkupStavka++);
            otkupStavka.setOtkupZaglavlje(otkupZaglavljeList.get(indexZaglavlje));
            otkupStavkaList.add(otkupStavka);
        }
    }
    // Varijabla "odabirNull" služi tome kako bi bilo omogućeno unos otkupa bez unosa partnera:
    private Partner postaviPartnera(OtkupZaglavlje otkupZaglavlje) {
        int index;
        int odabirNull = izbornik.getObradaPartner().getPartneri().size() + 1;
        String partner = otkupZaglavlje.getPartner() != null ? " (" + otkupZaglavlje.getPartner().toString() + ")" : "";
        izbornik.getObradaPartner().pregledPartnera(true);
        while (true) {
            index = Pomocno.unosRasponBroja("Odaberi redni broj partnera" + partner + ": ", "Pogrešan unos", 1, odabirNull);
            if (index >= 1 && index <= odabirNull) {
                break;
            } else {
                System.out.println("Pogrešan unos");
            }
        }
        if (index <= odabirNull - 1) {
            return izbornik.getObradaPartner().getPartneri().get(index-1);
        } else {
            return null;
        }
    }
    private Operater postaviOperatera(OtkupZaglavlje otkupZaglavlje) {
        String operater = otkupZaglavlje.getOperater() != null ? " (" + otkupZaglavlje.getOperater().toString() + ")" : "";
        izbornik.getObradaOperater().pregledOperatera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj operatera" + operater + ": ","Pogrešan unos",1,izbornik.getObradaOperater().getOperateri().size());
        return izbornik.getObradaOperater().getOperateri().get(index-1);
    }
    private Knjiga postaviKnjigu(OtkupStavka otkupStavka) {
        String knjiga = otkupStavka.getKnjiga() != null ? " (" + otkupStavka.getKnjiga().toString() + ")" : "";
        izbornik.getObradaKnjiga().pregledKnjiga(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj knjige" + knjiga + ": ","Pogrešan unos",1,izbornik.getObradaKnjiga().getKnjige().size());
        return izbornik.getObradaKnjiga().getKnjige().get(index-1);
    }
    // Parametar "jeLiPromjena" -> true = Promjena || false = Brisanje
    private int odabirStavka(int zaglavljeIndex, boolean jeLiPromjena) {
        List<Integer> indexStavkaList = new ArrayList<>();
        String createUpdateStr = jeLiPromjena ? "promjenu" : "brisanje";
        int indexStavka = -1;
        while (true) {
            int odabir = Pomocno.unosInt("Unesi ID željene stavke za " + createUpdateStr + ": ", "Pogrešan unos");
            for (OtkupStavka o : otkupStavkaList) {
                if (o.getOtkupZaglavlje().getId() == otkupZaglavljeList.get(zaglavljeIndex).getId()) {
                    indexStavkaList.add(otkupStavkaList.indexOf(o));
                }
            }
            for (int e : indexStavkaList) {
                if (otkupStavkaList.get(e).getId() == odabir) {
                    indexStavka = e;
                }
            }
            if (indexStavka >= 0) {
                break;
            } else {
                System.out.println("Pogrešan unos");
            }
        }
        return indexStavka;
    }
    private boolean provjeraPostojanjaStavaka(int zaglavljeIndex) {
        boolean stavkaPostoji = false;
        for (OtkupStavka o : otkupStavkaList) {
            if (o.getOtkupZaglavlje().getId() == otkupZaglavljeList.get(zaglavljeIndex).getId()) {
                stavkaPostoji = true;
                break;
            }
        }
        return stavkaPostoji;
    }
}
