package antikvarijat.controller;

import antikvarijat.model.Operater;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.text.Collator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.validator.routines.EmailValidator;

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
                + " where concat(o.ime, ' ', o.prezime, ' ', o.prezime, ' ', o.ime) like :uvjet "
                + " order by o.prezime ", Operater.class)
                .setParameter("uvjet", uvjet).list();

        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));

        lista.sort((e1, e2) -> spCollator.compare(e1.getPrezime(), e2.getPrezime()));

        return lista;
    }

    public Operater readBySifra(int id) {
        return session.get(Operater.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaEmail();
        kontrolaLozinka();
        kontrolaUloga();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (entitet.getUloga().equals("admin")) {
            throw new SimpleException("Nemoguće obrisati admina");            
        }
        if (!entitet.getOtkupi().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati operatera sa unešenim otkupima (");
            for (OtkupZaglavlje o : entitet.getOtkupi()) {
                brojacZareza++;
                sb.append("ID: ").append(o.getId());
                if (brojacZareza < entitet.getOtkupi().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
        if (!entitet.getProdaje().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati operatera sa unešenim prodajama (");
            for (ProdajaZaglavlje p : entitet.getProdaje()) {
                brojacZareza++;
                sb.append("ID: ").append(p.getId());
                if (brojacZareza < entitet.getProdaje().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
        if (!entitet.getRezervacije().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati operatera sa unešenim rezervacijama (");
            for (Rezervacija r : entitet.getRezervacije()) {
                brojacZareza++;
                sb.append("ID: ").append(r.getId());
                if (brojacZareza < entitet.getRezervacije().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
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

    private void kontrolaIme() throws SimpleException {
        if (entitet.getIme() == null) {
            throw new SimpleException("Ime operatera mora biti definirano");
        }
        if (entitet.getIme().isEmpty()) {
            throw new SimpleException("Ime operatera ne smije ostati prazno");
        }
    }

    private void kontrolaPrezime() throws SimpleException {
        if (entitet.getPrezime() == null) {
            throw new SimpleException("Prezime operatera mora biti definirano");
        }
        if (entitet.getPrezime().isEmpty()) {
            throw new SimpleException("Prezime operatera ne smije ostati prazno");
        }
    }

    private void kontrolaOib() throws SimpleException {
        if (entitet.getOib() == null) {
            throw new SimpleException("OIB mora biti definiran");
        }
        if (entitet.getOib().isEmpty()) {
            throw new SimpleException("OIB ne smije ostati prazan");
        }
        if (!Tools.isValjanOIB(entitet.getOib())) {
            throw new SimpleException("OIB nije valjan");
        }
        List<Operater> operateri = session.createQuery("from Operater o where o.oib =:uvjet "
                + " and o.id!=:id", Operater.class)
                .setParameter("uvjet", entitet.getOib())
                .setParameter("id", entitet.getId() == null ? 0 : entitet.getId())
                .list();

        if (operateri != null && !operateri.isEmpty()) {
            throw new SimpleException("OIB je zauzet");
        }
    }

    private void kontrolaEmail() throws SimpleException {
        if (entitet.getEmail() == null) {
            throw new SimpleException("Email mora biti definiran");
        }
        if (entitet.getEmail().isEmpty()) {
            throw new SimpleException("Email ne smije ostati prazan");
        }
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(entitet.getEmail())) {
            throw new SimpleException("Email nije u dobrom formatu");
        }
        
        List<Operater> operateri = session.createQuery("from Operater o where o.email =:uvjet "
                + " and o.id!=:id", Operater.class)
                .setParameter("uvjet", entitet.getEmail())
                .setParameter("id", entitet.getId() == null ? 0 : entitet.getId())
                .list();

        if (operateri != null && !operateri.isEmpty()) {
            throw new SimpleException("Email je zauzet");
        }
    }

    private void kontrolaLozinka() throws SimpleException {
        if (entitet.getEmail() == null) {
            throw new SimpleException("Email mora biti definiran");
        }
        if (entitet.getEmail().isEmpty()) {
            throw new SimpleException("Email ne smije ostati prazan");
        }
        List<Operater> operateri = session.createQuery("from Operater o where o.lozinka =:uvjet "
                + " and o.id!=:id", Operater.class)
                .setParameter("uvjet", entitet.getLozinka())
                .setParameter("id", entitet.getId() == null ? 0 : entitet.getId())
                .list();

        if (operateri != null && !operateri.isEmpty()) {
            throw new SimpleException("Lozinka je zauzeta");
        }       
    }

    private void kontrolaUloga() throws SimpleException {
        if (entitet.getUloga()== null || entitet.getUloga().equals(Tools.ULOGA_TEMP)) {
            throw new SimpleException("Uloga mora biti definirana");
        }
        if (entitet.getUloga().isEmpty()) {
            throw new SimpleException("Uloga ne smije ostati prazna");
        }
    }
}
