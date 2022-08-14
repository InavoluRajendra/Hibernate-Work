package com.demo.Hibdemo2;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil() {

    }

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getInstnce() {
        if(sessionFactory ==null) {
            Configuration configuration = new Configuration().configure("hibernate.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());


            sessionFactory = configuration.buildSessionFactory(builder.build());

        }

        return sessionFactory;
    }

}
