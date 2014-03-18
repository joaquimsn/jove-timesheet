package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Departamento;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class DepartamentoDAO extends DAO<Departamento> implements Serializable{
	
	private static final long serialVersionUID = -1851332792490521385L;

	public DepartamentoDAO() {
		super(Departamento.class);
	}
	
	/**
	 * Responsavel por ativar ou inativar o departamento
	 * @author Joaquim Neto
	 * @param departamento Objeto que será atualizado	
	 */
	public void ativarOuInativar(Departamento departamento) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Departamento d SET d.ativo = :ativo");
		hql.append(" WHERE d = :departamento");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", departamento.isAtivo());
			query.setParameter("departamento", departamento);
			
			query.executeUpdate();
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
	}
}
