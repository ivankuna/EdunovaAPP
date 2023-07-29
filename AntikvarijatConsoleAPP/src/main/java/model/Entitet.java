package model;

public abstract class Entitet {
    private int id;

    public Entitet(int id) {
        super();
        this.id = id;
    }
    public Entitet() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public abstract String toString();
}
