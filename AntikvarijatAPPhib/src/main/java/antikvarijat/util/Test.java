package antikvarijat.util;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

public class Test {
    
    private static List<String> drzave = new ArrayList<>();    
    private static List<String> gradovi = new ArrayList<>();    
    private static Faker faker = new Faker();
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 20; i++) {
            gradovi.add(faker.country().capital());
        }
        
        for (String s : gradovi) {
            System.out.println(s);
        }
    }        
}
