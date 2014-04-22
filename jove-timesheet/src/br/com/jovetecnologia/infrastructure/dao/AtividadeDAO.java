package br.com.jovetecnologia.infrastructure.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class AtividadeDAO extends DAO<Atividade> {

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

	/**
	 * Pesquisa as Atividades cadastrados na base, que estão relacionados com o projeto
	 * passado como parâmentro
	 * @author Joaquim Neto
	 * @param projeto Objeto projeto que será usado para consultar as atividades
	 * @return Lista com as atividades que estão relacionada ao projeto informado
	 */
	@SuppressWarnings("unchecked")
	public List<Atividade> buscarAtividadePorProjeto(Projeto projeto) {
		List<Atividade> listaAtividade = null;

		session = ConexaoHibernate.getSessionFactory().openSession();

		StringBuilder hql = new StringBuilder("");
		hql.append("SELECT a FROM Atividade a");
		hql.append(" JOIN a.relProjetoAtividades ra WHERE");
		hql.append(" ra.projeto = :projeto");

		try {
			Query query = session.createQuery(hql.toString());
			query.setParameter("projeto", projeto);

			listaAtividade = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}

		return listaAtividade;
	}

}
