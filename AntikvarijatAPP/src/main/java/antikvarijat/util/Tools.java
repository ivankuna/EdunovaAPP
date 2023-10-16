package antikvarijat.util;

import antikvarijat.model.Operater;
import java.text.SimpleDateFormat;

public class Tools {
    
    public static final String NAZIV_APP = "Antikvarijat APP";     
    
    public static final String VRSTA_UVEZA_TEMP = "Odaberite/upišite vr. uv.";
    
    public static final String DIMENZIJE_TEMP = "Odaberite/upišite dimenzije";
    
    public static Operater OPERATER;
    
    public static String getOperater(){
        return OPERATER.getIme() + " " + OPERATER.getPrezime() + " (" + OPERATER.getUloga() + ")";
    }
    
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
    
    public static boolean isValjanOIB(String oib){
        if(oib==null || oib.length() != 11) {
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
