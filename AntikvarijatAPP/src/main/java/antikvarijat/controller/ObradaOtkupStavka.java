package antikvarijat.controller;

import antikvarijat.model.OtkupStavka;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.SimpleException;
import java.math.BigDecimal;
import java.util.List;

public class ObradaOtkupStavka extends Obrada<OtkupStavka> {

    @Override
    public List<OtkupStavka> read() {
        return session.createQuery("from OtkupStavka", OtkupStavka.class).list();
    }

    public List<OtkupStavka> read(OtkupZaglavlje otkupZaglavlje) {
    return session.createQuery("from OtkupStavka where otkupZaglavlje = :zaglavlje", OtkupStavka.class)
            .setParameter("zaglavlje", otkupZaglavlje)
            .list();
}

    public OtkupStavka readBySifra(int id) {
        return session.get(OtkupStavka.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaZaglavlje();
        kontrolaKnjiga();
        kontrolaKolicina();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Operater je slobodan brisati sve stavke
    }

    private void kontrolaKolicina() throws SimpleException {
        if (entitet.getKolicina() < 1 || entitet.getKolicina() == null) {
            throw new SimpleException("Neispravan unos količine");
        }
    }

    private void kontrolaCijena() throws SimpleException {
        if (entitet.getCijenaOtkupaArtikla() == null || entitet.getCijenaOtkupa() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        }
        if (entitet.getCijenaOtkupaArtikla().equals(BigDecimal.ZERO)) {
            throw new SimpleException("Neispravan unos cijene otkupa artikla");
        }
    }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null || getEntitet().getKnjiga().getId().equals(0)) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }

    private void kontrolaZaglavlje() throws SimpleException {
        if (entitet.getOtkupZaglavlje() == null) {
            throw new SimpleException("Zaglavlje otkupa mora biti definirano");
        }
    }
}
