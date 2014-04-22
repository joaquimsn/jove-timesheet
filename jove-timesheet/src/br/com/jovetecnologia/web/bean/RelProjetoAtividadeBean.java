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
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.domain.model.RelProjetoAtividade;
import br.com.jovetecnologia.domain.service.AtividadeService;
import br.com.jovetecnologia.domain.service.ProjetoService;
import br.com.jovetecnologia.domain.service.RelProjetoAtividadeService;
import br.com.jovetecnologia.infrastructure.util.Messages;

@ManagedBean
@ViewScoped
public class RelProjetoAtividadeBean extends ComporProjetoBean implements IComporProjeto, Serializable {

	private static final long serialVersionUID = -8138694907388711222L;

	private Projeto projetoSelecionado;

	private List<Atividade> listaAtividadeSelecionadaBase;

	private Atividade[] atividadeSelecionadas;

	private List<Projeto> listaProjeto;

	private List<Atividade> listaAtividade;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		atividadeSelecionadas = new Atividade[0];
		projetoSelecionado = new Projeto();
		listaAtividade = new ArrayList<Atividade>();

		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaProjeto(new ProjetoService().listarTodos());
		setListaAtividade(new AtividadeService().listarTodos());

		if (projetoSelecionado != null && projetoSelecionado.getIdProjeto() != 0) {
			listaAtividadeSelecionadaBase = new AtividadeService().buscarAtividadePorProjeto(projetoSelecionado);
			setAtividadeSelecionadas(listaAtividadeSelecionadaBase.toArray(new Atividade[0]));
		} else {
			atividadeSelecionadas = new Atividade[0];
		}

	}

	/**
	 * Salva as ações de cadastar, excluir realizada no relacionamento Funcionário Projeto
	 * @author Joaquim Neto
	 */
	public void salvar() {
		// Verifica se o usuário selecionou alguma atividade
		if (atividadeSelecionadas.length > 0 && projetoSelecionado != null) {
			// Verifica o usuário selecionou alguma nova atividade para o Projeto
			for (Atividade atividade : atividadeSelecionadas) {
				if (!listaAtividadeSelecionadaBase.contains(atividade)) {
					RelProjetoAtividade relProjetoAtividade = new RelProjetoAtividade(projetoSelecionado, atividade);
					new RelProjetoAtividadeService().cadastrar(relProjetoAtividade);
					listaAtividadeSelecionadaBase.add(atividade);
				}
			}

			// Verifica se o usuário removeu alguma Atividade já cadastrada no projeto
			List<Atividade> listaAtividadeSelecionadoModificado = new ArrayList<>(Arrays.asList(atividadeSelecionadas));
			for (Atividade atividade : listaAtividadeSelecionadaBase) {
				if (!listaAtividadeSelecionadoModificado.contains(atividade)) {
					new RelProjetoAtividadeService().deletar(new RelProjetoAtividade(projetoSelecionado, atividade));
				}
			}

			Messages.addWarn("Relacionamento salvo com sucesso");

			inicializarPagina();
		} else {
			Messages.addWarn("Selecione ao menos 1 Atividade para um Projeto");
		}

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
	 * @return the atividadeSelecionadas
	 */
	public Atividade[] getAtividadeSelecionadas() {
		return atividadeSelecionadas;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeSelecionadas the atividadeSelecionadas to set
	 */
	public void setAtividadeSelecionadas(Atividade[] atividadeSelecionadas) {
		this.atividadeSelecionadas = atividadeSelecionadas;
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

}
