package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.domain.service.ProjetoService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class ProjetoBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = 1360530687537803289L;
	private Projeto projetoSelecionado;
	
	private List<Projeto> listaProjeto;
	private List<Projeto> listaProjetoFiltrado;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		projetoSelecionado = new Projeto();
		setReadonly(false);
		
		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaProjeto(new ProjetoService().listarTodos());
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

		new ProjetoService().cadastrar(getProjetoSelecionado());

		Messages.addInfo("Projeto cadastrado com sucesso");
		
		inicializarPagina();

	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getProjetoSelecionado())){
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}

		new ProjetoService().alterar(getProjetoSelecionado());

		Messages.addInfo("Projeto alterado com sucesso");
		
		inicializarPagina();

	}
	
	/**
	 * Ativar ou inativa o projeto como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param projeto Objeto projeto
	 */
	public void ativarOuInativar(Projeto projeto) {
		StringBuilder info = new StringBuilder("O projeto ");
		info.append(projeto.getNome()).append(" foi ");

		if (projeto.isAtivo()) {
			info.append("inativado com sucesso");
			projeto.setAtivo(false);
		} else {
			info.append("ativado com sucesso");
			projeto.setAtivo(true);
		}

		new ProjetoService().ativarOuInativar(projeto);

		Messages.addInfo(info.toString());
		listarTodos();
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (projetoSelecionado.getIdUsuario() == 0) {
			return false;
		}
		return true;
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
	public void setProjetoSelecionado(Projeto projeto) {
		if (projeto != null && !isReadonly() && projetoSelecionado != projeto) {
			projetoSelecionado = projeto;
			setReadonly(true);
		} else if (isReadonly() && hasObjetoSelecionado()) {
			projetoSelecionado = projeto;
			setReadonly(true);
		}

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
	 * @return the listaProjetoFiltrado
	 */
	public List<Projeto> getListaProjetoFiltrado() {
		return listaProjetoFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaProjetoFiltrado the listaProjetoFiltrado to set
	 */
	public void setListaProjetoFiltrado(List<Projeto> listaProjetoFiltrado) {
		this.listaProjetoFiltrado = listaProjetoFiltrado;
	}
}
