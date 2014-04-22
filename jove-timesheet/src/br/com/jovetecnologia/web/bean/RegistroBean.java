package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class RegistroBean implements Serializable {

	private static final long serialVersionUID = -1183856785057134758L;

	private boolean calendario;// Refazer só teste

	private Funcionario funcionarioSelecionado;
	
	private Projeto projetoSelecionado;
	private Atividade atividadeSelecionada;
	private Tarefa tarefaSelecionada;
	
	private List<Projeto> listaProjeto;
	private List<Atividade> listaAtividade;
	private List<Tarefa> listaTarefa;

	public RegistroBean() {
		calendario = false;
	}

	/**
	 * Responsavel por abrir a pagina de registro
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada pelo cliente
	 */
	public String abrirPagina() {

		return IOutcome.REGISTRO;
	}
	
	/**
	 * Inicializa todos os componentes essenciais para o funcionamento da pagina
	 * @author Joaquim Neto
	 */
	@PostConstruct
	public void inicializarPagina() {
		funcionarioSelecionado = new Funcionario();
		projetoSelecionado = new Projeto();
		atividadeSelecionada = new Atividade();
		tarefaSelecionada = new Tarefa();

	}

	/**
	 * Define o estado da pagina calendario, quando for false exibe a tela principal, true
	 * exibe a tela de registro
	 * @author Joaquim Neto
	 */
	public void setarCalendario() {
		if (calendario) {
			calendario = false;
		} else {
			calendario = true;
		}
	}

	/**
	 * REFAZER só teste
	 * @return the calendario
	 */
	public boolean isCalendario() {
		return calendario;
	}

	/**
	 * REFAZER só teste
	 * @param calendario the calendario to set
	 */
	public void setCalendario(boolean calendario) {
		this.calendario = calendario;
	}

	/**
	 * Verifica-se o usuário logado é tem nivel de funcionario ou administrado
	 * @author Joaquim Neto
	 * @return <b>true<\b> se o usuário logado tiver nivel Funcionário
	 */
	public boolean isFuncionario() {
		return (SystemUtils.getUsuarioLogado().isAdministrador() == false ? true : false);
	}

	/**
	 * @author Joaquim Neto
	 * @return the funcionarioSelecionado
	 */
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionarioSelecionado the funcionarioSelecionado to set
	 */
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the projetoSelecionado
	 */
	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param projetoSelecionado the projetoSelecionado to set
	 */
	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the atividadeSelecionada
	 */
	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeSelecionada the atividadeSelecionada to set
	 */
	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
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

	/**
	 * @author Joaquim Neto
	 * @return the listaProjeto
	 */
	public List<Projeto> getListaProjeto() {
		return listaProjeto;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaProjeto the listaProjeto to set
	 */
	public void setListaProjeto(List<Projeto> listaProjeto) {
		this.listaProjeto = listaProjeto;
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
