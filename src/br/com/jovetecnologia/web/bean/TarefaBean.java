package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.domain.service.TarefaService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class TarefaBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Tarefa tarefaSelecionada;
	
	private List<Tarefa> listaTarefa;
	private List<Tarefa> listaTarefaFiltrada;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		tarefaSelecionada = new Tarefa();
		setReadonly(false);
		
		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaTarefa(new TarefaService().listarTodos());
	}

	@Override
	public void habilitarCampo() {
		setReadonly(false);
	}

	@Override
	public void cadastrar() {
		if (!validar()) {
			return;
		}

		new TarefaService().cadastrar(getTarefaSelecionada());

		Messages.addInfo("Atividade cadastrada com sucesso");
		
		inicializarPagina();
	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getTarefaSelecionada())){
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}

		new TarefaService().alterar(getTarefaSelecionada());

		Messages.addInfo("Atividade alterada com sucesso");
		
		inicializarPagina();
	}
	
	/**
	 * Ativar ou inativa a tarefa como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param tarefa Objeto tarefa
	 */
	public void ativarOuInativar(Tarefa tarefa) {
		StringBuilder info = new StringBuilder("A tarefa ");
		info.append(tarefa.getNome()).append(" foi ");

		if (tarefa.isAtivo()) {
			info.append("inativado com sucesso");
			tarefa.setAtivo(false);
		} else {
			info.append("ativado com sucesso");
			tarefa.setAtivo(true);
		}

		new TarefaService().ativarOuInativar(tarefa);

		Messages.addInfo(info.toString());
		
		listarTodos();
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (getTarefaSelecionada().getIdUsuario() == 0) {
			return false;
		}
		return true;
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
	public void setTarefaSelecionada(Tarefa tarefa) {
		if (tarefa != null && !isReadonly() && tarefaSelecionada != tarefa) {
			tarefaSelecionada = tarefa;
			setReadonly(true);
		} else if (isReadonly() && hasObjetoSelecionado()) {
			tarefaSelecionada = tarefa;
			setReadonly(true);
		}
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaTarefa
	 */
	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaTarefa the listaTarefa to set
	 */
	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaTarefaFiltrada
	 */
	public List<Tarefa> getListaTarefaFiltrada() {
		return listaTarefaFiltrada;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaTarefaFiltrada the listaTarefaFiltrada to set
	 */
	public void setListaTarefaFiltrada(List<Tarefa> listaTarefaFiltrada) {
		this.listaTarefaFiltrada = listaTarefaFiltrada;
	}

}
