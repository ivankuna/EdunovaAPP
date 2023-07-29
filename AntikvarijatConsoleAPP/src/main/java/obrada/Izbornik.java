package obrada;

import java.util.Scanner;

public class Izbornik {
    private ObradaDrzava obradaDrzava;
    private ObradaGrad obradaGrad;
    private ObradaAutor obradaAutor;
    private ObradaIzdavac obradaIzdavac;
    private ObradaPartner obradaPartner;
    private ObradaOperater obradaOperater;
    private ObradaKnjiga obradaKnjiga;

    public Izbornik() {
        obradaDrzava = new ObradaDrzava();
        obradaGrad = new ObradaGrad(this);
        obradaAutor = new ObradaAutor(this);
        obradaIzdavac = new ObradaIzdavac(this);
        obradaPartner = new ObradaPartner(this);
        obradaOperater = new ObradaOperater();
        obradaKnjiga = new ObradaKnjiga(this);
        Pomocno.ulaz = new Scanner(System.in);
        pozdravnaPoruka();
        prikaziIzbornik();
        Pomocno.ulaz.close();
    }
    private void pozdravnaPoruka() {
        System.out.println("**************************************");
        System.out.println("*** Antikvarijat Console APP v 1.0 ***");
        System.out.println("**************************************");
    }
    private void prikaziIzbornik() {
        System.out.println();
        System.out.println("----- Glavni izbornik -----");
        System.out.println("1. Države");
        System.out.println("2. Gradovi");
        System.out.println("3. Autori");
        System.out.println("4. Izdavači");
        System.out.println("5. Partneri");
        System.out.println("6. Operateri");
        System.out.println("(0) Izlaz iz programa");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika: ",
                "Obavezno 1-3",0,100)) {
            case 1:
                obradaDrzava.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 2:
                obradaGrad.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 3:
                obradaAutor.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 4:
                obradaIzdavac.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 5:
                obradaPartner.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 6:
                obradaOperater.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 0:
                System.out.println("Doviđenja");
                break;
        }
    }
    public ObradaDrzava getObradaDrzava() {
        return obradaDrzava;
    }
    public ObradaGrad getObradaGrad() {
        return obradaGrad;
    }
    public ObradaAutor getObradaAutor() {
        return obradaAutor;
    }
    public ObradaIzdavac getObradaIzdavac() {
        return obradaIzdavac;
    }
}
