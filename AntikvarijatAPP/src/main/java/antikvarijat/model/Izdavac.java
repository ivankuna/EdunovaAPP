package antikvarijat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Izdavac extends Entitet {
    
    private String nazivIzdavaca;
    
    @ManyToOne
    private Grad grad;
    
    @OneToMany(mappedBy = "izdavac")
    private List<Knjiga> knjige = new ArrayList<>();

    public Izdavac(int id, String nazivIzdavaca, Grad grad) {
        super(id);
        this.nazivIzdavaca = nazivIzdavaca;
        this.grad = grad;
    }
    
    public Izdavac() {
        
    }

    public String getNazivIzdavaca() {
        return nazivIzdavaca;
    }

    public void setNazivIzdavaca(String nazivIzdavaca) {
        this.nazivIzdavaca = nazivIzdavaca;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }    

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }    

    @Override
    public String toString() {
        return nazivIzdavaca;
    }        
}
