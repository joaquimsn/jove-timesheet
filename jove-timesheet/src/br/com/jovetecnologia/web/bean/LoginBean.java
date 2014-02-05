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
	private void fazLogin() {

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

}
