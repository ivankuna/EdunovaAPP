package antikvarijat.util;

public class SimpleException extends Exception {
    
    private String poruka;

    public SimpleException(String poruka) {
        super(poruka);
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }       
}
