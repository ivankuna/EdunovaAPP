package antikvarijat;

import antikvarijat.controller.ObradaOperater;
import antikvarijat.model.Operater;
import antikvarijat.util.HibernateUtil;
import antikvarijat.util.TestniPodaci;
import antikvarijat.view.SplashScreen;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Glavna {

    public static void main(String[] args) {
        
        // HibernateUtil.getSession();
        // new TestniPodaci();    
        // lozinka();
        
        new SplashScreen().setVisible(true);
        
    }
    
    private static void lozinka() {
        // factory pattern
        Argon2 argon2 = Argon2Factory.create();

        String hash = argon2.hash(10, 65536, 1, "oper".toCharArray());

        ObradaOperater oo = new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Pero");
        o.setPrezime("perić");
        o.setEmail("oper@edunova.hr");
        o.setUloga("oper");
        o.setOib("81425134722");
        o.setLozinka(hash);

        oo.setEntitet(o);

        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
