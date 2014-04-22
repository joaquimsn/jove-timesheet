package br.com.jovetecnologia.infrastructure.connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConexaoHibernate {
	
	private static final SessionFactory currentSessionFactory = buildSessionFactory();
	
	/**
	 * Cria o SessionFactory do Hibernate com a conexão
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("br/com/jovetecnologia/infrastructure/util/hibernate.cfg.xml");
			
			ServiceRegistry registry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			
			return configuration.buildSessionFactory(registry);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Encerra a conexão (Session)
	 * @param currentSession Session
	 */
	public static void fecharConexao(Session currentSession) {
		try {
			if(currentSession != null && currentSession.isOpen()) {
				currentSession.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna a Session Factory atual
	 * @return Session Factory atual
	 */
	public static SessionFactory getSessionFactory() {
		return currentSessionFactory;
	}
}