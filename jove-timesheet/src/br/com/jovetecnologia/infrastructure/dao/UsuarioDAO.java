package br.com.jovetecnologia.infrastructure.dao;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Query;

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
	 * @param nome String com o login
	 * @param senha String com a senha
	 * @return Objeto usuario
	 */
	public Usuario validarUsuario(String login, String senha){
		
		Usuario usuario = null;
		session = ConexaoHibernate.getSessionFactory().openSession();
		String hql = "SELECT u FROM Usuario u where u.login = :login AND u.senha = :senha";
		
		try {	
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
