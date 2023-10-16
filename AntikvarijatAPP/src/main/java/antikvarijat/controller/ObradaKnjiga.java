package antikvarijat.controller;

import antikvarijat.model.Knjiga;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import java.math.BigDecimal;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaKnjiga extends Obrada<Knjiga> {

    @Override
    public List<Knjiga> read() {
        return session.createQuery("from Knjiga", Knjiga.class).list();
    }

    public List<Knjiga> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Knjiga> lista = session.createQuery("FROM Knjiga k "
                + "JOIN k.autor a "
                + "WHERE k.nazivKnjige LIKE :uvjet "
                + "OR a.nazivAutora LIKE :uvjet "
                + "ORDER BY k.nazivKnjige", Knjiga.class)
                .setParameter("uvjet", uvjet).list();

        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivKnjige(), e2.getNazivKnjige()));

        return lista;
    }
        
    public Knjiga readBySifra(int id) {
        return session.get(Knjiga.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaslovKnjige();
        kontrolaAutor();
        kontrolaIzdavac();
        kontrolaGodinaIzdanja();
        kontrolaJezik();
        kontrolaBrojStranica();        
        kontrolaVrstaUveza();
        kontrolaCijena();        
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (!entitet.getRezervacije().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati knjigu sa unešenim rezervacijama (");
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
        if (!entitet.getProdaje().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati knjigu sa unešenim prodajama (");
            for (ProdajaStavka ps : entitet.getProdaje()) {
                brojacZareza++;
                sb.append("ID: ").append(ps.getId());
                if (brojacZareza < entitet.getProdaje().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
        if (!entitet.getOtkupi().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati knjigu sa unešenim otkupima (");
            for (OtkupStavka os : entitet.getOtkupi()) {
                brojacZareza++;
                sb.append("ID: ").append(os.getId());
                if (brojacZareza < entitet.getOtkupi().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
    }

    private void kontrolaNaslovKnjige() throws SimpleException {
        if (entitet.getNazivKnjige() == null) {
            throw new SimpleException("Naslov knjige mora biti definiran");
        }
        if (entitet.getNazivKnjige().isEmpty()) {
            throw new SimpleException("Naslov knjige ne smije ostati prazan");
        }
    }

    private void kontrolaAutor() throws SimpleException {
        if (entitet.getAutor() == null) {
            throw new SimpleException("Autor mora biti definiran");
        }
    }
    
    private void kontrolaIzdavac() throws SimpleException {
        if(getEntitet().getIzdavac() == null || getEntitet().getIzdavac().getId().equals(0)){
            throw new SimpleException("Odabir izdavača obavezan");
        }
    }
    
    private void kontrolaGodinaIzdanja() throws SimpleException {
        if (entitet.getGodinaIzdanja() <= 0) {
            throw new SimpleException("Neispravan unos godine izdanja");
        } else if (entitet.getGodinaIzdanja() == null) {
            throw new SimpleException("Godina izdanja mora biti definirana");
        }
    }

    private void kontrolaJezik() throws SimpleException {
        if (entitet.getJezik() == null) {
            throw new SimpleException("Jezik mora biti definiran");
        }
        if (entitet.getJezik().isEmpty()) {
            throw new SimpleException("Jezik ne smije ostati prazan");
        }
    }
       
    private void kontrolaBrojStranica() throws SimpleException {
        if (entitet.getBrojStranica() <= 0) {
            throw new SimpleException("Neispravan unos broja stranica");
        } else if (entitet.getBrojStranica() == null) {
            throw new SimpleException("Broj stranica mora biti definiran");
        }
    }

    private void kontrolaVrstaUveza() throws SimpleException {        
        if (entitet.getVrstaUveza() == null) {
            throw new SimpleException("Vrsta uveza mora biti definirana");
        }
        if (entitet.getVrstaUveza().isEmpty()) {
            throw new SimpleException("Vrsta uveza ne smije ostati prazna");
        }
    }
    
    private void kontrolaCijena() throws SimpleException {
        if (entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0) {
            throw new SimpleException("Neispravan unos cijene");
        } else if (entitet.getCijena() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        }
    }   
}
