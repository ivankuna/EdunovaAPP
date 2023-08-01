package obrada;

import model.Operater;

import java.util.ArrayList;
import java.util.List;

public class ObradaOperater {
    private List<Operater> operateri;
    public ObradaOperater() {
        operateri = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    //    ****** Testni podaci ******
    private void testniPodaci() {
        operateri.add(new Operater(1, "Ivan", "Kuna", "89877641989", "ivankuna@gmail.com", "ivanK", "123"));
        operateri.add(new Operater(2, "Pero", "Nadoveza", "73917400273", "pero.nadoveza@gmail.com", "peroN", "321"));
    }
    //    ***************************
    public List<Operater> getOperateri() {
        return operateri;
    }
    public void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Operater izbornik -----");
        System.out.println("1. Pregled postojećih operatera");
        System.out.println("2. Unos novog operatera");
        System.out.println("3. Promjena postojećih operatera");
        System.out.println("4. Brisanje postojećih operatera");
        System.out.println("5. Povratak na prethodni izbornik");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku operater izbornika: ",
                "Odabir mora biti 1-5", 1, 5)) {
            case 1:
                pregledOperatera();
                prikaziIzbornik();
                break;
            case 2:
                dodavanjeOperatera();
                prikaziIzbornik();
                break;
            case 3:
                promjenaOperatera();
                prikaziIzbornik();
                break;
            case 4:
                brisanjeOperatera();
                prikaziIzbornik();
                break;
            case 5:
                break;
        }
    }
    public void pregledOperatera() {
        System.out.println("-----------------------");
        System.out.println("------ Operateri ------");
        System.out.println("-----------------------");
        int i = 1;
        for(Operater o : operateri) {
            System.out.println(i++ + ". " + o + " (" + o.getOib() + ")");
        }
        System.out.println("-----------------------");
    }
    private void dodavanjeOperatera() {
        Operater operater = new Operater();
        operater.setId(Pomocno.unosRasponBroja("Unesi šifru operatera: ","Broj mora biti pozitivan",
                1,Integer.MAX_VALUE));
        operater.setIme(Pomocno.unosString("Unesi ime operatera: ","Pogrešan unos"));
        operater.setPrezime(Pomocno.unosString("Unesi prezime operatera: ","Pogrešan unos"));
        operater.setOib(Pomocno.unosString("Unesi oib operatera: ","Pogrešan unos"));
        operater.setEmail(Pomocno.unosString("Unesi email operatera: ","Pogrešan unos"));
        operater.setKorisnickoIme(Pomocno.unosString("Unesi korisničko ime operatera: ","Pogrešan unos"));
        operater.setLozinka(Pomocno.unosString("Unesi lozinku operatera: ","Pogrešan unos"));
        operateri.add(operater);
    }
    private void promjenaOperatera() {
        pregledOperatera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj operatera: ","Pogrešan unos",1,operateri.size());
        Operater operater = operateri.get(index-1);
        operater.setIme(Pomocno.unosString("Unesi ime operatera (" + operater.getIme() + "): ","Pogrešan unos"));
        operater.setPrezime(Pomocno.unosString("Unesi prezime operatera (" + operater.getPrezime() + "): ","Pogrešan unos"));
        operater.setOib(Pomocno.unosString("Unesi oib operatera (" + operater.getOib() + "): ","Pogrešan unos"));
        operater.setEmail(Pomocno.unosString("Unesi email operatera (" + operater.getEmail() + "): ","Pogrešan unos"));
        operater.setKorisnickoIme(Pomocno.unosString("Unesi korisničko ime operatera (" + operater.getKorisnickoIme() + "): ","Pogrešan unos"));
        operater.setLozinka(Pomocno.unosString("Unesi lozinku operatera (" + operater.getLozinka() + "): ","Pogrešan unos"));
    }
    private void brisanjeOperatera() {
        pregledOperatera();
        int index = Pomocno.unosRasponBroja("Odaberi redni broj operatera: ", "Pogrešan unos", 1, operateri.size());
        operateri.remove(index-1);
    }
}
