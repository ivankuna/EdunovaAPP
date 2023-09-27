package antikvarijat.controller;

import antikvarijat.model.NacinPlacanja;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaNacinPlacanja extends Obrada<NacinPlacanja> {

    @Override
    public List<NacinPlacanja> read() {
        return session.createQuery("from NacinPlacanja", NacinPlacanja.class).list();        
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
            sb.append("Nemoguće obrisati način plačanja sa unešenim rezervacijama (");
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
            throw new SimpleException("Naziv načina plačanja mora biti definiran");            
        }
        if (entitet.getNazivNacinaPlacanja().isEmpty()) {
            throw new SimpleException("Naziv načina plačanja ne smije ostati prazan");            
        }        
    }
    
    private void kontrolaOznaka() throws SimpleException {
        if (entitet.getOznakaNacinaPlacanja() == null) {
            throw new SimpleException("Oznaka načina plačanja mora biti definirana");
        }
        if (entitet.getOznakaNacinaPlacanja().isEmpty()) {            
            throw new SimpleException("Oznaka načina plačanja ne smije ostati prazna");
        }        
    }
}
