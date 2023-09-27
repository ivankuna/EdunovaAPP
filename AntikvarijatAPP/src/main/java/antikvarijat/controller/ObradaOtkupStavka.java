package antikvarijat.controller;

import antikvarijat.model.OtkupStavka;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaOtkupStavka extends Obrada<OtkupStavka> {

    @Override
    public List<OtkupStavka> read() {
        return session.createQuery("from OtkupStavka", OtkupStavka.class).list();        
    }
    
    public OtkupStavka readBySifra(int id){
        return session.get(OtkupStavka.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaKolicina();  
        kontrolaCijena();
        kontrolaKnjiga();
        kontrolaZaglavlje();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Operater je slobodan brisati sve stavke
    }   
    
    private void kontrolaKolicina() throws SimpleException{
        if (entitet.getKolicina() < 1) {
            throw new SimpleException("Količina mora biti veća od 0");
        }
    }  
    
    private void kontrolaCijena() throws SimpleException {
        if (entitet.getCijenaOtkupaArtikla() == null || entitet.getCijenaOtkupa() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        } 
    }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }

    private void kontrolaZaglavlje() throws SimpleException {
        if (entitet.getOtkupZaglavlje() == null) {
            throw new SimpleException("Zaglavlje otkupa mora biti definirano");
        }
    }  
}
