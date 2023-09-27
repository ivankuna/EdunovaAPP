package antikvarijat.model.importpodataka;

import java.util.List;

public class DrzavaGson {
    
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GradGson> getCities() {
        return cities;
    }

    public void setCities(List<GradGson> cities) {
        this.cities = cities;
    }
    
    private List<GradGson> cities;
}