package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Tarefa;

@ManagedBean
@ViewScoped
public class TarefaBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Tarefa tarefaSelecionada;

	@Override
	@PostConstruct
	public void inicializarPagina() {

	}

	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitarCampo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasObjetoSelecionado() {
		// TODO Auto-generated method stub
		return false;
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
