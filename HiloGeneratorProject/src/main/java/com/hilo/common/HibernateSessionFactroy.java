package com.hilo.common;

import java.util.UUID;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactroy {
	private static ServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static Configuration configuration;
private HibernateSessionFactroy() {
	System.out.println("HibernateSessionFactroy.HibernateSessionFactroy()"+UUID.randomUUID().toString());
}
	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			try {
				/*registry = new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build();
				MetadataSources sources = new MetadataSources(registry);
				Metadata metadata = sources.getMetadataBuilder().build();*/
				//sessionFactory = metadata.getSessionFactoryBuilder().build();
				//hibernate4 bootStraping;
				configuration= new Configuration();
				 configuration.configure("META-INF/hibernate.cfg.xml");
				 ServiceRegistryBuilder builder= new ServiceRegistryBuilder();
				 builder.applySettings(configuration.getProperties());
				registry=builder.buildServiceRegistry();
				sessionFactory=configuration.buildSessionFactory(registry);
				 } catch (Exception e) {
				e.printStackTrace();

			}
		}
		return sessionFactory;
	}

	public static void closeFactroy() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}

}