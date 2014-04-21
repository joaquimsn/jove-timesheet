package br.com.jovetecnologia.web.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.service.AtividadeService;
import br.com.jovetecnologia.domain.service.ProjetoService;
import br.com.jovetecnologia.domain.service.TarefaService;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ViewScoped
@ManagedBean
public class RegistroFuncionarioBean extends RegistroBean {

	private static final long serialVersionUID = 8763366471454471909L;

	private String dataExibicao;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		super.inicializarPagina();

		Date dataAtual = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("dd - MMMM - yyy");
		dataExibicao = simp.format(dataAtual);

		listarTodos();
	}

	public void listarTodos() {
		setListaProjeto(new ProjetoService().consultarProjetoPorFuncionario(SystemUtils.getFuncionarioLogado()));

		if (getProjetoSelecionado() != null && getProjetoSelecionado().getIdProjeto() != 0) {
			setListaAtividade(new AtividadeService().buscarAtividadePorProjeto(getProjetoSelecionado()));
		}
		if (getAtividadeSelecionada() != null && getAtividadeSelecionada().getIdAtividade() != 0) {
			setListaTarefa(new TarefaService().consultarTarefaPorAtividade(getAtividadeSelecionada()));
		}
	}

	/**
	 * @author Joaquim Neto
	 * @return the dataExibicao
	 */
	public String getDataExibicao() {
		return dataExibicao;
	}

	/**
	 * @author Joaquim Neto
	 * @param dataExibicao the dataExibicao to set
	 */
	public void setDataExibicao(String dataExibicao) {
		this.dataExibicao = dataExibicao;
	}

}
