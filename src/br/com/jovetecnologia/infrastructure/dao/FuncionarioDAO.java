package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

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
}
