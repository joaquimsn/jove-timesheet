package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Funcionario;
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
	
	/**
	 * Pesquisa os projetos cadastrados na base, que estão relacionados com o funcionário passado como parâmentro
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionário que será usado para consultar os projetos
	 * @return Lista com os projetos que estão relacionado ao funcionario informado
	 */
	@SuppressWarnings("unchecked")
	public List<Projeto> consultarFuncionarioPorProjeto(Funcionario funcionario) {
		List<Projeto> listaProjeto = null;
		
		session = ConexaoHibernate.getSessionFactory().openSession();
		
		StringBuilder hql = new StringBuilder("");
		hql.append("SELECT p FROM Projeto p");
		hql.append(" JOIN p.relProjetoFuncionarios rf WHERE");
		hql.append(" rf.funcionario = :funcionario");

		try {
			Query query = session.createQuery(hql.toString());
			query.setParameter("funcionario", funcionario);
			
			listaProjeto = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}

		return listaProjeto;
	}
}
