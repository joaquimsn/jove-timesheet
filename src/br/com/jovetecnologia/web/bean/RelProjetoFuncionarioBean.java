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
import br.com.jovetecnologia.domain.service.RelProjetoFuncionarioService;

@ManagedBean
@ViewScoped
public class RelProjetoFuncionarioBean extends ComporProjetoBean implements IComporProjeto, Serializable {

	private static final long serialVersionUID = 4449201043825864710L;

	private Funcionario funcionario;
	private Projeto projeto;

	private RelProjetoFuncionario relacionamentoSelecionado;
	private List<RelProjetoFuncionario> listaRelacionamento;
	private List<RelProjetoFuncionario> listaRelacionamentoFiltrado;

	private List<Projeto> listaProjeto;

	private List<Funcionario> listaFuncionario;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		relacionamentoSelecionado = new RelProjetoFuncionario();
		projeto = new Projeto();
		funcionario = new Funcionario();

		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaFuncionario(new FuncionarioService().listarTodos());
		setListaProjeto(new ProjetoService().listarTodos());
		setListaRelacionamento(new RelProjetoFuncionarioService().listarTodos());

	}

	@Override
	public void habilitarCampo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cadastrar() {

		new RelProjetoFuncionarioService().cadastrar(new RelProjetoFuncionario(getFuncionario(), getProjeto()));

		inicializarPagina();

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
	public void setRelacionamentoSelecionado(RelProjetoFuncionario relacionamento) {
		if (relacionamento != null && !isReadonly() && relacionamentoSelecionado != relacionamento) {
			relacionamentoSelecionado = relacionamento;
			setReadonly(true);
		} else if (isReadonly() && hasObjetoSelecionado()) {
			relacionamentoSelecionado = relacionamento;
			setReadonly(true);
		}
	}

	/**
	 * @author Joaquim Neto
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @author Joaquim Neto
	 * @return the projeto
	 */
	public Projeto getProjeto() {
		return projeto;
	}

	/**
	 * @author Joaquim Neto
	 * @param projeto the projeto to set
	 */
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
