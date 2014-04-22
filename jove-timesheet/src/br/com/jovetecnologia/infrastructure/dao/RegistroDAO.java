package br.com.jovetecnologia.infrastructure.dao;

import br.com.jovetecnologia.domain.model.Registro;

public class RegistroDAO extends DAO<Registro> {

	private static final long serialVersionUID = -7727215420179042495L;

	public RegistroDAO() {
		super(Registro.class);
	}

}
