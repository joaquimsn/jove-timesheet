package br.com.jovetecnologia.infrastructure.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConexaoHibernate {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = null;

		try {

			Configuration configuration = new Configuration();

			configuration.configure("br/com/jove/infrastructure/util/hibernate.cfg.xml");

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}

	/**
	 * Fecha a conexão
	 * @author Joaquim Neto
	 * @param session Fecha a sesssão recebida por parâmetro
	 */
	public static void fecharConexao(Session session) {
		try {
			if (session != null && session.isOpen()) {
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}