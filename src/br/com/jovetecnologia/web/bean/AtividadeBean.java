package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.service.AtividadeService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class AtividadeBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -4624461885675885559L;
	
	private Atividade atividadeSelecionada;
	
	private List<Atividade> listaAtividade;
	private List<Atividade> listaAtividadeFiltrada;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		atividadeSelecionada = new Atividade();
		setReadonly(false);
		
		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaAtividade(new AtividadeService().listarTodos());
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

		new AtividadeService().cadastrar(getAtividadeSelecionada());

		Messages.addInfo("Atividade cadastrada com sucesso");
		
		inicializarPagina();
	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getAtividadeSelecionada())){
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}

		new AtividadeService().alterar(getAtividadeSelecionada());

		Messages.addInfo("Atividade alterada com sucesso");
		
		inicializarPagina();
	}
	
	/**
	 * Ativar ou inativa a atividade como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param atividade Objeto atividade
	 */
	public void ativarOuInativar(Atividade atividade) {
		StringBuilder info = new StringBuilder("A atividade ");
		info.append(atividade.getNome()).append(" foi ");

		if (atividade.isAtivo()) {
			info.append("inativado com sucesso");
			atividade.setAtivo(false);
		} else {
			info.append("ativado com sucesso");
			atividade.setAtivo(true);
		}

		new AtividadeService().ativarOuInativar(atividade);

		Messages.addInfo(info.toString());
		
		listarTodos();
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (getAtividadeSelecionada().getIdUsuario() == 0) {
			return false;
		}
		return true;
	}
	
	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeSelecionada the atividadeSelecionada to set
	 */
	public void setAtividadeSelecionada(Atividade atividade) {
		if (atividade != null && !isReadonly() && atividadeSelecionada != atividade) {
			atividadeSelecionada = atividade;
			setReadonly(true);
		} else if (isReadonly() && hasObjetoSelecionado()) {
			atividadeSelecionada = atividade;
			setReadonly(true);
		}

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
	 * @return the listaAtividadeFiltrada
	 */
	public List<Atividade> getListaAtividadeFiltrada() {
		return listaAtividadeFiltrada;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaAtividadeFiltrada the listaAtividadeFiltrada to set
	 */
	public void setListaAtividadeFiltrada(List<Atividade> listaAtividadeFiltrada) {
		this.listaAtividadeFiltrada = listaAtividadeFiltrada;
	}
}
