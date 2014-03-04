package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -3779041589727892789L;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Departamento
	 * @author Joaquim Neto
	 */
	
	@PostConstruct
	public void inicializarComponentes() {
		funcionarioSelecionado = new Funcionario();
	}
	
	/**
	 * Zera os atributos da departamento fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		funcionarioSelecionado = new Funcionario();
	}
	
	/**
	 * Cadastra o departamento e limpa os campos
	 * @author Joaquim Neto
	 */
	public void cadastrar() {
		limparCampos();
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