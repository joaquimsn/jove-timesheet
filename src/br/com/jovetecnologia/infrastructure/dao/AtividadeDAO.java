package br.com.jovetecnologia.infrastructure.dao;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class AtividadeDAO extends DAO<Atividade>{
	
	private static final long serialVersionUID = -4551073075399352135L;

	public AtividadeDAO() {
		super(Atividade.class);
	}
	
	/**
	 * Responsavel por ativar ou inativar o projeto
	 * @author Joaquim Neto
	 * @param atividade Objeto que será atualizado	
	 */
	public void ativarOuInativar(Atividade atividade) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Atividade a SET a.ativo = :ativo");
		hql.append(" WHERE a = :atividade");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", atividade.isAtivo());
			query.setParameter("atividade", atividade);
			
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
