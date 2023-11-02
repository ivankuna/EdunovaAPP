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
import antikvarijat.model.NacinPlacanja;
import antikvarijat.model.Rezervacija;
import antikvarijat.model.importpodataka.DrzavaGson;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class TestniPodaci {

    private static final int BROJ_DRZAVA = 20;
    private static final int BROJ_AUTORA = 100;
    private static final int BROJ_IZDAVACA = 15;
    private static final int BROJ_OPERATERA = 5;
    private static final int BROJ_PARTNERA = 15;
    private static final int BROJ_KNJIGA = 1000;
    private static final int BROJ_PRODAJA = 1500;
    private static final int BROJ_OTKUPA = 1350;
    private static final int BROJ_NACINA_PLACANJA = 4;
    private static final int BROJ_REZERVACIJA = 1000;   

    private Faker faker;
    private Session session;
    private List<Drzava> drzave;
    private List<Grad> gradovi;
    private List<Autor> autori;
    private List<Izdavac> izdavaci;
    private List<Operater> operateri;
    private List<Partner> partneri;
    private List<Knjiga> knjige;
    private List<NacinPlacanja> naciniPlacanja;
    private List<ProdajaZaglavlje> prodaje;
    private List<ProdajaStavka> prodajaStavke;
    private List<OtkupZaglavlje> otkupi;
    private List<OtkupStavka> otkupStavke;
    private List<Rezervacija> rezervacije;

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
        naciniPlacanja = new ArrayList<>();
        prodaje = new ArrayList<>();
        prodajaStavke = new ArrayList<>();
        otkupi = new ArrayList<>();
        otkupStavke = new ArrayList<>();
        rezervacije = new ArrayList<>();
        session.getTransaction().begin();
        kreirajDrzaveGradove();
        kreirajAutore();
        kreirajIzdavace();
        kreirajOperatere();
        kreirajPartnere();
        kreirajKnjige();
        kreirajOtkupe();
        kreirajNacinePlacanja();
        kreirajProdaje();
        kreirajRezervacije();
        session.getTransaction().commit();
    }

    private void kreirajDrzave() {
        Drzava d;

        for (int i = 0; i < BROJ_DRZAVA; i++) {
            d = new Drzava();

            d.setNazivDrzave(faker.country().name());

            session.persist(d);
            drzave.add(d);
        }
    }

    private void kreirajDrzaveGradove() {
        Type tip = new TypeToken<List<DrzavaGson>>() {
        }.getType();

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void kreirajAutore() {
        Autor a;

        for (int i = 0; i < BROJ_AUTORA; i++) {
            a = new Autor();
            a.setNazivAutora(faker.name().firstName() + " " + faker.name().lastName());
            a.setDrzava(drzave.get(faker.number().numberBetween(0, drzave.size())));

            session.persist(a);
            autori.add(a);
        }
    }

    private void kreirajIzdavace() {
        Izdavac iz;

        for (int i = 0; i < BROJ_IZDAVACA; i++) {
            iz = new Izdavac();
            iz.setNazivIzdavaca(faker.company().name());
            iz.setGrad(gradovi.get(faker.number().numberBetween(0, gradovi.size())));

            session.persist(iz);
            izdavaci.add(iz);
        }
    }

    private void kreirajOperatere() {
        Operater o;

        Argon2 argon2 = Argon2Factory.create();

        for (int i = 0; i < BROJ_OPERATERA; i++) {
            o = new Operater();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            o.setEmail((o.getIme() + o.getPrezime()).trim().toLowerCase() + "@" + faker.job().field().strip().toLowerCase() + ".com");
            String hash = argon2.hash(10, 65536, 1, String.valueOf(faker.number().numberBetween(1000, 9999)).toCharArray());
            o.setLozinka(hash);            
            o.setOib(OibGenerator.getOib());
            o.setUloga("operater");

            session.persist(o);
            operateri.add(o);
        }
    }

    private void kreirajPartnere() {
        Partner p;

        for (int i = 0; i < BROJ_PARTNERA; i++) {
            p = new Partner();
            String nazivPartnera = (i % 2 == 0) ? faker.company().name() : faker.name().firstName() + " " + faker.name().lastName();
            p.setNazivPartnera(nazivPartnera);
            p.setEmail(nazivPartnera.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "") + "@" + faker.job().field().strip().toLowerCase() + ".com");
            p.setTelefon(String.valueOf(faker.phoneNumber().phoneNumber()));
            p.setOib(OibGenerator.getOib());
            p.setUlicaBroj(faker.funnyName().name().trim() + " street " + String.valueOf(faker.number().numberBetween(1, 120)));
            p.setGrad(gradovi.get(faker.number().numberBetween(0, gradovi.size())));

            session.persist(p);
            partneri.add(p);
        }
    }

    private void kreirajKnjige() {
        Knjiga k;
        String[] vrsteUveza = {"Tvrdi uvez", "Meki uvez", "Polutvrdi uvez", "Spiralni uvez", "Plastični uvez"};
        String[] dimenzije = {"13,97 x 21,59 cm", "15,24 x 22,86 cm", "12,7 x 20,32 cm"};

        for (int i = 0; i < BROJ_KNJIGA; i++) {
            k = new Knjiga();
            k.setNazivKnjige(faker.book().title());
            k.setAutor(autori.get(faker.number().numberBetween(0, autori.size())));
            k.setGodinaIzdanja(faker.number().numberBetween(1778, 2023));
            k.setIzdavac(izdavaci.get(faker.number().numberBetween(0, izdavaci.size())));
            k.setJezik(faker.country().name());
            k.setBrojStranica(faker.number().numberBetween(80, 1015));
            k.setVrstaUveza(vrsteUveza[faker.number().numberBetween(0, vrsteUveza.length)]);
            k.setDimenzije(dimenzije[faker.number().numberBetween(0, dimenzije.length)]);
            k.setCijena(new BigDecimal(faker.number().randomDouble(2, 9, 50)));

            session.persist(k);
            knjige.add(k);
        }
    }

    private void kreirajOtkupe() {
        OtkupZaglavlje oz;
        OtkupStavka os;

        for (int i = 0; i < BROJ_OTKUPA; i++) {
            oz = new OtkupZaglavlje();
            oz.setDatumOtkupa(faker.date().birthday(1, 10));
            oz.setPartner(partneri.get(faker.number().numberBetween(0, partneri.size())));
            oz.setOperater(operateri.get(faker.number().numberBetween(0, operateri.size())));
            session.persist(oz);
            for (int j = 0; j < faker.number().numberBetween(0, 4); j++) {
                os = new OtkupStavka();
                os.setOtkupZaglavlje(oz);
                os.setKnjiga(knjige.get(faker.number().numberBetween(0, knjige.size())));
                os.setKolicina(faker.number().numberBetween(1, 10));
                os.setCijenaOtkupaArtikla(new BigDecimal(faker.number().randomDouble(2, 9, 50)));
                os.setCijenaOtkupa(os.getCijenaOtkupaArtikla().multiply(new BigDecimal(os.getKolicina())));

                session.persist(os);
                otkupStavke.add(os);
            }
            otkupi.add(oz);
        }
    }

    private void kreirajNacinePlacanja() {
        NacinPlacanja n;

        for (int i = 0; i < BROJ_NACINA_PLACANJA; i++) {
            n = new NacinPlacanja();
            String[] naziviNacinaPlacanja = {"Gotovina", "Kartica", "Ček", "Ostalo"};
            String[] oznakeNacinaPlacanja = {"G", "K", "C", "O"};

            n.setNazivNacinaPlacanja(naziviNacinaPlacanja[i]);
            n.setOznakaNacinaPlacanja(oznakeNacinaPlacanja[i]);

            session.persist(n);
            naciniPlacanja.add(n);
        }
    }

    private void kreirajProdaje() {
        ProdajaZaglavlje pz;
        ProdajaStavka ps;

        for (int i = 0; i < BROJ_PRODAJA; i++) {
            pz = new ProdajaZaglavlje();
            pz.setDatumProdaje(faker.date().birthday(1, 10));
            pz.setNacinPlacanja(naciniPlacanja.get(faker.number().numberBetween(0, naciniPlacanja.size())));
            pz.setOperater(operateri.get(faker.number().numberBetween(0, operateri.size())));
            pz.setPartner(partneri.get(faker.number().numberBetween(0, partneri.size())));
            session.persist(pz);
            for (int j = 0; j < faker.number().numberBetween(0, 4); j++) {
                ps = new ProdajaStavka();
                ps.setProdajaZaglavlje(pz);
                ps.setKnjiga(knjige.get(faker.number().numberBetween(0, knjige.size())));
                ps.setKolicina(faker.number().numberBetween(1, 10));
                ps.setCijenaProdaje(ps.getKnjiga().getCijena().multiply(new BigDecimal(ps.getKolicina())));

                session.persist(ps);
                prodajaStavke.add(ps);
            }
            prodaje.add(pz);
        }
    }
    
    private void kreirajRezervacije() {
        Rezervacija r;
        
        String[] stanja = {"Aktivno", "Otkazano", "Izvršeno"};
        
        for (int i = 0; i < BROJ_REZERVACIJA; i++) {
            r = new Rezervacija();
            r.setKnjiga(knjige.get(faker.number().numberBetween(0, knjige.size())));
            r.setOperater(operateri.get(faker.number().numberBetween(0, operateri.size())));
            r.setPartner(partneri.get(faker.number().numberBetween(0, partneri.size())));
            r.setStanje(stanja[faker.number().numberBetween(0, stanja.length)]);
            
            session.persist(r);
            rezervacije.add(r);
        }
    }
}
