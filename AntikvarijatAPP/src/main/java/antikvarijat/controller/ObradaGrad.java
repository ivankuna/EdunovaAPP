package antikvarijat.controller;

import antikvarijat.model.Grad;
import antikvarijat.model.Izdavac;
import antikvarijat.model.Partner;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaGrad extends Obrada<Grad>{

    @Override
    public List<Grad> read() {
        return session.createQuery("from Grad", Grad.class).list();
    }
    
    public Grad readBySifra(int id){
        return session.get(Grad.class, id);
    } 
    
    @Override
    protected void kontrolaUnos() throws SimpleException {
        kontrolaNaziv();
        kontrolaPostanskiBroj();
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        if (!entitet.getIzdavaci().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati grad sa unešenim izdavačima (");
            for (Izdavac i : entitet.getIzdavaci()) {    
                brojacZareza++;
                sb.append(i.getNazivIzdavaca());
                if (brojacZareza < entitet.getIzdavaci().size()) {
                    sb.append(",");
                }                
            }
            sb.append(")");                      
            throw new SimpleException(sb.toString());
        }
        if (!entitet.getPartneri().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int brojacZareza = 0;
            sb.append("Nemoguće obrisati grad sa unešenim partnerima (");
            for (Partner p : entitet.getPartneri()) {    
                brojacZareza++;
                sb.append(p.getNazivPartnera());
                if (brojacZareza < entitet.getPartneri().size()) {
                    sb.append(",");
                }                
            }
            sb.append(")");                      
            throw new SimpleException(sb.toString());
        }
    }                

    private void kontrolaNaziv() throws SimpleException {
        if (entitet.getNazivGrada() == null) {
            throw new SimpleException("Naziv grada mora biti definiran");
        }
        if (entitet.getNazivGrada().isEmpty()) {
            throw new SimpleException("Naziv grada ne smije ostati prazan");
        }
    }

    private void kontrolaPostanskiBroj() throws SimpleException {
        if (entitet.getPostanskiBroj() == null) {
            throw new SimpleException("Poštanski broj mora biti definiran");
        }
        if (entitet.getPostanskiBroj().isEmpty()) {
            throw new SimpleException("Poštanski broj ne smije ostati prazan");
        }
    }
}
