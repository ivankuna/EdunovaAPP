package antikvarijat.util;

import antikvarijat.controller.ObradaKnjiga;
import java.util.Arrays;
import java.util.List;

public class Test {
    
    private static ObradaKnjiga obradaKnjiga;
    
    public static void test() {
        obradaKnjiga = new ObradaKnjiga();                
        
        List<Object[]> test = obradaKnjiga.dohvatiPodatkeZaKnjigu(1);
        
        for (Object[] t : test) {
            System.out.println(Arrays.toString(t));
        }        
    }    
}
