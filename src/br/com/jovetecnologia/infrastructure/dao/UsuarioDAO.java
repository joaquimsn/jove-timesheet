package br.com.jovetecnologia.infrastructure.dao;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;
import br.com.jovetecnologia.infrastructure.util.Criptografia;

public class UsuarioDAO extends DAO<Usuario> implements Serializable {

	private static final long serialVersionUID = 1402905067052633764L;
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	/**
	 * Retorna um objeto usuario se as credenciais passadas estiverem na DB, se não retorna null
	 * @author Joaquim Neto
	 * @param login String com o login
	 * @param senha String com a senha
	 * @return Objeto usuario
	 */
	public Usuario validarUsuario(String login, String senha){
		
		Usuario usuario = null;
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u where u.login = :login AND u.senha = :senha AND u.ativo = true";
		
		try {	
			Query query = session.createQuery(hql);
			query.setParameter("login", login);
			query.setParameter("senha", Criptografia.criptografar(senha));
			
			usuario = (Usuario) query.uniqueResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
		
		return usuario;
	}
	
	/**
	 * Responsável por pesquisar um usuario persistido pelo utilizando como paramtro o objeto funcionário
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionário que será utilizado para pesquisar o usuário associado a ele
	 * @return Objeto Usuário 
	 */
	public Usuario pesquisarPorFuncionario(Funcionario funcionario) {
		
		Usuario usuario= null;
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u where u.funcionario = :funcionario";
		
		try {	
			Query query = session.createQuery(hql);
			query.setParameter("funcionario", funcionario);
			
			usuario =  (Usuario) query.uniqueResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			ConexaoHibernate.fecharConexao(session);
		}
		
		return usuario;
	}
	
	/**
	 * Responsavel por ativar ou inativar o usuário
	 * @author Joaquim Neto
	 * @param funcionario Parametro que será utilizado para alterar o usuario associado a ele	
	 */
	public void ativarOuInativar(Funcionario funcionario) {
		session = ConexaoHibernate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		StringBuilder hql = new StringBuilder("UPDATE Usuario u SET u.ativo = :ativo");
		hql.append(" WHERE u.funcionario = :funcionario");

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
}
