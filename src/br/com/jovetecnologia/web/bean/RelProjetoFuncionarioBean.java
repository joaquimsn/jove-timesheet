package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.omnifaces.cdi.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.IComporProjeto;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.domain.model.RelProjetoFuncionario;
import br.com.jovetecnologia.domain.service.FuncionarioService;
import br.com.jovetecnologia.domain.service.ProjetoService;

@ManagedBean
@ViewScoped
public class RelProjetoFuncionarioBean extends ComporProjetoBean implements IComporProjeto, Serializable {

	private RelProjetoFuncionario relacionamentoSelecionado;
	private List<RelProjetoFuncionario> listaRelacionamento;
	private List<RelProjetoFuncionario> listaRelacionamentoFiltrado;

	private List<Projeto> listaProjeto;

	private List<Funcionario> listaFuncionario;

	@PostConstruct
	public void inicializarPagina() {
		relacionamentoSelecionado = new RelProjetoFuncionario();

		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaFuncionario(new FuncionarioService().listarTodos());
		setListaProjeto(new ProjetoService().listarTodos());

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
	public void excluir() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasObjetoSelecionado() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @author Joaquim Neto
	 * @return the relacionamentoSelecionado
	 */
	public RelProjetoFuncionario getRelacionamentoSelecionado() {
		return relacionamentoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param relacionamentoSelecionado the relacionamentoSelecionado to set
	 */
	public void setRelacionamentoSelecionado(RelProjetoFuncionario relacionamentoSelecionado) {
		this.relacionamentoSelecionado = relacionamentoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaRelacionamento
	 */
	public List<RelProjetoFuncionario> getListaRelacionamento() {
		return listaRelacionamento;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaRelacionamento the listaRelacionamento to set
	 */
	public void setListaRelacionamento(List<RelProjetoFuncionario> listaRelacionamento) {
		this.listaRelacionamento = listaRelacionamento;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaRelacionamentoFiltrado
	 */
	public List<RelProjetoFuncionario> getListaRelacionamentoFiltrado() {
		return listaRelacionamentoFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaRelacionamentoFiltrado the listaRelacionamentoFiltrado to set
	 */
	public void setListaRelacionamentoFiltrado(List<RelProjetoFuncionario> listaRelacionamentoFiltrado) {
		this.listaRelacionamentoFiltrado = listaRelacionamentoFiltrado;
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

}
