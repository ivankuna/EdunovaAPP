package antikvarijat.controller;

import antikvarijat.model.Knjiga;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import com.mysql.cj.util.SaslPrep;
import com.sun.jdi.IntegerType;
import com.sun.jdi.LongType;
import java.math.BigDecimal;
import java.text.Collator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.query.Query;

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
        kontrolaDimenzije();
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
        if (getEntitet().getIzdavac() == null || getEntitet().getIzdavac().getId().equals(0)) {
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
        if (entitet.getVrstaUveza() == null || entitet.getVrstaUveza().equals(Tools.VRSTA_UVEZA_TEMP)) {
            throw new SimpleException("Vrsta uveza mora biti definirana");
        }
        if (entitet.getVrstaUveza().isEmpty()) {
            throw new SimpleException("Vrsta uveza ne smije ostati prazna");
        }
    }

    private void kontrolaDimenzije() throws SimpleException {
        if (entitet.getDimenzije().equals(Tools.DIMENZIJE_TEMP) || entitet.getDimenzije().isEmpty()) {
            entitet.setDimenzije("");
        }
    }

    private void kontrolaCijena() throws SimpleException {
        if (entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0) {
            throw new SimpleException("Neispravan unos cijene");
        } else if (entitet.getCijena() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        }
    }

    public int dohvatiUlazZaKnjigu(Knjiga knjiga, Date datumUnosa) {
        Long ulaz = (Long) session.createSelectionQuery("SELECT COALESCE(SUM(os.kolicina), 0) FROM OtkupStavka os WHERE os.knjiga = :knjiga "
                + " AND os.otkupZaglavlje.datumOtkupa <= :datumunosa")
                .setParameter("knjiga", knjiga)
                .setParameter("datumunosa", datumUnosa)
                .uniqueResult();
        return ulaz.intValue();
    }

    public int dohvatiIzlazZaKnjigu(Knjiga knjiga, Date datumUnosa) {
        Long izlaz = (Long) session.createSelectionQuery("SELECT COALESCE(SUM(ps.kolicina), 0) FROM ProdajaStavka ps WHERE ps.knjiga = :knjiga "
                + " AND ps.prodajaZaglavlje.datumProdaje <= :datumunosa")
                .setParameter("knjiga", knjiga)
                .setParameter("datumunosa", datumUnosa)
                .uniqueResult();
        return izlaz.intValue();
    }

    public int dohvatiBrojRezervacijaZaKnjigu(Knjiga knjiga, Date datumUnosa) {
        Long brojRezervacija = (Long) session.createSelectionQuery("SELECT COUNT(*) FROM Rezervacija r WHERE r.knjiga = :knjiga AND r.stanje = 'Aktivno' "
                + " AND datumRezervacije <= : datumunosa")
                .setParameter("knjiga", knjiga)
                .setParameter("datumunosa", datumUnosa)
                .uniqueResult();
        return brojRezervacija.intValue();
    }

    public int kontrolaRaspolozivosti(Knjiga knjiga, Date datumUnosa) throws SimpleException {
        int ulaz = dohvatiUlazZaKnjigu(knjiga, datumUnosa);
        int izlaz = dohvatiIzlazZaKnjigu(knjiga, datumUnosa);
        int rezervacija = dohvatiBrojRezervacijaZaKnjigu(knjiga, datumUnosa);
        int naStanju = ulaz - izlaz;
        return naStanju - rezervacija;
    }

    public List<Object[]> dohvatiPodatkeZaKnjigu(int knjigaId) {
        List<Object[]> rezultati = (List<Object[]>) session.createSelectionQuery(
                "SELECT datum, id, ulaz, izlaz, rezervacija "
                + "FROM ("
                + "   SELECT "
                + "       otkupStavka.otkupZaglavlje.datumOtkupa AS datum, "
                + "       otkupStavka.otkupZaglavlje.id AS id, "
                + "       otkupStavka.knjiga.id AS knjigaId, "
                + "       otkupStavka.kolicina AS ulaz, "
                + "       0 AS izlaz, "
                + "       0 AS rezervacija "
                + "   FROM OtkupStavka otkupStavka "
                + "   WHERE otkupStavka.knjiga.id = :knjigaId "
                + "   UNION ALL "
                + "   SELECT "
                + "       prodajaStavka.prodajaZaglavlje.datumProdaje AS datum, "
                + "       prodajaStavka.prodajaZaglavlje.id AS id, "
                + "       prodajaStavka.knjiga.id AS knjigaId, "
                + "       0 AS ulaz, "
                + "       prodajaStavka.kolicina AS izlaz, "
                + "       0 AS rezervacija "
                + "   FROM ProdajaStavka prodajaStavka "
                + "   WHERE prodajaStavka.knjiga.id = :knjigaId "
                + "   UNION ALL "
                + "   SELECT "
                + "       rezervacija.datumRezervacije AS datum, "
                + "       rezervacija.id AS id, "
                + "       rezervacija.knjiga.id AS knjigaId, "
                + "       0 AS ulaz, "
                + "       0 AS izlaz, "
                + "       1 AS rezervacija "
                + "   FROM Rezervacija rezervacija "
                + "   WHERE rezervacija.knjiga.id = :knjigaId AND rezervacija.stanje = 'Aktivno'"
                + ") AS tablica "
                + "ORDER BY datum"
        )
                .setParameter("knjigaId", knjigaId)
                .list();
        return rezultati;
    }

    public List<Object[]> dohvatiPodatkeZaSveKnjige() {
        List<Object[]> rezultati = (List<Object[]>) session.createSelectionQuery(
                "SELECT k.id, k.nazivKnjige, COALESCE(SUM(o.kolicina), 0) AS ulaz, COALESCE(SUM(p.kolicina), 0) AS izlaz, COALESCE(COUNT(r), 0) AS rezervirano, "
                + "COALESCE(SUM(o.kolicina), 0) - COALESCE(SUM(p.kolicina), 0) AS stanje, "
                + "COALESCE(SUM(o.kolicina), 0) - COALESCE(SUM(p.kolicina), 0) - COALESCE(COUNT(r), 0) AS raspolozivo "
                + "FROM Knjiga k "
                + "LEFT JOIN OtkupStavka o ON o.knjiga = k "
                + "LEFT JOIN ProdajaStavka p ON p.knjiga = k "
                + "LEFT JOIN Rezervacija r ON r.knjiga = k AND r.stanje = 'Aktivno' "
                + "GROUP BY k.id, k.nazivKnjige"
        ).list();
        return rezultati;
    }
}
