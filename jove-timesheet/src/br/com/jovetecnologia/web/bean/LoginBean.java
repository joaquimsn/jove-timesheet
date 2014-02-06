package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.web.util.IOutcome;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 5185840091249342115L;

	private Usuario usuarioSelecionado;
	private String nome;
	private String senha;

	/**
	 * Inicializa os objetos da class
	 * @author Joaquim Neto
	 */
	public String abrirPagina() {

		usuarioSelecionado = new Usuario();

		return IOutcome.REGISTRO;
	}

	/**
	 * Realiza o login verificando o usuário e a senha na base
	 * @author Joaquim Neto	
	 */
	public void fazerLogin() {
		// TODO observação: o método chamava fazLogin(); e está errado.
		// O correto é utilizar um VERBO NO INFINITIVO, ou seja, fazerLogin();
		// O método estava private e não public como deveria ser.
		// Favor apagar estes comentáriols ao implementar a funcionalidade.
		// By Nicolas Ibanheiz
	}

	/**
	 * @return the usuarioSelecionado
	 */
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	/**
	 * @param usuarioSelecionado the usuarioSelecionado to set
	 */
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
