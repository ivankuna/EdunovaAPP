package antikvarijat.controller;

import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.model.Partner;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ObradaPartner extends Obrada<Partner> {

    @Override
    public List<Partner> read() {
        return session.createQuery("from Partner", Partner.class).list();
    }

    public List<Partner> read(String uvjet) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";

        List<Partner> lista = session.createQuery("from Partner p "
                + " where p.nazivPartnera like :uvjet "
                + " order by p.nazivPartnera ", Partner.class)
                .setParameter("uvjet", uvjet).list();

        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));

        lista.sort((e1, e2) -> spCollator.compare(e1.getNazivPartnera(), e2.getNazivPartnera()));

        return lista;
    }

    public Partner readBySifra(int id) {
        return session.get(Partner.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaEmail();
        kontrolaOib();
        kontrolaTelefon();
        kontrolaGrad();
        kontrolaUlicaBroj();
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
            sb.append("Nemoguće obrisati partnera sa unešenim prodajama (");
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
        if (!entitet.getOtkupi().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati partnera sa unešenim otkupima (");
            for (OtkupZaglavlje oz : entitet.getOtkupi()) {
                brojacZareza++;
                sb.append("ID: ").append(oz.getId());
                if (brojacZareza < entitet.getOtkupi().size()) {
                    sb.append(",");
                }
            }
            sb.append(")");
            throw new SimpleException(sb.toString());
        }
        if (!entitet.getRezervacije().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati partnera sa unešenim rezervacijama (");
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

    private void kontrolaNaziv() throws SimpleException {
        if (entitet.getNazivPartnera() == null) {
            throw new SimpleException("Naziv partnera mora biti definiran");
        }
        if (entitet.getNazivPartnera().isEmpty()) {
            throw new SimpleException("Naziv partnera ne smije ostati prazan");
        }
    }

    private void kontrolaEmail() throws SimpleException {
        if (entitet.getEmail() == null) {
            throw new SimpleException("Email mora biti definiran");
        }
        if (entitet.getEmail().isEmpty()) {
            throw new SimpleException("Email ne smije ostati prazan");
        }
    }

    private void kontrolaOib() throws SimpleException {
        if (!Tools.isValjanOIB(entitet.getOib())) {
            throw new SimpleException("OIB nije valjan");
        }
    }

    private void kontrolaTelefon() throws SimpleException {
        if (entitet.getTelefon().matches(".*\\D.*")) {
            throw new SimpleException("Neispravan unos broja telefona");
        }
    }

    private void kontrolaGrad() throws SimpleException {
        if (entitet.getGrad() == null) {
            throw new SimpleException("Grad mora biti definiran");
        }
    }

    private void kontrolaUlicaBroj() throws SimpleException {
        if (entitet.getUlicaBroj() == null) {
            throw new SimpleException("Ulica i broj moraju biti definirani");
        }
        if (entitet.getUlicaBroj().isEmpty()) {
            throw new SimpleException("Ulica i broj ne smiju ostati prazani");
        }
    }
}
