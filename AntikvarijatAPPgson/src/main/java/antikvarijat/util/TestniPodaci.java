package antikvarijat.util;

import antikvarijat.model.Autor;
import antikvarijat.model.Izdavac;
import antikvarijat.model.Knjiga;
import antikvarijat.model.Operater;
import antikvarijat.model.OtkupStavka;
import antikvarijat.model.OtkupZaglavlje;
import antikvarijat.model.Partner;
import antikvarijat.model.ProdajaStavka;
import antikvarijat.model.ProdajaZaglavlje;
import antikvarijat.model.Drzava;
import antikvarijat.model.Grad;
import antikvarijat.model.importpodataka.DrzavaGson;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class TestniPodaci {

    private static final int BROJ_DRZAVA = 20;    
    private static final int BROJ_AUTORA = 100;
    private static final int BROJ_IZDAVACA = 15;
    private static final int BROJ_OPERATERA = 5;
    private static final int BROJ_PARTNERA = 15;
    private static final int BROJ_KNJIGA = 1000;
    private static final int BROJ_PRODAJA = 1500;
    private static final int BROJ_STAVAKA_PRODAJE = 3500;
    private static final int BROJ_OTKUPA = 1350;
    private static final int BROJ_STAVAKA_OTKUPA = 3200;

    private Faker faker;
    private Session session;
    private List<Drzava> drzave;
    private List<Grad> gradovi;
    private List<Autor> autori;
    private List<Izdavac> izdavaci;
    private List<Operater> operateri;
    private List<Partner> partneri;
    private List<Knjiga> knjige;
    private List<ProdajaZaglavlje> prodaje;
    private List<ProdajaStavka> prodajaStavke;
    private List<OtkupZaglavlje> otkupi;
    private List<OtkupStavka> otkupStavke;
    
    public TestniPodaci() {
        faker = new Faker();
        session = HibernateUtil.getSession();
        drzave = new ArrayList<>();
        gradovi = new ArrayList<>();
        autori = new ArrayList<>();
        izdavaci = new ArrayList<>();
        operateri = new ArrayList<>();
        partneri = new ArrayList<>();
        knjige = new ArrayList<>();
        prodaje = new ArrayList<>();
        prodajaStavke = new ArrayList<>();
        otkupi = new ArrayList<>();
        otkupStavke = new ArrayList<>();        
        session.getTransaction().begin();
        
        kreirajDrzave();
        
        session.getTransaction().commit();
    }

    private void kreirajDrzave() {
        Type tip = new TypeToken<List<DrzavaGson>>() {}.getType();
        
        Drzava d;   
        Grad g;
        
        try {            
            List<DrzavaGson> drzaveTemp = new Gson().fromJson(new FileReader(new File("podaci.json")), tip);
            
            for (int i = 0; i < BROJ_DRZAVA; i++) {
                d = new Drzava();                                
                d.setNazivDrzave(drzaveTemp.get(i).getName());
                session.persist(d);
       
                for (int j = 0; j < faker.number().numberBetween(0, drzaveTemp.get(i).getCities().size()); j++) {
                    g = new Grad();
                    g.setNazivGrada(drzaveTemp.get(i).getCities().get(j).getName());
                    g.setPostanskiBroj(String.valueOf(faker.number().numberBetween(10000, 99999)));
                    g.setDrzava(d);
                    session.persist(g);
  
                    this.gradovi.add(g);
                }
                drzave.add(d);
            }
            System.out.println(drzaveTemp.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
