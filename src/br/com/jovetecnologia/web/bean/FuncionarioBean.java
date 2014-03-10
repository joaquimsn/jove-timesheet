package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Departamento;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.service.DepartamentoService;
import br.com.jovetecnologia.domain.service.FuncionarioService;

@ManagedBean
@ViewScoped
public class FuncionarioBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Funcionario funcionarioSelecionado;

	private List<Funcionario> listaFuncionarioFiltrado;
	private List<Funcionario> listaFuncionario;
	private List<Departamento> listaDepartamento;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		funcionarioSelecionado = new Funcionario();
		listarTodos();
		setReadonly(false);
	}

	@Override
	public void listarTodos() {
		setListaFuncionario(new FuncionarioService().listarTodos());
		setListaDepartamento(new DepartamentoService().listarTodos());
	}

	@Override
	public void habilitarCampo() {
		setReadonly(false);
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
	
	public void ativar(Funcionario funcionario) {
		
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

	/**
	 * @author Joaquim Neto
	 * @return the listaFuncionario
	 */
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaFuncionario the listaFuncionario to set
	 */
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaDepartamento
	 */
	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaFuncionarioFiltrado
	 */
	public List<Funcionario> getListaFuncionarioFiltrado() {
		return listaFuncionarioFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaFuncionarioFiltrado the listaFuncionarioFiltrado to set
	 */
	public void setListaFuncionarioFiltrado(List<Funcionario> listaFuncionarioFiltrado) {
		this.listaFuncionarioFiltrado = listaFuncionarioFiltrado;
	}

}
