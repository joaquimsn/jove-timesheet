package br.com.jovetecnologia.infrastructure.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.connection.ConexaoHibernate;

public class UsuarioDAO implements IUsuarioDAO{
	
	private Session session;

	@Override
	public void salvar(Usuario usuario) {
		
		Transaction transaction = null;
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.save(usuario);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				ConexaoHibernate.fecharConexao(session);
			}
		}
		
	}

	@Override
	public void alterar(Usuario usuario) {
		
		Transaction transaction = null;
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.update(usuario);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				ConexaoHibernate.fecharConexao(session);
			}
		}
		
	}

	@Override
	public void deletar(Usuario usuario) {
		
		Transaction transaction = null;
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.delete(usuario);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				ConexaoHibernate.fecharConexao(session);
			}
		}
		
	}

	@Override
	public Usuario buscaPorUsuario(Usuario usuario) {
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			String hql = "SELECT u FROM Usuario u WHERE u.usuario = :parameter";
			Query consulta = session.createQuery(hql);
			
			consulta.setString("parameter", usuario.getUsuario());
			
			return (Usuario) consulta.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				ConexaoHibernate.fecharConexao(session);
			}
		}
		
		return null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> lista() {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			lista = session.createCriteria(Usuario.class).list();
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
