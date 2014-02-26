package br.com.jovetecnologia.infrastructure.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;
import br.com.jovetecnologia.infrastructure.util.Criptografia;

public class UsuarioDAO {
	
	private Usuario usuario;
	private Session session;
	
	/**
	 * Retorna um objeto usuario se as credenciais passadas estiverem na DB, se não retorna null
	 * @author Joaquim Neto
	 * @param nome String com o login
	 * @param senha String com a senha
	 * @return Um objeto usuario se o login e senha existir.
	 */
	public Usuario validarUsuario(String login, String senha){
		 
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			String hql = "SELECT u FROM Usuario u where u.login = :login AND u.senha = :senha";
			
			Query query = session.createQuery(hql);
			query.setParameter("login", login);
			query.setParameter("senha", Criptografia.criptografar(senha));
			
			usuario = (Usuario) query.uniqueResult();
			
		} catch (HibernateException e) {
			ConexaoHibernate.fecharConexao(session);
			e.printStackTrace();
		}
		
		return usuario;
	}
}
