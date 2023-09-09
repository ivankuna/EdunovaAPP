package antikvarijat.util;

import antikvarijat.model.Autor;
import antikvarijat.model.Drzava;
import antikvarijat.model.Grad;
import antikvarijat.model.Izdavac;
import antikvarijat.model.Knjiga;
import antikvarijat.model.Operater;
import antikvarijat.model.Partner;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;

public class TestniPodaci {
    
    private static final int BROJ_DRZAVA = 15;   
    private static final int BROJ_AUTORA = 100;
    private static final int BROJ_OPERATERA = 5;
    private static final int BROJ_PARTNERA = 50;
    private static final int BROJ_IZDAVACA = 42;
    
    private Faker faker;
    private Session session;
    
    private List<Drzava> drzave;
    private List<Grad> gradovi;
    private List<Autor> autori;
    private List<Knjiga> knjige;
    private List<Operater> operateri;
    private List<Partner> partneri;
    private List<Izdavac> izdavaci;           

    public TestniPodaci() {
        faker = new Faker();
        session = HibernateUtil.getSession();
        kreirajDrzave();
        kreirajGradove();
        session.getTransaction().commit();
    }

    private void kreirajDrzave() {
        Drzava d;       
        
        for(int i = 0; i < BROJ_DRZAVA; i++) {
            d = new Drzava();
            d.setNazivDrzave(faker.country().name());
            
            
            session.persist(d);
            drzave.add(d);
        }
    }

    private void kreirajGradove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
