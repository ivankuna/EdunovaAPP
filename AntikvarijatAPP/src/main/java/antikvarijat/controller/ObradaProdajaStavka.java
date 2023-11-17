package antikvarijat.controller;

import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.util.SimpleException;
import java.math.BigDecimal;
import java.util.List;

public class ObradaProdajaStavka extends Obrada<ProdajaStavka> {

    private ObradaKnjiga obradaKnjiga;
    
    @Override     
    public List<ProdajaStavka> read() {
        return session.createQuery("from ProdajaStavka", ProdajaStavka.class).list();
    }

    public List<ProdajaStavka> read(ProdajaZaglavlje prodajaZaglavlje) {
        return session.createQuery("from ProdajaStavka where prodajaZaglavlje = :zaglavlje", ProdajaStavka.class)
                .setParameter("zaglavlje", prodajaZaglavlje)
                .list();
    }

    public ProdajaStavka readBySifra(int id) {
        return session.get(ProdajaStavka.class, id);
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

    private void kontrolaZaglavlje() throws SimpleException {
        if (entitet.getProdajaZaglavlje() == null) {
            throw new SimpleException("Zaglavlje prodaje mora biti definirano");
        }
    }

    private void kontrolaKnjiga() throws SimpleException {
        if (entitet.getKnjiga() == null) {
            throw new SimpleException("Knjiga mora biti definirana");
        }
    }

    private void kontrolaKolicina() throws SimpleException {
        obradaKnjiga = new ObradaKnjiga();
        if (entitet.getKolicina() <= 0 || entitet.getKolicina() == null) {
            throw new SimpleException("Neispravan unos količine");
        }
        if (entitet.getKolicina() > obradaKnjiga.kontrolaRaspolozivosti(entitet.getKnjiga(), entitet.getProdajaZaglavlje().getDatumProdaje())) {
            throw new SimpleException("Unešena količina je veća od raspoloživog stanja");
        }
    }

    private void kontrolaCijena() throws SimpleException {                
        if (entitet.getCijenaProdaje() == null) {
            throw new SimpleException("Cijena mora biti definirana");
        }
        if (entitet.getCijenaProdaje().equals(BigDecimal.ZERO)) {
            throw new SimpleException("Neispravan unos cijene prodaje");
        }
    }        
}
