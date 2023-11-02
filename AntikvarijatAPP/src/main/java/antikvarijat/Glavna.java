package antikvarijat;

import antikvarijat.util.HibernateUtil;
import antikvarijat.util.TestniPodaci;
import antikvarijat.util.Tools;
import antikvarijat.view.SplashScreen;

public class Glavna {        

    public static void main(String[] args) {
        HibernateUtil.getSession();
//        new TestniPodaci();
        Tools.appSetUp();                
        new SplashScreen().setVisible(true);        
    }
}
