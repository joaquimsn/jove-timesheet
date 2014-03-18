package br.com.jovetecnologia.infrastructure.dao;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class TarefaDAO extends DAO<Tarefa>{
	
	private static final long serialVersionUID = 1598914505310324743L;

	public TarefaDAO() {
		super(Tarefa.class);
	}
	
	/**
	 * Responsavel por ativar ou inativar a tarefa
	 * @author Joaquim Neto
	 * @param tarefa Objeto que será atualizado	
	 */
	public void ativarOuInativar(Tarefa tarefa) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Tarefa t SET t.ativo = :ativo");
		hql.append(" WHERE t = :tarefa");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", tarefa.isAtivo());
			query.setParameter("tarefa", tarefa);
			
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
