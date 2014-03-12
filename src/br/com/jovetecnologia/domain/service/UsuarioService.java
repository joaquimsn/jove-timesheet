package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.dao.UsuarioDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

/**
 * Contem as principais regras de negocio do objeto Usuario
 * @author joaquim
 *
 */
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = -7900750129613892061L;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		usuarioDAO = new UsuarioDAO();
	}
	
	/**
	 * Retorna um objeto usuario se as credenciais passadas estiverem na DB, se não retorna null
	 * @author Joaquim Neto
	 * @param login String com o login
	 * @param senha String com a senha
	 * @return Objeto usuario
	 */
	public Usuario validar(String login, String senha) {
		return usuarioDAO.validarUsuario(login, senha);
	}
	
	/**
	 * Salva o usuario na base, definindo a data do cadastro e  o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param usuario Objeto usuario que será persistido
	 */
	public void cadastrar(Usuario usuario) {
		usuario.setAtivo(true);
		usuario.setDataCadastro(new Date());
		usuario.setDataManutencao(new Date());
		usuario.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		usuarioDAO.cadastar(usuario);
	}
	
	/**
	 * Altera o usuario na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param usuario Objeto usuario que será alterado
	 */
	public void alterar(Usuario usuario) {
		usuario.setDataManutencao(new Date());
		usuario.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		usuarioDAO.alterar(usuario);
	}
	
	public Usuario pesquisarPorFuncionario(Funcionario funcionario ){
		return usuarioDAO.pesquisarPorFuncionario(funcionario);
	}

}
