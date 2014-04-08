package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class FuncionarioDAO extends DAO<Funcionario> implements Serializable {

	private static final long serialVersionUID = -6908309583552660049L;

	public FuncionarioDAO() {
		super(Funcionario.class);
	}
	
	/**
	 * Consulta unica do funcionario
	 * @author Joaquim Neto
	 * @param idFuncionario Id que será consultado
	 * @return Se não existir o funcionario retorna null;
	 */
	public Funcionario consultarPorId(int idFuncionario) {
		Funcionario funcionario = null;
		
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario";
		
		try {
			Query query = session.createQuery(hql);
			query.setParameter("idFuncionario", idFuncionario);
			
			funcionario = (Funcionario) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	/**
	 * Retorna uma lista contendo os funcionários que foram cadastrado como supervisor
	 * @author Joaquim Neto
	 * @return List de funcionario supervisor
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarSupervisor() {
		List<Funcionario> listaSupervisor = null;
		
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT f FROM Funcionario f WHERE f.funcionario = null";
		
		try {
			Query query = session.createQuery(hql);
			
			listaSupervisor = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return listaSupervisor;
	}
	
	/**
	 * Responsavel por ativar ou inativar o funcionario
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario que será atualizado	
	 */
	public void ativarOuInativar(Funcionario funcionario) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Funcionario f SET f.ativo = :ativo");
		hql.append(" WHERE f = :funcionario");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", funcionario.isAtivo());
			query.setParameter("funcionario", funcionario);
			
			query.executeUpdate();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
	}
	
	/**
	 * Verifique se o email passado por paramentro já está cadastrado na base
	 * @author Joaquim Neto
	 * @param email Email que será consultado
	 * @return <b>true</b> Se já exitir o email cadastrado na base
	 */
	public boolean consultarEmail(String email) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT f FROM Funcionario f where f.email = :email";
		
		try {	
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			
			if (query.uniqueResult() != null){
				return true;
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
		
		return false;
	}
}
