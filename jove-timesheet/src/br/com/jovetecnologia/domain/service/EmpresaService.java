package br.com.jovetecnologia.domain.service;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.infrastructure.dao.EmpresaDAO;


/**
 * Contem as principais regras de negocio do objeto Empresa
 * @author Joaquim S. Neto
 *
 */
public class EmpresaService implements Serializable {

	private static final long serialVersionUID = -1533531032670588261L;
	
	/**
	 * Salva a empresa no DB
	 * @author Joaquim S. Neto
	 * @param empresa Objeto
	 */
	public void cadastrar(Empresa empresa) {
		new EmpresaDAO().cadastar(empresa);
	}
}
