package antikvarijat.controller;

import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.util.SimpleException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ObradaOtkupZaglavlje extends Obrada<OtkupZaglavlje> {

    @Override
    public List<OtkupZaglavlje> read() {
        return session.createQuery("from OtkupZaglavlje", OtkupZaglavlje.class).list();
    }
    
    public List<OtkupZaglavlje> read(int searchNumber) {
        List<OtkupZaglavlje> OtkupZaglavljeList = new ArrayList<>();

        String queryString = "from OtkupZaglavlje oz where CAST(oz.id AS string) like :searchNumber";

        OtkupZaglavljeList = session.createQuery(queryString, OtkupZaglavlje.class)
                .setParameter("searchNumber", "%" + searchNumber + "%")
                .list();

        return OtkupZaglavljeList;
    }

    public OtkupZaglavlje readBySifra(int id) {
        return session.get(OtkupZaglavlje.class, id);
    }

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaOperater(); 
        kontrolaDatumVrijeme();               
        kontrolaPartner();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        // Brisanje zaglavlja otkupa je onemogućeno
    }

    public void kontrolaOperater() throws SimpleException {
        if (entitet.getOperater() == null) {
            throw new SimpleException("Operater mora biti definiran");
        }
    }
    
    private void kontrolaDatumVrijeme() throws SimpleException {
        if (entitet.getDatumOtkupa() == null) {
            throw new SimpleException("Datum i vrijeme otkupa moraju biti definirani");
        }   
    }

    private void kontrolaPartner() throws SimpleException {        
        if (entitet.getPartner() == null || getEntitet().getPartner().getId().equals(0)) {
            throw new SimpleException("Partner mora biti definiran");
        }
    }
}
