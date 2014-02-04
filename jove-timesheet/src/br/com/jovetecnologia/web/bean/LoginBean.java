package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.util.DAOFactory;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 5185840091249342115L;

	private Usuario usuarioSelecionado;
	private DAOFactory daoFactory;

	/**
	 * Inicializa os objetos da class
	 * @author Joaquim Neto
	 */
	public LoginBean() {
		usuarioSelecionado = new Usuario();
		daoFactory = new DAOFactory();
	}

	/**
	 * Realiza o login verificando o usuário e a senha na base
	 * @author Joaquim Neto
	 */
	public void fazLogin() {

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
