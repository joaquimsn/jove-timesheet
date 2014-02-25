package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
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
	public String fazerLogin() {
		// TODO REMOVER ESTE MOCK APÓS CRIAÇÃO DO DAO
		if(nome.equals("joaquim") && senha.equals("jove")) {
			Usuario usuario = new Usuario();
			usuario.setUsuario("joaquim");
			usuario.setNivel(2);
			usuario.setAtivo(true);
			
			// Adicionando o usuário logado à sessão
			SessionBean sessionBean = SystemUtils.getSessionBean();
			sessionBean.setUsuarioLogado(usuario);
			
			return IOutcome.REGISTRO;
		} else {
			Messages.addError("Usuário ou senha incorreto");
			
			return null;
		}
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
