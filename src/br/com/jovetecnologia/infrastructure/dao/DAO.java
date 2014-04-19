package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class DAO<T> implements Serializable {

	private static final long serialVersionUID = 2887068895559328314L;

	protected Session session;
	private Class<T> classse;

	public DAO(Class<T> classe) {
		this.classse = classe;
	}

	/**
	 * Cadastra o objeto na base de dados.
	 * @author Joaquim Neto
	 * @param objeto type genérico
	 */
	public void cadastar(T objeto) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(objeto);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
	}

	/**
	 * Altera o objeto na base de dados
	 * @author Joaquim Neto
	 * @param objeto type genérico
	 */
	public void alterar(T objeto) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.clear();
			session.update(objeto);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
	}

	/**
	 * Deleta o objeto da base
	 * @author Joaquim Neto
	 * @param objeto type genérico
	 */
	public void deletar(T objeto) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.delete(objeto);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
	}
	
	/**
	 * Pesquisa todos os objetos persistidos na base
	 * @author Joaquim Neto
	 * @return Lista type genérico persistidos na base
	 */
	@SuppressWarnings("rawtypes")
	public List listarTodos() {
		List<?> lista = null;
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			lista = session.createCriteria(classse).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
		
		return lista;
	}
	
	/**
	 * Pesquisa em ordem Decrescente todos os objetos persistidos na base 
	 * @author Joaquim Neto
	 * @return Lista type genérico persistidos ordem DESC
	 */
	@SuppressWarnings("rawtypes")
	public List listarTodosDesc() {
		List<?> lista = null;
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			lista = session.createCriteria(classse).addOrder(Order.desc("dataCadastro")).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
		
		return lista;
	}

}
