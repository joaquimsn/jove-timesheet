package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.omnifaces.cdi.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.IComporProjeto;
import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.RelAtividadeTarefa;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.domain.service.AtividadeService;
import br.com.jovetecnologia.domain.service.RelAtividadeTarefaService;
import br.com.jovetecnologia.domain.service.TarefaService;
import br.com.jovetecnologia.infrastructure.util.Messages;

@ManagedBean
@ViewScoped
public class RelAtividadeTarefaBean extends ComporProjetoBean implements IComporProjeto, Serializable {

	private static final long serialVersionUID = 4449201043825864710L;

	private Atividade atividadeSelecionada;

	private List<Tarefa> listaTarefaSelecionadaBase;

	private Tarefa[] tarefaSelecionadas;

	private List<Atividade> listaAtividade;

	private List<Tarefa> listaTarefa;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		tarefaSelecionadas = new Tarefa[0];
		atividadeSelecionada = new Atividade();
		listaTarefa = new ArrayList<Tarefa>();

		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaAtividade(new AtividadeService().listarTodos());
		setListaTarefa(new TarefaService().listarTodos());

		if (atividadeSelecionada != null && atividadeSelecionada.getIdAtividade() != 0) {
			listaTarefaSelecionadaBase = new TarefaService().consultarTarefaPorAtividade(getAtividadeSelecionada());
			setTarefaSelecionadas(listaTarefaSelecionadaBase.toArray(new Tarefa[0]));
		} else {
			tarefaSelecionadas = new Tarefa[0];
		}

	}

	/**
	 * Salva as ações de cadastar, excluir realizada no relacionamento Funcionário
	 * Atividade
	 * @author Joaquim Neto
	 */
	public void salvar() {
		// Verifica se o usuário selecionou algum funcionário
		if (tarefaSelecionadas.length > 0 && atividadeSelecionada != null) {
			// Verifica o usuário selecionou algum novo Funcionário para o Atividade
			for (Tarefa tarefa : tarefaSelecionadas) {
				if (!listaTarefaSelecionadaBase.contains(tarefa)) {
					RelAtividadeTarefa relAtividadeTarefa = new RelAtividadeTarefa(getAtividadeSelecionada(), tarefa);
					new RelAtividadeTarefaService().cadastrar(relAtividadeTarefa);
					listaTarefaSelecionadaBase.add(tarefa);
				}
			}

			// Verifica se o usuário removeu algum Tarefa já cadastrado do projeto
			List<Tarefa> listaTarefaSelecionadoModificado = new ArrayList<>(Arrays.asList(tarefaSelecionadas));
			for (Tarefa tarefa : listaTarefaSelecionadaBase) {
				if (!listaTarefaSelecionadoModificado.contains(tarefa)) {
					new RelAtividadeTarefaService().deletar(new RelAtividadeTarefa(getAtividadeSelecionada(), tarefa));
				}
			}

			Messages.addWarn("Atividade salvo com sucesso");

			inicializarPagina();
		} else {
			Messages.addWarn("Selecione ao menos 1 Funcionário para um Atividade");
		}

	}

	/**
	 * @author Joaquim Neto
	 * @return the atividadeSelecionado
	 */
	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeSelecionada the atividadeSelecionado to set
	 */
	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @return the tarefaSelecionadas
	 */
	public Tarefa[] getTarefaSelecionadas() {
		return tarefaSelecionadas;
	}

	/**
	 * @author Joaquim Neto
	 * @param tarefaSelecionadas the tarefaSelecionadas to set
	 */
	public void setTarefaSelecionadas(Tarefa[] tarefaSelecionadas) {
		this.tarefaSelecionadas = tarefaSelecionadas;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaAtividade
	 */
	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaAtividade the listaAtividade to set
	 */
	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
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

}
