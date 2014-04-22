package br.com.jovetecnologia.domain.service;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Registro;
import br.com.jovetecnologia.infrastructure.dao.RegistroDAO;

public class RegistroService implements Serializable {

	private static final long serialVersionUID = 6260437287642588019L;

	private RegistroDAO registroDAO;

	public RegistroService() {
		registroDAO = new RegistroDAO();
	}
	
	public void cadastrar(Registro registro) {
		registroDAO.cadastar(registro);
	}

	public void deletar(Registro registro) {

	}

	public void alterar(Registro registro) {

	}

}
