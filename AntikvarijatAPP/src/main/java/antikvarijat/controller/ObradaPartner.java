package antikvarijat.controller;

import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.model.Partner;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.model.Rezervacija;
import antikvarijat.util.SimpleException;
import antikvarijat.util.Tools;
import java.util.List;

public class ObradaPartner extends Obrada<Partner> {

    @Override
    public List<Partner> read() {
        return session.createQuery("from Partner", Partner.class).list();
    }
    
    public Partner readBySifra(int id){
        return session.get(Partner.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaOib();
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

    private void kontrolaOib() throws SimpleException {
        if(!Tools.isValjanOIB(entitet.getOib())){
           throw new SimpleException("OIB nije valjan");
       }
    }
}
