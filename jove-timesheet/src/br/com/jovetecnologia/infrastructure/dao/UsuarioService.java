package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Usuario;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = -3286343037977842567L;
	
	/**
	 * Retorna um objeto usuario se as credenciais passadas estiverem na DB, se não retorna null
	 * @author Joaquim Neto
	 * @param nome String com o login
	 * @param senha String com a senha
	 * @return Objeto usuario
	 */
	public Usuario validar(String login, String senha) {
		return new UsuarioDAO().validarUsuario(login, senha);
	}

}
