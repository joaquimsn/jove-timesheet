package br.com.jovetecnologia.infrastructure.dao;

import java.util.List;

import br.com.jovetecnologia.domain.model.Usuario;

/**
 * Define os métodos que serão implementados pelo UsuarioDAO
 * @author Joaquim Neto
 *
 */
public interface IUsuarioDAO {
	
	/**
	 * Salavar o objeto na base
	 * @author Joaquim Neto
	 * @param usuario Objeto Usuario 
	 */
	public void salvar(Usuario usuario);
	
	/**
	 * Alterar o Objeto Usuario persistido na base
	 * @author Joaquim Neto
	 * @param usuario Objeto Usuario
	 */
	public void alterar(Usuario usuario);
	
	/**
	 * Deleta o Usuario persistido na base
	 * @author Joaquim Neto
	 * @param usuario Objeto Usuario
	 */
	public void deletar(Usuario usuario);
	
	/**
	 * Busca um Objeto usuario na base pelo nome
	 * @author Joaquim Neto
	 * @param usuario Nome usuario obtido na view
	 * @return Objeto Usuario
	 */
	public Usuario buscaPorUsuario(Usuario usuario);
	
	/**
	 * Retorna todos os usuarios cadastrado na base
	 * @author Joaquim Neto
	 * @return List de Usuarios
	 */
	public List<Usuario> lista();
	
}
