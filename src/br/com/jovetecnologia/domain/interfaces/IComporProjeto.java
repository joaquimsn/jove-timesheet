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

	/**
	 * Define Readonly como <b>false</b> para liberar o click no botão
	 * @author Joaquim Neto
	 */
	void habilitarCampo();

	/**
	 * Cadastra um relacionamento
	 * @author Joaquim Neto
	 */
	void cadastrar();

	/**
	 * Excluir um Relacionamento
	 * @author Joaquim Neto
	 */
	void excluir();

	/**
	 * Retorna <b>true</b> se existir um relacionamento selecionada, caso contrario retorna false
	 * @author Joaquim Neto
	 * @return <b>true</b> Se tiver objeto selecionado
	 */
	boolean hasObjetoSelecionado();
}
