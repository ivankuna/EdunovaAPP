package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;
public class ObradaKnjiga {
    private int idKnjiga = Pomocno.dev ? 3 : 1;
    private List<Knjiga> knjige;
    private Izbornik izbornik;
    private final String[] vrsteUveza = {"Tvrdi uvez", "Meki uvez", "Polutvrdi uvez", "Spiralni uvez", "Plastični uvez"};
    private final String[] dimenzije = {"13,97 x 21,59 cm", "15,24 x 22,86 cm", "12,7 x 20,32 cm"};

    public ObradaKnjiga(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaKnjiga() {
        knjige = new ArrayList<>();
        if (Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {
        knjige.add(new Knjiga(1, "Zlatarovo zlato", new Autor(1, "August Šenoa", new Drzava(1, "Republika Hrvatska")), "1985",
                new Izdavac(1, "Matica Hrvatska", new Grad(1, "Zagreb", "10000", new Drzava(1, "Republika Hrvatska"))),
                "Hrvatski", 475, "Tvrdi uvez", "13,97 x 21,59 cm", 13.99));
        knjige.add(new Knjiga(2, "Na Drini ćuprija", new Autor(2, "Ivo Andrić", new Drzava(2, "Bosna i Hercegovina")), "1981",
                new Izdavac(1, "ABC Naklada", new Grad(2, "Sarajevo", "51000", new Drzava(2, "Bosna i Hercegovina"))),
                "Bošnjački", 400, "Tvrdi uvez", "13,97 x 21,59 cm", 14.99));
    }
    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Knjige izbornik -----");
        System.out.println("1. Pregled postojećih knjiga");
        System.out.println("2. Unos nove knjige");
        System.out.println("3. Promjena postojeće knjige");
        System.out.println("4. Brisanje postojeće knjige");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {

        switch(Pomocno.unosRasponBroja("Odaberi stavku knjiga izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledKnjiga(false);
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeKnjiga();
                prikaziIzbornik();
                break;
            case 3:
                promjenaKnjiga();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeKnjiga();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledKnjiga(boolean jeLiProdajaRezervacija) {
        int raspolozivost;
        System.out.println("------------------");
        System.out.println("----- Knjige -----");
        System.out.println("------------------");
        int i = 1;
        for(Knjiga k : knjige) {
            if (jeLiProdajaRezervacija) {
                raspolozivost = izbornik.getObradaStanje().brojRaspolozivo(k.getId(), 0, 0);
                System.out.println(i++ + ". " + k + " (" + k.getAutor().getNazivAutora() + ") " + "(" + raspolozivost + ")");
            } else {
                System.out.println(i++ + ". " + k + " (" + k.getAutor().getNazivAutora() + ")");
            }
        }
        System.out.println("------------------");
    }
    public void pregledKnjiga(boolean jeLiProdajaRezervacija, int idZaglavlje, int idRezervacije) {
        int raspolozivost;
        System.out.println("------------------");
        System.out.println("----- Knjige -----");
        System.out.println("------------------");
        int i = 1;
        for(Knjiga k : knjige) {
            if (jeLiProdajaRezervacija) {
                raspolozivost = izbornik.getObradaStanje().brojRaspolozivo(k.getId(), idZaglavlje, idRezervacije);
                System.out.println(i++ + ". " + k + " (" + k.getAutor().getNazivAutora() + ") " + "(" + raspolozivost + ")");
            } else {
                System.out.println(i++ + ". " + k + " (" + k.getAutor().getNazivAutora() + ")");
            }
        }
        System.out.println("------------------");
    }
    private void dodavanjeKnjiga() {
        if (izbornik.getObradaAutor().getAutori().isEmpty()) {
            System.out.println("\n--- Unos knjige nemoguć bez unešenih autora ---");
            return;
        } else if (izbornik.getObradaIzdavac().getIzdavaci().isEmpty()) {
            System.out.println("\n--- Unos knjige nemoguć bez unešenih izdavača ---");
            return;
        }
        Knjiga knjiga = new Knjiga();
        knjiga.setId(idKnjiga++);
        knjiga.setNazivKnjige(Pomocno.unosString("Unesi naziv knjige: ","Pogrešan unos"));
        knjiga.setAutor(postaviAutora(knjiga));
        knjiga.setGodinaIzdanja(Pomocno.unosString("Unesi godinu izdanja knjige (yyyy.): ","Pogrešan unos"));
        knjiga.setIzdavac(postaviIzdavaca(knjiga));
        knjiga.setJezik(Pomocno.unosString("Unesi jezik na kojem je pisana knjiga: ","Pogrešan unos"));
        knjiga.setBrojStranica(Pomocno.unosInt("Unesi broj stranica knjige: ", "Pogrešan unos"));
        knjiga.setVrstaUveza(postaviUvez(knjiga));
        knjiga.setDimenzije(postaviDimenzije(knjiga));
        knjiga.setCijena(Pomocno.unosDouble("Unesi cijenu knjige: ", "Pogrešan unos"));
        knjige.add(knjiga);
    }
    private void promjenaKnjiga() {
        if (knjige.isEmpty()) {
            System.out.println("\n--- Nema unešenih knjiga za promjenu ---");
            return;
        }
        pregledKnjiga(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj knjige: ","Pogrešan unos",1,knjige.size());
        Knjiga knjiga = knjige.get(index-1);
        knjiga.setNazivKnjige(Pomocno.unosString("Unesi naziv knjige (" + knjiga.getNazivKnjige() + "): ", "Pogrešan unos"));
        knjiga.setAutor(postaviAutora(knjiga));
        knjiga.setGodinaIzdanja(Pomocno.unosString("Unesi godinu izdanja knjige (yyyy) (" + knjiga.getGodinaIzdanja() + "): ", "Pogrešan unos"));
        knjiga.setIzdavac(postaviIzdavaca(knjiga));
        knjiga.setJezik(Pomocno.unosString("Unesi jezik na kojem je pisana knjiga (" + knjiga.getJezik() + "): ", "Pogrešan unos"));
        knjiga.setBrojStranica(Pomocno.unosInt("Unesi broj stranica knjige (" + knjiga.getBrojStranica() + "): ", "Pogrešan unos"));
        knjiga.setVrstaUveza(postaviUvez(knjiga));
        knjiga.setDimenzije(postaviDimenzije(knjiga));
        knjiga.setCijena(Pomocno.unosDouble("Unesi cijenu knjige (" + knjiga.getCijena() + "): ", "Pogrešan unos"));
    }
    private void brisanjeKnjiga() {
        if (knjige.isEmpty()) {
            System.out.println("\n--- Nema unešenih knjiga za brisanje ---");
            return;
        }
        pregledKnjiga(false);
        int index = Pomocno.unosRasponBroja("Odaberi redni broj knjige: ", "Pogrešan unos", 1, knjige.size());
        if (koristenjeKnjiga(index-1)) {
            System.out.println("\n--- Nemoguće obrisati knjigu u korištenju ---");
        } else {
            knjige.remove(index-1);
        }
    }
    private Autor postaviAutora(Knjiga knjiga) {
        String autor = knjiga.getAutor() != null ? " (" + knjiga.getAutor().toString() + ")" : "";
        izbornik.getObradaAutor().pregledAutora();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj autora" + autor + ": ","Pogrešan unos",1,izbornik.getObradaAutor().getAutori().size());
        return izbornik.getObradaAutor().getAutori().get(index-1);
    }
    private Izdavac postaviIzdavaca(Knjiga knjiga) {
        String izdavac = knjiga.getIzdavac() != null ? " (" + knjiga.getIzdavac().toString() + ")" : "";
        izbornik.getObradaIzdavac().pregledIzdavaca();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj izdavaca" + izdavac + ": ","Pogrešan unos",1,izbornik.getObradaIzdavac().getIzdavaci().size());
        return izbornik.getObradaIzdavac().getIzdavaci().get(index-1);
    }
    private String postaviUvez(Knjiga knjiga) {
        String uvez = knjiga.getVrstaUveza() != null ? " (" + knjiga.getVrstaUveza() + ")" : "";
        int i = 1;
        for (String u : vrsteUveza) {
            System.out.println(i++ + ". " + u);
        }
        int index = Pomocno.unosRasponBroja("Odaberi redni broj vrste uveza" + uvez + ": ", "Pogrešan unos", 1 , vrsteUveza.length);
        return vrsteUveza[index-1];
    }
    private String postaviDimenzije(Knjiga knjiga) {
        String dimezijetTemp = knjiga.getDimenzije() != null ? " (" + knjiga.getDimenzije() + ")" : "";
        int i = 1;
        for (String d : dimenzije) {
            System.out.println(i++ + ". " + d);
        }
        int index = Pomocno.unosRasponBroja("Odaberi redni broj dimenzija" + dimezijetTemp + ": ", "Pogrešan unos", 1 , dimenzije.length);
        return dimenzije[index-1];
    }
    private boolean koristenjeKnjiga(int index) {
        boolean koristiSe = false;
        for (OtkupStavka o : izbornik.getObradaOtkup().getOtkupStavkaList()) {
            if (knjige.get(index).equals(o.getKnjiga())) {
                koristiSe = true;
                break;
            }
        }
        for (ProdajaStavka p : izbornik.getObradaProdaja().getProdajaStavkaList()) {
            if (knjige.get(index).equals(p.getKnjiga())) {
                koristiSe = true;
                break;
            }
        }
        return koristiSe;
    }
    public boolean provjeraRaspolozivihKnjiga() {
        boolean postojiRaspolozivaKnjiga = false;
        for (Knjiga k : knjige) {
            if (izbornik.getObradaStanje().brojRaspolozivo(k.getId(), 0, 0) > 0) {
                postojiRaspolozivaKnjiga = true;
            }
        }
        return postojiRaspolozivaKnjiga;
    }
}
