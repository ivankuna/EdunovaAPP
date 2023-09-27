package antikvarijat.controller;

import antikvarijat.model.ProdajaStavka;
import antikvarijat.util.SimpleException;
import java.math.BigDecimal;
import java.util.List;

public class ObradaProdajaStavka extends Obrada<ProdajaStavka> {

    @Override
    public List<ProdajaStavka> read() {
        return session.createQuery("from ProdajaStavka", ProdajaStavka.class).list();        
    }
    
    public ProdajaStavka readBySifra(int id){
        return session.get(ProdajaStavka.class, id);
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
        if (entitet.getCijenaProdaje() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        } 
    }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }

    private void kontrolaZaglavlje() throws SimpleException {
        if (entitet.getProdajaZaglavlje() == null) {
            throw new SimpleException("Zaglavlje prodaje mora biti definirano");
        }
    }   
}
