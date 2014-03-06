package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Departamento;

@ManagedBean
@ViewScoped
public class DepartamentoBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -3779041589727892789L;
	
	private Departamento departamentoSelecionado;

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Departamento
	 * @author Joaquim Neto
	 */
	
	@PostConstruct
	public void inicializarComponentes() {
		
	}
	
	/**
	 * Zera os atributos da pagina departamento fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		departamentoSelecionado = new Departamento();
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
