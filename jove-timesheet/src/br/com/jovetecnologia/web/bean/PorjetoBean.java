package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Projeto;

@ManagedBean
@ViewScoped
public class PorjetoBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = 1360530687537803289L;
	private Projeto projetoSelecionado;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina empresa
	 * @author Joaquim Neto
	 */
	
	@Override
	public void inicializarPagina() {
		projetoSelecionado = new Projeto();
	}
	
	/**
	 * Zera os atributos da empresa fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		projetoSelecionado = new Projeto();
	}
	
	/**
	 * Cadastra a empresa e limpa os campos
	 * @author Joaquim Neto
	 */
	public void cadastrar() {
		limparCampos();
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
