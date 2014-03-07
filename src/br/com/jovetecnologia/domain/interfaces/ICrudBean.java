package br.com.jovetecnologia.domain.interfaces;

import javax.annotation.PostConstruct;


public interface ICrudBean {

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Atividade
	 * @author Joaquim Neto
	 */
	@PostConstruct
	public void inicializarPagina(); 
	
	/**
	 * Lista todos os objetos salvos na base em ordem DESC
	 * @author Joaquim Neto
	 */
	abstract void listarTodos();

	/**
	 * Define Readonly como <b>false</b> para liberar a edição dos campos
	 * @author Joaquim Neto
	 */
	void habilitarCampo();

	/**
	 * Cadastra o objeto, valida os campos e limpa se cadastrada com sucesso;
	 * @author Joaquim Neto
	 */
	void cadastrar();

	/**
	 * Valida todos os campos obrigatórios
	 * @author Joaquim Neto
	 * @return <b>true</br> se a validação ocorrer com sucesso!
	 */
	boolean validar();

	/**
	 * Persiste o objeto alterado na base, valida os campos e limpa se alterado com
	 * sucesso
	 * @author Joaquim Neto
	 */
	void alterar();

	/**
	 * Retorna true se existir empresa selecionada, caso contrario retorna false
	 * @author Joaquim Neto
	 * @return <b>true</b> Se tiver empresa selecionado
	 */
	boolean hasObjetoSelecionado();

}
