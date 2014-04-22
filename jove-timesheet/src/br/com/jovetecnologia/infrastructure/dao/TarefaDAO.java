package br.com.jovetecnologia.infrastructure.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class TarefaDAO extends DAO<Tarefa> {

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

	/**
	 * Pesquisa as tarefas cadastrados na base, que estão relacionados com a atividade
	 * passada por parâmentro
	 * @author Joaquim Neto
	 * @param atividade Objeto atividade que será usado para consultar as tarefas
	 * @return Lista com as tarefas que estão relacionadas a atividade informada
	 */
	@SuppressWarnings("unchecked")
	public List<Tarefa> consultarTarefaPorProjeto(Atividade atividade) {
		List<Tarefa> listaTarefa = null;

		session = ConexaoHibernate.getSessionFactory().openSession();

		StringBuilder hql = new StringBuilder("");
		hql.append("SELECT t FROM Tarefa t");
		hql.append(" JOIN t.relAtividadeTarefas rt WHERE");
		hql.append(" rt.atividade = :atividade");

		try {
			Query query = session.createQuery(hql.toString());
			query.setParameter("atividade", atividade);

			listaTarefa = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}

		return listaTarefa;
	}

}
