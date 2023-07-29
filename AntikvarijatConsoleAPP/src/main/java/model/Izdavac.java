package model;

public class Izdavac extends Entitet {
    private String nazivIzdavaca;
    private Grad grad;

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
    @Override
    public String toString() {
        return nazivIzdavaca;
    }
}
