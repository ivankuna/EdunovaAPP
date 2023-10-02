package antikvarijat.controller;

import antikvarijat.model.Operater;
import antikvarijat.util.SimpleException;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;

public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
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
