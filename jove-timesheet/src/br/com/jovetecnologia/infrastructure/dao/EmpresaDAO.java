package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class EmpresaDAO extends DAO<Empresa> implements Serializable {

	private static final long serialVersionUID = 642507707618912925L;
	
	public EmpresaDAO() {
		super(Empresa.class);
	}
	
	/**
	 * Responsavel por ativar ou inativar a empresa
	 * @author Joaquim Neto
	 * @param empresa Objeto que será atualizado	
	 */
	public void ativarOuInativar(Empresa empresa) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Empresa e SET e.ativo = :ativo");
		hql.append(" WHERE e = :empresa");

		try {
			Query query = session.createQuery(hql.toString());
			
			query.setParameter("ativo", empresa.isAtivo());
			query.setParameter("empresa", empresa);
			
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
