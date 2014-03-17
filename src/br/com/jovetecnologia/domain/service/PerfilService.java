package br.com.jovetecnologia.domain.service;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

public class PerfilService implements Serializable {
	
	private static final long serialVersionUID = 8145012063536027670L;


	/**
	 * Altera a senha do usuario
	 * @author Joaquim Neto
	 * @param usuario Objeto que será modificado
	 */
	public void alterar(Usuario usuario) {
		new UsuarioService().alterar(usuario);
	}
	
	/**
	 * Retorna o objeto Funcionário da sessão
	 * @author Joaquim Neto
	 * @return Objeto Funcionario
	 */
	public Funcionario obterFuncionario() {
		return SystemUtils.getFuncionarioLogado();
	}
	
	
	/**
	 * Retorna o objeto Usuário da sessão
	 * @author Joaquim Neto
	 * @return Objeto usuario
	 */
	public Usuario obterUsuario() {
		return  SystemUtils.getUsuarioLogado();
	}
}
