package de.hawai.mps.transport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    private static SessionFactory factory;

    public static Session getSession() {
        return factory.getCurrentSession();
    }

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);

        Server server = new Server();
        server.run();
    }

}
