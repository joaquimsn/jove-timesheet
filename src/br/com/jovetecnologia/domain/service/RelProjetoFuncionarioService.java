package br.com.jovetecnologia.domain.service;

import br.com.jovetecnologia.domain.model.RelProjetoFuncionario;
import br.com.jovetecnologia.infrastructure.dao.RelProjetoFuncionarioDAO;

public class RelProjetoFuncionarioService {
	
	private RelProjetoFuncionarioDAO relProjetoFuncionarioDAO;
	
	public RelProjetoFuncionarioService() {
		relProjetoFuncionarioDAO = new RelProjetoFuncionarioDAO();
	}
	
	
	/**
	 * Grava o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionario
	 */
	public void cadastrar(RelProjetoFuncionario relacionamento) {
		relProjetoFuncionarioDAO.cadastar(relacionamento);
	}
	
	/**
	 * Excluir o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionatio
	 */
	public void deletar(RelProjetoFuncionario relacionamento) {
		relProjetoFuncionarioDAO.deletar(relacionamento);
	}
}
