package antikvarijat.controller;

import antikvarijat.model.Drzava;
import antikvarijat.model.Grad;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaDrzava extends Obrada<Drzava> {

    @Override
    public List<Drzava> read() {
        return session.createQuery("from Drzava", Drzava.class).list();
    }

    public List<Drzava> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Drzava> lista = session.createQuery("from Drzava d "
                + " where d.nazivDrzave like :uvjet "
                + " order by d.nazivDrzave", Drzava.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivDrzave(), e2.getNazivDrzave()));
        
        return lista;
    }

    public Drzava readBySifra(int id) {
        return session.get(Drzava.class, id);
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
        if (!entitet.getGradovi().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati državu sa unešenim gradovima (");
            for (Grad g : entitet.getGradovi()) {
                brojacZareza++;
                sb.append(g.getNazivGrada());
                if (brojacZareza < entitet.getGradovi().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
    }

    private void kontrolaNaziv() throws SimpleException {
        if (entitet.getNazivDrzave() == null) {
            throw new SimpleException("Naziv države mora biti definiran");
        }
        if (entitet.getNazivDrzave().isEmpty()) {
            throw new SimpleException("Naziv države ne smije ostati prazan");
        }
    }
}
