package antikvarijat.controller;

import antikvarijat.model.Izdavac;
import antikvarijat.model.Knjiga;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaIzdavac extends Obrada<Izdavac> {

    @Override
    public List<Izdavac> read() {
        return session.createQuery("from Izdavac", Izdavac.class).list();
    }
    
    public List<Izdavac> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Izdavac> lista = session.createQuery("from Izdavac i "
                + " where i.nazivIzdavaca like :uvjet "
                + " order by i.nazivIzdavaca ", Izdavac.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivIzdavaca(), e2.getNazivIzdavaca()));
        
        return lista;
    }
    
    public Izdavac readBySifra(int id){
        return session.get(Izdavac.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaGrad();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (!entitet.getKnjige().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati izdavača sa unešenim knjigama (");
            for (Knjiga k : entitet.getKnjige()) {    
                brojacZareza++;
                sb.append(k.getNazivKnjige());
                if (brojacZareza < entitet.getKnjige().size()) {
                    sb.append(",");
                }                
            }
            sb.append(")");                      
            throw new SimpleException(sb.toString());
        }
    }    

    private void kontrolaNaziv() throws SimpleException{
        if (entitet.getNazivIzdavaca() == null) {
            throw new SimpleException("Naziv izdavača mora biti definiran");
        }
        if (entitet.getNazivIzdavaca().isEmpty()) {
            throw new SimpleException("Naziv izdavača ne smije ostati prazan");
        }
    }
    
    private void kontrolaGrad() throws SimpleException {
        if (entitet.getGrad() == null) {
            throw new SimpleException("Grad mora biti definiran");
        }        
    }
}
