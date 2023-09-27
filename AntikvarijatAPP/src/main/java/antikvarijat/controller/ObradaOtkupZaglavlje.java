package antikvarijat.controller;

import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaOtkupZaglavlje extends Obrada<OtkupZaglavlje> {

    @Override
    public List<OtkupZaglavlje> read() {
        return session.createQuery("from OtkupZaglavlje", OtkupZaglavlje.class).list();        
    }
    
    public OtkupZaglavlje readBySifra(int id){
        return session.get(OtkupZaglavlje.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaDatumVrijeme();
        kontrolaOperater();        
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Brisanje zaglavlja otkupa je onemogućeno
    }   
    
    private void kontrolaDatumVrijeme() throws SimpleException {  
        if (entitet.getDatumOtkupa()== null) {
            throw new SimpleException("Datum prodaje mora biti definiran");
        }                
    }
    
    public void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }    
}
