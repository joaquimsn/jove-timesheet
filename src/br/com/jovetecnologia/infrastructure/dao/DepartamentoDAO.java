package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Departamento;

public class DepartamentoDAO extends DAO<Departamento> implements Serializable{
	
	private static final long serialVersionUID = -1851332792490521385L;

	public DepartamentoDAO() {
		super(Departamento.class);
	}
}
