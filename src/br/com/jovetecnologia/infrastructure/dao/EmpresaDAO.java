package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Empresa;

public class EmpresaDAO extends DAO<Empresa> implements Serializable {

	private static final long serialVersionUID = 642507707618912925L;
	
	public EmpresaDAO() {
		super(Empresa.class);
	}

}
