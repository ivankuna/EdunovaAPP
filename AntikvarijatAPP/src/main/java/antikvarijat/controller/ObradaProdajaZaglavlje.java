package antikvarijat.controller;

import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import java.util.ArrayList;
import java.util.List;

public class ObradaProdajaZaglavlje extends Obrada<ProdajaZaglavlje> {

    @Override
    public List<ProdajaZaglavlje> read() {
        return session.createQuery("from ProdajaZaglavlje", ProdajaZaglavlje.class).list();        
    }
    
    public List<ProdajaZaglavlje> read(int searchNumber) {
        List<ProdajaZaglavlje> ProdajaZaglavljeList = new ArrayList<>();

        String queryString = "from ProdajaZaglavlje pz where CAST(pz.id AS string) like :searchNumber";

        ProdajaZaglavljeList = session.createQuery(queryString, ProdajaZaglavlje.class)
                .setParameter("searchNumber", "%" + searchNumber + "%")
                .list();

        return ProdajaZaglavljeList;
    }
    
    public ProdajaZaglavlje readBySifra(int id){
        return session.get(ProdajaZaglavlje.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaOperater();
        kontrolaDatumVrijeme();
        kontrolaNacinPlacanja(); 
        kontrolaPartner();        
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Brisanje zaglavlja prodaje je onemogućeno
    }    
    
    public void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }    

    private void kontrolaDatumVrijeme() throws SimpleException {  
        if (entitet.getDatumProdaje() == null) {
            throw new SimpleException("Datum prodaje mora biti definiran");
        }                
    }

    private void kontrolaNacinPlacanja() throws SimpleException {
        if (entitet.getNacinPlacanja() == null || getEntitet().getNacinPlacanja().getId().equals(0)) {
            throw new SimpleException("Način plaćanja mora biti definiran");
        }
    }
    
    public void kontrolaPartner() throws SimpleException {
        if (entitet.getPartner() == null || getEntitet().getPartner().getId().equals(0)) {
            throw new SimpleException("Partner mora biti definiran");
        }
    }
}
