package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Projeto;

@ManagedBean
@ViewScoped
public class ProjetoBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = 1360530687537803289L;
	private Projeto projetoSelecionado;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		projetoSelecionado = new Projeto();
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
}
