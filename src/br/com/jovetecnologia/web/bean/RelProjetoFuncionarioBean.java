package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
import br.com.jovetecnologia.infrastructure.util.Messages;

@ManagedBean
@ViewScoped
public class RelProjetoFuncionarioBean extends ComporProjetoBean implements IComporProjeto, Serializable {

	private static final long serialVersionUID = 4449201043825864710L;

	private Funcionario funcionario;
	private Projeto projeto;

	private List<Funcionario> listaFuncionarioSelecionadoBase;

	private Funcionario[] funcionarioSelecionados;

	private List<Projeto> listaProjeto;

	private List<Funcionario> listaFuncionario;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		funcionarioSelecionados = new Funcionario[0];
		projeto = new Projeto();
		funcionario = new Funcionario();
		listaFuncionario = new ArrayList<Funcionario>();

		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaProjeto(new ProjetoService().listarTodos());
		setListaFuncionario(new FuncionarioService().listarTodos());

		if (projeto != null && projeto.getIdProjeto() != 0) {
			listaFuncionarioSelecionadoBase = new FuncionarioService().listarFuncionairoPorProjeto(getProjeto());
			setFuncionarioSelecionados(listaFuncionarioSelecionadoBase.toArray(new Funcionario[0]));
		} else {
			funcionarioSelecionados = new Funcionario[0];
		}
		
	}

	/**
	 * Salva as ações de cadastar, excluir realizada no relacionamento Funcionário Projeto
	 * @author Joaquim Neto
	 */
	public void salvar() {
		// Verifica se o usuário selecionou algum funcionário
		if (funcionarioSelecionados.length > 0 && projeto != null) {
			// Verifica o usuário selecionou algum novo Funcionário para o Projeto
			for (Funcionario funcionario : funcionarioSelecionados) {
				if (!listaFuncionarioSelecionadoBase.contains(funcionario)) {
					RelProjetoFuncionario relProjetoFuncionario = new RelProjetoFuncionario(funcionario, getProjeto());
					new RelProjetoFuncionarioService().cadastrar(relProjetoFuncionario);
					listaFuncionarioSelecionadoBase.add(funcionario);
				}
			}

			// Verifica se o usuário removeu algum Funcionario já cadastrado do projeto
			List<Funcionario> listaFuncionarioSelecionadoModificado = new ArrayList<>(
					Arrays.asList(funcionarioSelecionados));
			for (Funcionario funcionario : listaFuncionarioSelecionadoBase) {
				if (!listaFuncionarioSelecionadoModificado.contains(funcionario)) {
					new RelProjetoFuncionarioService().deletar(new RelProjetoFuncionario(funcionario, projeto));
				}
			}

			Messages.addWarn("Projeto salvo com sucesso");

			inicializarPagina();
		} else {
			Messages.addWarn("Selecione ao menos 1 Funcionário para um Projeto");
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

	/**
	 * @author Joaquim Neto
	 * @return the funcionarioSelecionados
	 */
	public Funcionario[] getFuncionarioSelecionados() {
		return funcionarioSelecionados;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionarioSelecionados the funcionarioSelecionados to set
	 */
	public void setFuncionarioSelecionados(Funcionario[] funcionarioSelecionados) {
		this.funcionarioSelecionados = funcionarioSelecionados;
	}

}
