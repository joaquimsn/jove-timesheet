package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Departamento;

@ManagedBean
@ViewScoped
public class DepartamentoBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Departamento departamentoSelecionado;

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
	 * @return the departamentoSelecionado
	 */
	public Departamento getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param departamentoSelecionado the departamento to set
	 */
	public void setDepartamentoSelecionado(Departamento departamento) {
		this.departamentoSelecionado = departamento;
	}

}
