package factory;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {} // Private constructor to prevent instantiation

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateSessionFactory.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new Configuration().configure().buildSessionFactory();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new ExceptionInInitializerError("SessionFactory creation failed!");
                    }
                }
            }
        }
        return sessionFactory;
    }
}
