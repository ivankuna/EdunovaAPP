package obrada;

import model.Knjiga;
import model.Stanje;

import java.util.ArrayList;
import java.util.List;

public class ObradaStanje {
    private List<Stanje> stanjeList;
    private Izbornik izbornik;

    public ObradaStanje(Izbornik izbornik) {
        this.izbornik = izbornik;
    }
    public ObradaStanje() {
        stanjeList = new ArrayList<>();
        if(Pomocno.dev) {
            testniPodaci();
        }
    }
    private void testniPodaci() {

    }
    private void createStanje() {

    }
    private void pregledStanja() {
        for (int i = 0; i < stanjeList.size() - 1; i++) {
            System.out.println(stanjeList.get(i).getNaslovKnjige() + " " + stanjeList.get(i).getNazivAutora() + " " + stanjeList.get(i).getUlaz() + " " + stanjeList.get(i).getIzlaz()
                    + " " + stanjeList.get(i).getRezervirano() + " " + stanjeList.get(i).getStanje() + " " + stanjeList.get(i).getRaspolozivo());
        }
    }
}
