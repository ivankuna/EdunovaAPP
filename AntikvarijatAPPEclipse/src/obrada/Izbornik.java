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
    private ObradaOtkup obradaOtkup;
    private ObradaProdaja obradaProdaja;
    private ObradaNacinPlacanja obradaNacinPlacanja;
    private ObradaRezervacija obradaRezervacija;
    private ObradaStanje obradaStanje;

    public Izbornik() {
        obradaDrzava = new ObradaDrzava(this);
        obradaGrad = new ObradaGrad(this);
        obradaAutor = new ObradaAutor(this);
        obradaIzdavac = new ObradaIzdavac(this);
        obradaPartner = new ObradaPartner(this);
        obradaOperater = new ObradaOperater(this);
        obradaKnjiga = new ObradaKnjiga(this);
        obradaOtkup = new ObradaOtkup(this);
        obradaProdaja = new ObradaProdaja(this);
        obradaNacinPlacanja = new ObradaNacinPlacanja(this);
        obradaRezervacija = new ObradaRezervacija(this);
        obradaStanje = new ObradaStanje(this);
        Pomocno.ulaz = new Scanner(System.in);
        pozdravnaPoruka();
        prikaziIzbornik();
        Pomocno.ulaz.close();
    }
    private void pozdravnaPoruka() {
        System.out.println("************************************");
        System.out.println("**** Antikvarijat Console APP  ****");
        System.out.println("************************************");
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
        System.out.println("7. Knjige");
        System.out.println("8. Načini Plaćanja");
        System.out.println("9. Otkup Obrada");
        System.out.println("10. Prodaja Obrada");
        System.out.println("11. Rezervacije");
        System.out.println("12. Stanje");
        System.out.println("(0) Izlaz iz programa");
        ucitajStavkuIzbornika();
    }
    private void ucitajStavkuIzbornika() {
        switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika: ",
                "Obavezno 0-12",0,12)) {
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
            case 7:
                obradaKnjiga.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 8:
                obradaNacinPlacanja.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 9:
                obradaOtkup.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 10:
                obradaProdaja.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 11:
                obradaRezervacija.prikaziIzbornik();
                prikaziIzbornik();
                break;
            case 12:
                obradaStanje.prikaziIzbornik();
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
    public ObradaPartner getObradaPartner() {
        return obradaPartner;
    }
    public ObradaOperater getObradaOperater() {
        return obradaOperater;
    }
    public ObradaKnjiga getObradaKnjiga() {
        return obradaKnjiga;
    }
    public ObradaNacinPlacanja getObradaNacinPlacanja() {
        return obradaNacinPlacanja;
    }
    public ObradaOtkup getObradaOtkup() {
        return obradaOtkup;
    }
    public ObradaProdaja getObradaProdaja() {
        return obradaProdaja;
    }
    public ObradaRezervacija getObradaRezervacija() {
        return obradaRezervacija;
    }
    public ObradaStanje getObradaStanje() {
        return obradaStanje;
    }
}
