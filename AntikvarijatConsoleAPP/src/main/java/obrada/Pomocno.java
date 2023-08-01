package obrada;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pomocno {
    public static Scanner ulaz;
    public static boolean dev;
    private static final String FORMAT_DATUMA = "dd.MM.yyyy. HH:mm:ss";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATUMA);

    public static int unosRasponBroja(String poruka, String greska, int min, int max) {
        int i;
        while (true) {
            try {
                System.out.print(poruka);
                i = Integer.parseInt(ulaz.nextLine());
                if (i >= min && i <= max) {
                    return i;
                }
                System.out.println(greska);
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
    }
    public static String unosString(String poruka, String greska) {
        String s = "";
        while (true) {
            System.out.print(poruka);
            s = ulaz.nextLine();
            if (s.trim().length() > 0) {
                return s;
            }
            System.out.println(greska);
        }
    }
    public static float unosFloat(String poruka, String greska) {
        while (true) {
            try {
                System.out.print(poruka);
                return Float.parseFloat(ulaz.nextLine());
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
    }
    public static double unosDouble(String poruka, String greska) {
        while (true) {
            try {
                System.out.print(poruka);
                return Double.parseDouble(ulaz.nextLine());
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
    }
    public static int unosInt(String poruka, String greska) {
        while (true) {
            try {
                System.out.print(poruka);
                return Integer.parseInt(ulaz.nextLine());
            } catch (Exception e) {
                System.out.println(greska);
            }
        }
    }
    public static boolean unosBoolean(String poruka) {

        System.out.print(poruka);
        return ulaz.nextLine().trim().toLowerCase().equals("da") ? true : false;

    }
    public static LocalDateTime unosDatum(String poruka) {
        while (true) {
            try {
                System.out.print(poruka);
                return LocalDateTime.parse(ulaz.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Pogrešan unos");
            }
        }
    }
}
