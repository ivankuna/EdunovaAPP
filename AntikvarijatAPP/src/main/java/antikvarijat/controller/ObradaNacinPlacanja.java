package antikvarijat.controller;

import antikvarijat.model.NacinPlacanja;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaNacinPlacanja extends Obrada<NacinPlacanja> {

    @Override
    public List<NacinPlacanja> read() {
        return session.createQuery("from NacinPlacanja", NacinPlacanja.class).list();        
    }
    
    public List<NacinPlacanja> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<NacinPlacanja> lista = session.createQuery("from NacinPlacanja np "
                + " where np.nazivNacinaPlacanja like :uvjet "
                + " order by np.nazivNacinaPlacanja ", NacinPlacanja.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivNacinaPlacanja(), e2.getNazivNacinaPlacanja()));
        
        return lista;
    }
    
    public NacinPlacanja readBySifra(int id){
        return session.get(NacinPlacanja.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaOznaka();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (!entitet.getProdaje().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati način plaćanja sa unešenim prodajama (");
            for (ProdajaZaglavlje pz : entitet.getProdaje()) {    
                brojacZareza++;                
                sb.append("ID: ").append(pz.getId());
                if (brojacZareza < entitet.getProdaje().size()) {
                    sb.append(",");
                }                
            }
            sb.append(")");                      
            throw new SimpleException(sb.toString());
        }
    }    

    private void kontrolaNaziv() throws SimpleException {
        if (entitet.getNazivNacinaPlacanja() == null) {
            throw new SimpleException("Naziv načina plaćanja mora biti definiran");            
        }
        if (entitet.getNazivNacinaPlacanja().isEmpty()) {
            throw new SimpleException("Naziv načina plaćanja ne smije ostati prazan");            
        }        
    }
    
    private void kontrolaOznaka() throws SimpleException {
        if (entitet.getOznakaNacinaPlacanja() == null) {
            throw new SimpleException("Oznaka načina plaćanja mora biti definirana");
        }
        if (entitet.getOznakaNacinaPlacanja().isEmpty()) {            
            throw new SimpleException("Oznaka načina plaćanja ne smije ostati prazna");
        }        
    }
}
