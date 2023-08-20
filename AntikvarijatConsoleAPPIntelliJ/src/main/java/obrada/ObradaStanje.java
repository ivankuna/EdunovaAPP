package obrada;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ObradaStanje {
    private int idStanje = 1;
    private List<Stanje> stanjeList;
    private Izbornik izbornik;

    public ObradaStanje(Izbornik izbornik) {
        this();
        this.izbornik = izbornik;
    }
    public ObradaStanje() {
        stanjeList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {

    }
    public List<Stanje> getStanjeList() {
        return stanjeList;
    }

    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Stanje izbornik -----");
        System.out.println("1. Pregled stanja");
        System.out.println("2. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku stanje izbornika: ",
                "Odabir mora biti 1-2", 1, 2)) {
            case 1:
                refreshStanje();
                pregledStanja();
                prikaziIzbornik();
                break;
            case 2:
                break;
        }
    }
    public void refreshStanje() {
        stanjeList = new ArrayList<>();
        int ulaz = 0;
        int izlaz = 0;
        int rezervirano = 0;
        int stanjeKnjige;
        int raspolozivo;
        for (Knjiga k : izbornik.getObradaKnjiga().getKnjige()) {
            for (OtkupStavka os : izbornik.getObradaOtkup().getOtkupStavkaList()) {
                if (os.getKnjiga().getId() == k.getId()) {
                    ulaz += os.getKolicina();
                }
            }
            for (ProdajaStavka ps : izbornik.getObradaProdaja().getProdajaStavkaList()) {
                if (ps.getKnjiga().getId() == k.getId()) {
                    izlaz += ps.getKolicina();
                }
            }
            for (Rezervacija r : izbornik.getObradaRezervacija().getRezervacijaList()) {
                if (r.getKnjiga().getId() == k.getId() && r.getStanje().equals("Rezervirano")) {
                    rezervirano += 1;
                }
            }
            stanjeKnjige = ulaz - izlaz;
            raspolozivo = stanjeKnjige - rezervirano;
            stanjeList.add(new Stanje(idStanje++, k.getNazivKnjige(), k.getAutor().getNazivAutora(), ulaz, izlaz, rezervirano, stanjeKnjige, raspolozivo));
            ulaz = 0;
            izlaz = 0;
            rezervirano = 0;
        }
    }
    // Parametri "idZaglavljeProdaje" i "idRezervacije" služe kako bi u slučaju promjene otkupa zanemarili
    // otkup u pitanju u provjeri raspoloživosti artikla. Time omogućujemo promjenu sadržaja stavke:
    public int raspolozivostKnjige(int idKnjiga, int idZaglavljeProdaje, int idRezervacije) {
        int ulaz = 0;
        int izlaz = 0;
        int rezervirano = 0;
        int stanjeKnjige;
        for (OtkupStavka os : izbornik.getObradaOtkup().getOtkupStavkaList()) {
            if (os.getKnjiga().getId() == idKnjiga) {
                ulaz += os.getKolicina();
            }
        }
        for (ProdajaStavka ps : izbornik.getObradaProdaja().getProdajaStavkaList()) {
            if (ps.getKnjiga().getId() == idKnjiga) {
                if (ps.getProdajaZaglavlje().getId() != idZaglavljeProdaje) {
                    izlaz += ps.getKolicina();
                }
            }
        }
        for (Rezervacija r : izbornik.getObradaRezervacija().getRezervacijaList()) {
            if (r.getKnjiga().getId() == idKnjiga && r.getStanje().equals("Rezervirano")) {
                if (r.getId() != idRezervacije) {
                    rezervirano += 1;
                }
            }
        }
        stanjeKnjige = ulaz - izlaz;
        return stanjeKnjige - rezervirano;
    }

    private void pregledStanja() {
        System.out.println("\nUlaz -> UL \nIzlaz -> IZ \nRezervirano -> REZ \nStanje -> ST \nRaspoloživo -> RAS");
        System.out.println("--------------- -------------------- --- --- --- --- ---");
        System.out.println("Autor           Knjiga               UL  IZ  REZ ST  RAS");
        System.out.println("--------------- -------------------- --- --- --- --- ---");
        for (Stanje stanje : stanjeList) {
            System.out.println(formatNaslovKnjigeIliNazivAutora(15, stanje.getNazivAutora()) + " " + formatNaslovKnjigeIliNazivAutora(20, stanje.getNaslovKnjige())
            + " " + formatBrojcanaVrijednost(stanje.getUlaz()) + " " + formatBrojcanaVrijednost(stanje.getIzlaz()) + " " + formatBrojcanaVrijednost(stanje.getRezervirano())
            + " " + formatBrojcanaVrijednost(stanje.getStanje()) + " " + formatBrojcanaVrijednost(stanje.getRaspolozivo()));
        }
        System.out.println("--------------- -------------------- --- --- --- --- ---");
    }
    private String formatNaslovKnjigeIliNazivAutora(int maxLen, String ulaz) {
        StringBuilder sb = new StringBuilder();
        char c;
        if (ulaz.length() > maxLen) {
            for (int i = 0; i < maxLen; i++) {
                c = ulaz.charAt(i);
                sb.append(c);
            }
        } else {
            sb = new StringBuilder(ulaz);
            for (int i = 0; i < maxLen - ulaz.length(); i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String formatBrojcanaVrijednost(int ulaz) {
        StringBuilder sb = new StringBuilder();

        if (ulaz > 99) {
            return String.valueOf(ulaz);
        } else if (ulaz > 9) {
            sb.append(ulaz).append(" ");
        } else {
            sb.append(ulaz).append("  ");
        }
        return sb.toString();
    }
}
