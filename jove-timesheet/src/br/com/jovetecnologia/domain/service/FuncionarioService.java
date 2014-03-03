package br.com.jovetecnologia.domain.service;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.infrastructure.dao.FuncionarioDAO;

/**
 * Contem as principais regras de negocio do objeto Funcionario
 * @author Joaquim Neto
 *
 */
public class FuncionarioService {
	
	/**
	 * Persiste o funcionario e faz a validação dos dados
	 * @author Joaquim Neto
	 */
	public void cadastrar() {

	}
	
	
	/**
	 * Consulta o funcionario na Base, pela sua PK
	 * @author Joaquim Neto
	 * @param idFuncionario PK do funcionario
	 * @return Funcionario
	 */
	public Funcionario consultarPorId(int idFuncionario) {
		return new FuncionarioDAO().consultarPorId(idFuncionario);
	}
}
