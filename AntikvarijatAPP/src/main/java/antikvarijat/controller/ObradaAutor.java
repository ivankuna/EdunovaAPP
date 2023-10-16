package antikvarijat.controller;

import antikvarijat.model.Autor;
import antikvarijat.model.Knjiga;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaAutor extends Obrada<Autor> {

    @Override
    public List<Autor> read() {
        return session.createQuery("from Autor", Autor.class).list();
    }
             
    public List<Autor> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Autor> lista = session.createQuery("from Autor a "
                + " where a.nazivAutora like :uvjet "
                + " order by a.nazivAutora ", Autor.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivAutora(), e2.getNazivAutora()));
        
        return lista;
    }
    
    public Autor readBySifra(int id){
        return session.get(Autor.class, id);
    }
    
    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaDrzava();
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
    
    private void kontrolaDrzava() throws SimpleException {
        if(getEntitet().getDrzava() == null || getEntitet().getDrzava().getId().equals(0)){
            throw new SimpleException("Odabir države obavezan");
        }
    }
}
