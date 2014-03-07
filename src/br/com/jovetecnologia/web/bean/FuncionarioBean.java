package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Funcionario funcionarioSelecionado;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		funcionarioSelecionado = new Funcionario();
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

}
