package antikvarijat.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

public class OibGenerator {

    public static String getOib() {
        try {            
            URI uri = new URI("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            uri.toURL().openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();            
            Document d = Jsoup.parse(sb.toString());
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();

            //System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
