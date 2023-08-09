package obrada;

import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ObradaProdaja {
    private int idProdajaZaglavlje = Pomocno.dev ? 2 : 1;
    private int idProdajaStavka = Pomocno.dev ? 3 : 1;
    private int brojProdajeCounter = Pomocno.dev ? 2 : 1;
    private List<ProdajaZaglavlje> prodajaZaglavljeList;
    private List<ProdajaStavka> prodajaStavkaList;
    private Izbornik izbornik;

    public ObradaProdaja(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaProdaja() {
        prodajaZaglavljeList = new ArrayList<>();
        prodajaStavkaList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    public List<ProdajaZaglavlje> getProdajaZaglavljeList() {
        return prodajaZaglavljeList;
    }
    public List<ProdajaStavka> getProdajaStavkaList() {
        return prodajaStavkaList;
    }

    private void testniPodaci() {
        LocalDateTime t1 = LocalDateTime.parse("01.05.2023. 17:35:00", Pomocno.formatter);
        prodajaZaglavljeList.add(new ProdajaZaglavlje(1, 1, t1, new Partner(1, "Beta Studio d.o.o",
                "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com", "091321123", new Grad(1, "Zagreb",
                "10000", new Drzava(1, "Republika Hrvatska"))), "ZKI", "JIR", new NacinPlacanja(1, "Gotovina",
                "G"), new Operater(1, "Ivan", "Kuna", "89877641989", "ivankuna@gmail.com", "ivanK", "123")));
        prodajaStavkaList.add(new ProdajaStavka(1, new ProdajaZaglavlje(1, 1, t1, new Partner(1, "Beta Studio d.o.o",
                "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com", "091321123", new Grad(1, "Zagreb",
                "10000", new Drzava(1, "Republika Hrvatska"))), "ZKI", "JIR", new NacinPlacanja(1, "Gotovina",
                "G"), new Operater(1, "Ivan", "Kuna", "89877641989", "ivankuna@gmail.com", "ivanK", "123")),
                new Knjiga(1, "Zlatarovo zlato", new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")), "1985",
                        new Izdavac(1, "Matica Hrvatska", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))),
                        "Hrvatski", 475, "Tvrdi uvez", "13,97 x 21,59 cm", 13.99), 1, 1.0));
//        prodajaStavkaList.add(new ProdajaStavka(2, new ProdajaZaglavlje(1, 1, t1, new Partner(1, "Beta Studio d.o.o",
//                "Hreljinska 19A", "12345678912", "beta.studio@poslovno.com", "091321123", new Grad(1, "Zagreb",
//                "10000", new Drzava(1, "Republika Hrvatska"))), "ZKI", "JIR", new NacinPlacanja(1, "Gotovina",
//                "G"), new Operater(1, "Ivan", "Kuna", "89877641989", "ivankuna@gmail.com", "ivanK", "123")),
//                new Knjiga(2, "Na Drini ćuprija", new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")), "1981",
//                        new Izdavac(1, "ABC Naklada", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))),
//                        "Bošnjački", 400, "Tvrdi uvez", "13,97 x 21,59 cm", 14.99), 2, 1.0));
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Obrada Prodaje -----");
        System.out.println("1. Pregled prodaja");
        System.out.println("2. Unos nove prodaje");
        System.out.println("3. Promjena unešenih prodaja");
        System.out.println("4. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku obrade prodaje: ",
                "Odabir mora biti 1-4", 1, 4)) {
            case 1:
                pregledProdajaZaglavlje(true);
                prikaziIzbornik();
                break;
            case 2:
                unosProdaja();
                prikaziIzbornik();
                break;
            case 3:
                promjenaProdaja();
                prikaziIzbornik();
                break;
            case 4:
                break;
        }
    }
    private void pregledProdajaZaglavlje(boolean pregledUnos) {
        System.out.println("-------------------");
        System.out.println("----- Prodaje -----");
        System.out.println("-------------------");
        int i = 1;
        for(ProdajaZaglavlje p : prodajaZaglavljeList) {
            System.out.println(i++ + ". Br. prodaje: " + p + ", " + p.getDatumProdaje().format(Pomocno.formatter) + ", " + (p.getPartner() != null ? p.getPartner().toString() : "Partner nije unešen"));
        }
        System.out.println("-------------------");
        if (pregledUnos) {
            System.out.println("1. Pregled stavaka prodaje \n2. Izlaz");
            int odabir = Pomocno.unosRasponBroja("Odabir: ", "Pogrešan unos", 1, 2);
            int zaglavljeIndex;
            if (odabir == 1) {
                if (prodajaZaglavljeList.isEmpty()) {
                    System.out.println("\n--- Nema unešenih prodaja za pregled stavaka ---");
                } else {
                    zaglavljeIndex = Pomocno.unosRasponBroja("Odaberite redni broj prodaje za pregled stavaka: ", "Pogrešan unos", 1, prodajaZaglavljeList.size());
                    if (provjeraPostojanjaStavaka(zaglavljeIndex - 1)) {
                        pregledProdajaStavka(prodajaZaglavljeList.get(zaglavljeIndex - 1).getBrojProdaje());
                    } else {
                        System.out.println("\n--- Nema unešenih stavaka za pregled ---");
                    }
                }
            }
        }
    }
    private void pregledProdajaStavka(int brojProdaje) {
        System.out.println("------------------------");
        System.out.println("---- Stavke Prodaje ----");
        System.out.println("------------------------");
        int i = 1;
        for (ProdajaStavka p : prodajaStavkaList) {
            if (p.getProdajaZaglavlje().getBrojProdaje() == brojProdaje) {
                System.out.println(i++ + ". ID Stavke: " + p + ", " + p.getKnjiga() + ", " + p.getKolicina() + ", " + p.getCijenaProdaje() + "€");
            }
        }
        System.out.println("------------------------");
    }
    private void unosProdaja() {
        if (izbornik.getObradaPartner().getPartneri().isEmpty()) {
            System.out.println("\n--- Unos prodaje nemoguć bez unešenih partnera ---");
            return;
        } else if (izbornik.getObradaNacinPlacanja().getNacinPlacanjaList().isEmpty()){
            System.out.println("\n--- Unos prodaje nemoguć bez unešenih načina plaćanja ---");
            return;
        } else if (izbornik.getObradaOperater().getOperateri().isEmpty()) {
            System.out.println("\n--- Unos prodaje nemoguć bez unešenih operatera ---");
            return;
        }
        ProdajaZaglavlje prodajaZaglavlje = createUpdateProdajaZaglavlje(0, true);
        int odabirNastavka = Pomocno.unosRasponBroja("\n1. Unos stavaka \n2. Nastavak bez unosa stavaka \nOdabir: ", "Pogrešan unos", 1, 2);
        if (odabirNastavka == 1) {
            if (izbornik.getObradaKnjiga().getKnjige().isEmpty()) {
                System.out.println("\n--- Unos stavke nemoguć bez unešenih knjiga ---");
                return;
            } else if (!izbornik.getObradaKnjiga().provjeraRaspolozivihKnjiga()) {
                System.out.println("\n--- Unos stavke nemoguć bez raspoloživih knjiga ---");
                return;
            }
            while (true) {
                System.out.println("\n--- Unesite novu stavku prodaje ---");

                createUpdateProdajaStavka(prodajaZaglavljeList.indexOf(prodajaZaglavlje), 0, true);

                int odabir = Pomocno.unosRasponBroja("\n1. Unos nove stavke\n2. Izlaz \nOdabir: ", "Pogrešan unos", 1, 2);
                if (odabir == 2) {
                    break;
                }
            }
        }
    }
    private void promjenaProdaja() {
        if (prodajaZaglavljeList.isEmpty()) {
            System.out.println("\n--- Nema unešenih prodaja za promjenu ---");
            return;
        }
        boolean mozeDalje = true;
        int odabirVrstePromjene;
        pregledProdajaZaglavlje(false);
        int brojProdajaZaglavlje = Pomocno.unosRasponBroja("Odaberi broj prodaje: ","Pogrešan unos",1,prodajaZaglavljeList.size());
        int zaglavljeIndex = 0;
        for (ProdajaZaglavlje p : prodajaZaglavljeList) {
            if (p.getBrojProdaje() == brojProdajaZaglavlje) {
                zaglavljeIndex = prodajaZaglavljeList.indexOf(p);
            }
        }
        while(mozeDalje) {
            System.out.println("\n1. Promjena zaglavlja \n2. Promjena stavaka \n3. Odustani");
            odabirVrstePromjene = Pomocno.unosInt("Odabir: ", "Pogrešan unos");
            switch (odabirVrstePromjene) {
                case 1:
                    createUpdateProdajaZaglavlje(zaglavljeIndex, false);
                    break;
                case 2:
                    promjenaProdajaStavka(zaglavljeIndex);
                    break;
                case 3:
                    mozeDalje = false;
                    break;
            }
        }
    }
    private void promjenaProdajaStavka(int zaglavljeIndex) {
        boolean mozeDalje = true;
        while (mozeDalje) {
            pregledProdajaStavka(prodajaZaglavljeList.get(zaglavljeIndex).getBrojProdaje());
            int odabir = Pomocno.unosRasponBroja("1. Unos nove stavke \n2. Promjena postojeće stavke " +
                    "\n3. Brisanje stavaka \n4. Odustani \nOdabir: ", "Pogrešan unos", 1, 4);
            switch (odabir) {
                case 1:
                    createUpdateProdajaStavka(zaglavljeIndex, 0, true);
                    break;
                case 2:
                    if (provjeraPostojanjaStavaka(zaglavljeIndex)) {
                        createUpdateProdajaStavka(0, odabirStavka(zaglavljeIndex, true), false);
                        break;
                    } else {
                        System.out.println("\n--- Nema unešenih stavaka za brisanje ---\n");
                    }
                    break;
                case 3:
                    if (provjeraPostojanjaStavaka(zaglavljeIndex)) {
                        prodajaStavkaList.remove(odabirStavka(zaglavljeIndex, false));
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
    private int odabirStavka(int zaglavljeIndex, boolean updateDelete) {
        List<Integer> indexStavkaList = new ArrayList<>();
        String createUpdateStr = updateDelete ? "promjenu" : "brisanje";
        int indexStavka = -1;
        while (true) {
            int odabir = Pomocno.unosInt("Unesi ID željene stavke za " + createUpdateStr + ": ", "Pogrešan unos");
            for (ProdajaStavka p : prodajaStavkaList) {
                if (p.getProdajaZaglavlje().getId() == prodajaZaglavljeList.get(zaglavljeIndex).getId()) {
                    indexStavkaList.add(prodajaStavkaList.indexOf(p));
                }
            }
            for (int e : indexStavkaList) {
                if (prodajaStavkaList.get(e).getId() == odabir) {
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
        for (ProdajaStavka p : prodajaStavkaList) {
            if (p.getProdajaZaglavlje().getId() == prodajaZaglavljeList.get(zaglavljeIndex).getId()) {
                stavkaPostoji = true;
                break;
            }
        }
        return stavkaPostoji;
    }
    private ProdajaZaglavlje createUpdateProdajaZaglavlje(int indexZaglavlje, boolean createUpdate) {
        ProdajaZaglavlje prodajaZaglavlje = createUpdate ? new ProdajaZaglavlje() : prodajaZaglavljeList.get(indexZaglavlje);

        String porukaDatum = createUpdate ? "" : " (" + prodajaZaglavlje.getDatumProdaje().format(Pomocno.formatter) + ")";

        prodajaZaglavlje.setDatumProdaje(Pomocno.unosDatum("\nUnesi datum prodaje (dd.MM.yyyy. HH:mm:ss)" + porukaDatum + ": "));
        prodajaZaglavlje.setPartner(postaviPartnera(prodajaZaglavlje));
        prodajaZaglavlje.setNacinPlacanja(postaviNacinPlacanja(prodajaZaglavlje));
        prodajaZaglavlje.setOperater(postaviOperatera(prodajaZaglavlje));

        if (createUpdate) {
            prodajaZaglavlje.setId(idProdajaZaglavlje++);
            prodajaZaglavlje.setBrojProdaje(brojProdajeCounter++);
            prodajaZaglavljeList.add(prodajaZaglavlje);
        }
        return prodajaZaglavlje;
    }
    private void createUpdateProdajaStavka(int indexZaglavlje, int indexStavka, boolean createUpdate) {
        ProdajaStavka prodajaStavka = createUpdate ? new ProdajaStavka() : prodajaStavkaList.get(indexStavka);
        if (createUpdate) {
            prodajaStavka.setId(idProdajaStavka++);
            prodajaStavka.setProdajaZaglavlje(prodajaZaglavljeList.get(indexZaglavlje));
        }
        prodajaStavka.setKnjiga(postaviKnjigu(prodajaStavka));

        if (createUpdate) {
            prodajaStavka.setKolicina(Pomocno.unosRasponBroja("Unesi količinu: ", "Pogrešan unos, broj raspoloživih kopija odabrane knjige iznosi: "
                            + izbornik.getObradaStanje().brojRaspolozivo(prodajaStavka.getKnjiga().getId(), 0, 0),
                    1, izbornik.getObradaStanje().brojRaspolozivo(prodajaStavka.getKnjiga().getId(), 0, 0)));
        } else {
            prodajaStavka.setKolicina(Pomocno.unosRasponBroja("Unesi količinu: ", "Pogrešan unos, broj raspoloživih kopija odabrane knjige iznosi: "
                            + izbornik.getObradaStanje().brojRaspolozivo(prodajaStavka.getKnjiga().getId(), prodajaStavka.getProdajaZaglavlje().getId(), 0),
                    1, izbornik.getObradaStanje().brojRaspolozivo(prodajaStavka.getKnjiga().getId(), prodajaStavka.getProdajaZaglavlje().getId(), 0) ));
        }
        prodajaStavka.setCijenaProdaje(prodajaStavka.getKnjiga().getCijena() * prodajaStavka.getKolicina());
        System.out.println("(" + prodajaStavka.getKnjiga() + ") " + prodajaStavka.getKnjiga().getCijena() + " x "
                + prodajaStavka.getKolicina() + " = " + prodajaStavka.getKnjiga().getCijena() * prodajaStavka.getKolicina() + "€");
        if (createUpdate) {
            prodajaStavkaList.add(prodajaStavka);
        }
    }
    private Partner postaviPartnera(ProdajaZaglavlje prodajaZaglavlje) {
        int index;
        int odabirNull = izbornik.getObradaPartner().getPartneri().size() + 1;
        String partner = prodajaZaglavlje.getPartner() != null ? " (" + prodajaZaglavlje.getPartner().toString() + ")" : "";
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
    private Operater postaviOperatera(ProdajaZaglavlje prodajaZaglavlje) {
        String operater = prodajaZaglavlje.getOperater() != null ? " (" + prodajaZaglavlje.getOperater().toString() + ")" : "";
        izbornik.getObradaOperater().pregledOperatera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj operatera" + operater + ": ","Pogrešan unos",1,izbornik.getObradaOperater().getOperateri().size());
        return izbornik.getObradaOperater().getOperateri().get(index-1);
    }
    private NacinPlacanja postaviNacinPlacanja(ProdajaZaglavlje prodajaZaglavlje) {
        String nacinPlacanja = prodajaZaglavlje.getNacinPlacanja() != null ? " (" + prodajaZaglavlje.getNacinPlacanja().toString() + ")" : "";
        izbornik.getObradaNacinPlacanja().pregledNacinaPlacanja();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj načina plaćanja" + nacinPlacanja + ": ","Pogrešan unos",1,izbornik.getObradaNacinPlacanja().getNacinPlacanjaList().size());
        return izbornik.getObradaNacinPlacanja().getNacinPlacanjaList().get(index-1);
    }
    private Knjiga postaviKnjigu(ProdajaStavka prodajaStavka) {
        int index;
        String knjiga = prodajaStavka.getKnjiga() != null ? " (" + prodajaStavka.getKnjiga().toString() + ")" : "";
        izbornik.getObradaKnjiga().pregledKnjiga(true, prodajaStavka.getProdajaZaglavlje().getId(),0);
        while (true) {
            index = Pomocno.unosRasponBroja("Odaberi redni broj knjige" + knjiga + ": ","Pogrešan unos",1,izbornik.getObradaKnjiga().getKnjige().size());
            if (izbornik.getObradaStanje().brojRaspolozivo(izbornik.getObradaKnjiga().getKnjige().get(index-1).getId(), prodajaStavka.getProdajaZaglavlje().getId(), 0) > 0) {
                break;
            } else {
                System.out.println("\nOdabrana knjiga nije raspoloživa!\n");
            }
        }
        return izbornik.getObradaKnjiga().getKnjige().get(index-1);
    }
}
