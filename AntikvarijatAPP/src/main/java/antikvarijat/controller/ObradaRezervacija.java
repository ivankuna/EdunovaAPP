package antikvarijat.controller;

import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaRezervacija extends Obrada<Rezervacija> {

    @Override
    public List<Rezervacija> read() {
        return session.createQuery("from Rezervacija", Rezervacija.class).list();        
    }
    
    public Rezervacija readBySifra(int id){
        return session.get(Rezervacija.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaKnjiga();
        kontrolaOperater();
        kontrolaPartner();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (!entitet.getStanje().equals("izvršeno"))
            throw new SimpleException("Rezervacija nije izvršena");
        }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }
          
    private void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }

    private void kontrolaPartner() throws SimpleException {
        if (entitet.getPartner() == null) {
            throw new SimpleException("Partner mora biti definiran");
        }
    }
}
