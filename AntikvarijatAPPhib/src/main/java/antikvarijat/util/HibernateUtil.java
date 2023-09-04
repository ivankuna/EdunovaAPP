package antikvarijat.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static Session session = null;
    
    private HibernateUtil(){
        session = new Configuration().configure().buildSessionFactory().openSession();
    }
    
    public static Session getSession(){
        if(session==null){
            new HibernateUtil();
        }
        return session;
    }  
}
