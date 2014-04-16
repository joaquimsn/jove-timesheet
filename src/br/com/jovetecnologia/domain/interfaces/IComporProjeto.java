package br.com.jovetecnologia.domain.interfaces;

import javax.annotation.PostConstruct;

public interface IComporProjeto {

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina
	 * @author Joaquim Neto
	 */
	@PostConstruct
	public void inicializarPagina(); 
	
	/**
	 * Lista todos os relacionamento salvos na base em ordem DESC
	 * @author Joaquim Neto
	 */
	abstract void listarTodos();
}
