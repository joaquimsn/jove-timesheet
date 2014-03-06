package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Tarefa;

@ManagedBean
@ViewScoped
public class TarefaBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -3779041589727892789L;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Tarefa
	 * @author Joaquim Neto
	 */
	
		
	@PostConstruct
	public void inicializarComponentes() {
		
	}
	
	/**
	 * Zera os atributos da pagina departamento fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		tarefaSelecionada = new Tarefa();
	}
	
	/**
	 * Cadastra a taerfa e limpa os campos
	 * @author Joaquim Neto
	 */
	public void cadastrar() {
		limparCampos();
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the tarefaSelecionada
	 */
	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @param tarefaSelecionada the tarefaSelecionada to set
	 */
	public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}
}
