package antikvarijat.controller;

import antikvarijat.model.Autor;
import antikvarijat.model.Knjiga;
import antikvarijat.model.Partner;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaAutor extends Obrada<Autor> {

    @Override
    public List<Autor> read() {
        return session.createQuery("from Autor", Autor.class).list();
    }
    
    public Autor readBySifra(int id){
        return session.get(Autor.class, id);
    } 
    
    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
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
            sb.append("Nemoguće obrisati autora sa unešenim knjigama (");
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

    private void kontrolaNaziv() throws SimpleException {
        if (entitet.getNazivAutora() == null) {
            throw new SimpleException("Naziv autora mora biti definiran");
        }
        if (entitet.getNazivAutora().isEmpty()) {
            throw new SimpleException("Naziv autora ne smije ostati prazan");
        }
    }
}
