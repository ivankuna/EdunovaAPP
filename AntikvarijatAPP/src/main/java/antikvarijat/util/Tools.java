package antikvarijat.util;

import antikvarijat.controller.ObradaOperater;
import antikvarijat.model.Operater;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Tools {

    public static final String NAZIV_APP = "Antikvarijat APP";

    public static final String VRSTA_UVEZA_TEMP = "Odaberite/upišite uvez";

    public static final String DIMENZIJE_TEMP = "Odaberite/upišite dimenzije";

    public static final String ULOGA_TEMP = "Odaberite ulogu";
    
    public static Operater OPERATER;
    
    private static ObradaOperater obradaOperater;

    public static String getOperater() {
        return OPERATER.getIme() + " " + OPERATER.getPrezime() + " (" + OPERATER.getUloga() + ")";
    }
    
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DecimalFormatSymbols DECIMAL_FORMAT_SYMBOLS = new DecimalFormatSymbols(Locale.of("hr", "HR"));
    
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,##0.00", DECIMAL_FORMAT_SYMBOLS);   
    
    public static void appSetUp() {        
        obradaOperater = new ObradaOperater();
        if (!obradaOperater.checkIfAdminExists()) {
            unesiAdmina();
        }
    }
    
    public static void unesiAdmina() {
        Argon2 argon2 = Argon2Factory.create();                

        String hash = argon2.hash(10, 65536, 1, "123".toCharArray());

        ObradaOperater oo = new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Ivan");
        o.setPrezime("Kuna");
        o.setEmail("ikuna@edunova.com");
        o.setUloga("administrator");
        o.setOib("81425134722");
        o.setLozinka(hash);

        oo.setEntitet(o);

        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
           
    public static boolean isValjanOIB(String oib) {
        if (oib == null || oib.length() != 11) {
            return false;
        }
        char[] chars = oib.toCharArray();
        int a = 10;
        for (int i = 0; i < 10; i++) {
            char c = chars[i];
            if (c < '0' || c > '9') {
                return false;
            }
            a = a + (c - '0');
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;
        return (kontrolni == (chars[10] - '0'));
    }
}
