package br.com.jovetecnologia.infrastructure.util;

import br.com.jovetecnologia.infrastructure.dao.UsuarioDAO;

public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO(){
		return new UsuarioDAO();
	}

}
