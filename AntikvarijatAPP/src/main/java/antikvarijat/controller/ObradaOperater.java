package antikvarijat.controller;

import antikvarijat.model.Operater;
import antikvarijat.model.Partner;
import antikvarijat.util.SimpleException;
import java.util.List;

public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }
    
    public Operater readBySifra(int id){
        return session.get(Operater.class, id);
    } 

    @Override
    protected void kontrolaUnos() throws SimpleException {
        
    }

    @Override
    protected void kontrolaPromjena() throws SimpleException {
        
    }

    @Override
    protected void kontrolaBrisanje() throws SimpleException {
        
    }    
}
