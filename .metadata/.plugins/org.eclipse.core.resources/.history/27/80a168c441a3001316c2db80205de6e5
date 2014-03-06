package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.infrastructure.dao.EmpresaDAO;


/**
 * Contem as principais regras de negocio do objeto Empresa
 * @author Joaquim Neto
 *
 */
public class EmpresaService implements Serializable {

	private static final long serialVersionUID = -1533531032670588261L;
	
	/**
	 * Cadastra uma empresa
	 * @author Joaquim Neto
	 * @param empresa para ser cadastrada
	 */
	public void cadastrar(Empresa empresa) {
		empresa.setAtivo(true);
		
		//Verifica se a empresa já tem uma data de cadastro registrada
		if(empresa.getDataCadastro() == null) {
			empresa.setDataCadastro( new Date());			
		}
		
		new EmpresaDAO().cadastar(empresa);
	}
}
