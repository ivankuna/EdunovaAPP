package antikvarijat.controller;

import antikvarijat.model.Entitet;
import antikvarijat.util.HibernateUtil;
import antikvarijat.util.SimpleException;
import java.util.List;
import org.hibernate.Session;

public abstract class Obrada<T extends Entitet> {
    
    protected T entitet;
    protected Session session;
    public abstract List<T> read();
    protected abstract void kontrolaUnos() throws SimpleException;
    protected abstract void kontrolaPromjena() throws SimpleException;
    protected abstract void kontrolaBrisanje() throws SimpleException;
    
    public Obrada(){
        session = HibernateUtil.getSession();
    }
    
    public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }
    
    public void create() throws SimpleException{
        kontrolaNull();
        entitet.setId(null);
        kontrolaUnos();
        persist();
    }
    
    public void update() throws SimpleException{
        kontrolaNull();
        kontrolaPromjena();
        persist();
    }
    
    public void delete() throws SimpleException{
        kontrolaNull();
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }
    
    private void kontrolaNull() throws SimpleException{
       if(entitet==null){
            throw new SimpleException("Entitet je null");
        }        
    }
    
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    public void refresh(){
        if(entitet!=null){
            session.refresh(entitet);
        }
    }
}
