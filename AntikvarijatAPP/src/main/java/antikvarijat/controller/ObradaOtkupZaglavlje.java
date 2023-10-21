package antikvarijat.controller;

import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaOtkupZaglavlje extends Obrada<OtkupZaglavlje> {

    @Override
    public List<OtkupZaglavlje> read() {
        return session.createQuery("from OtkupZaglavlje", OtkupZaglavlje.class).list();        
    }
    
    public List<OtkupZaglavlje> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<OtkupZaglavlje> lista = session.createQuery("from OtkupZaglavlje oz "
                + " where oz.id like :uvjet "
                + " order by oz.id ", OtkupZaglavlje.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getId(), e2.getId()));
        
        return lista;
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
        if (entitet.getDatumOtkupa() == null) {
            throw new SimpleException("Datum i vrijeme prodaje moraju biti definirani");
        }                
    }
    
    public void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }    
}
