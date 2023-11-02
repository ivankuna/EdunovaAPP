package antikvarijat.controller;

import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import java.util.ArrayList;
import java.util.List;

public class ObradaRezervacija extends Obrada<Rezervacija> {

    @Override
    public List<Rezervacija> read() {
        return session.createQuery("from Rezervacija", Rezervacija.class).list();
    }

    public List<Rezervacija> read(int searchNumber) {
        List<Rezervacija> RezervacijaList = new ArrayList<>();

        String queryString = "from Rezervacija pz where CAST(pz.id AS string) like :searchNumber";

        RezervacijaList = session.createQuery(queryString, Rezervacija.class)
                .setParameter("searchNumber", "%" + searchNumber + "%")
                .list();

        return RezervacijaList;
    }

    public Rezervacija readBySifra(int id) {
        return session.get(Rezervacija.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaOperater();
        kontrolaKnjiga();        
        kontrolaPartner();
        kontrolaStanje();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (entitet.getStanje().equals("Aktivno")) {
            throw new SimpleException("Nije moguće obrisati aktivnu rezervaciju");
        }
    }

    private void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }

    private void kontrolaPartner() throws SimpleException {
        if (entitet.getPartner() == null || getEntitet().getPartner().getId().equals(0)) {
            throw new SimpleException("Partner mora biti definiran");
        }
    }
    
    private void kontrolaStanje() throws SimpleException {
        if (entitet.getStanje() == null) {
            throw new SimpleException("Stanje rezervacije mora biti definirano");
        }
        if (entitet.getStanje().isEmpty() || entitet.getStanje().equals("Odaberi stanje rezervacije")) {
            throw new SimpleException("Stanje rezervacije ne smije ostati prazno");
        }
    }
}
