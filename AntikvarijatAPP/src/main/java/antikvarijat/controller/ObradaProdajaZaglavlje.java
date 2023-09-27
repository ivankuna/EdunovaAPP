package antikvarijat.controller;

import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaProdajaZaglavlje extends Obrada<ProdajaZaglavlje> {

    @Override
    public List<ProdajaZaglavlje> read() {
        return session.createQuery("from ProdajaZaglavlje", ProdajaZaglavlje.class).list();        
    }
    
    public ProdajaZaglavlje readBySifra(int id){
        return session.get(ProdajaZaglavlje.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaDatumVrijeme();
        kontrolaNacinPlacanja();        
        kontrolaOperater();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Brisanje zaglavlja prodaje je onemogućeno
    }    

    private void kontrolaDatumVrijeme() throws SimpleException {  
        if (entitet.getDatumProdaje() == null) {
            throw new SimpleException("Datum prodaje mora biti definiran");
        }                
    }

    private void kontrolaNacinPlacanja() throws SimpleException {
        if (entitet.getNacinPlacanja() == null) {
            throw new SimpleException("Način plačanja mora biti definiran");
        }
    }

    public void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }
}
