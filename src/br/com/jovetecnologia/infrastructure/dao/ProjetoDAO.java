package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class ProjetoDAO extends DAO<Projeto> implements Serializable {
	
	private static final long serialVersionUID = -8721824796532946742L;

	public ProjetoDAO() {
		super(Projeto.class);
	}
	
	/**
	 * Responsavel por ativar ou inativar o projeto
	 * @author Joaquim Neto
	 * @param projeto Objeto que será atualizado	
	 */
	public void ativarOuInativar(Projeto projeto) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Projeto p SET p.ativo = :ativo");
		hql.append(" WHERE p = :projeto");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", projeto.isAtivo());
			query.setParameter("projeto", projeto);
			
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
