package antikvarijat.controller;

import antikvarijat.model.Operater;
import antikvarijat.util.SimpleException;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }
        
    public List<Operater> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Operater> lista = session.createQuery("from Operater o "
                + " where o.korisnickoIme like :uvjet "
                + " order by o.korisnickoIme ", Operater.class)
                .setParameter("uvjet", uvjet).list();
                
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2) -> spCollator.compare(e1.getKorisnickoIme(), e2.getKorisnickoIme()));
        
        return lista;
    }
    
    public Operater readBySifra(int id) {
        return session.get(Operater.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {

    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {

    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {

    }

    public Operater autoriziraj(String email, String lozinka) {
        Operater o;

        try {
            o = session.createQuery(
                    "from Operater o where o.email=:email", Operater.class)
                    .setParameter("email", email).getSingleResult();

            Argon2 argon2 = Argon2Factory.create();

            return argon2.verify(o.getLozinka(), lozinka.toCharArray()) ? o : null;                        
        } catch (Exception e) {
            return null;
        }
    }
}
