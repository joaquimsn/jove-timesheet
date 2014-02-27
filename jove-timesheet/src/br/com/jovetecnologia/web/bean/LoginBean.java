package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.domain.service.UsuarioService;
import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 5185840091249342115L;

	private String login;
	private String senha;

	/**
	 * Realiza o login verificando o usuário e a senha na base
	 * @author Joaquim Neto
	 */
	public String fazerLogin() {

		Usuario usuario = new UsuarioService().validar(getLogin(), getSenha());

		if (usuario != null) {

			// Adicionando o usuário logado à sessão
			SessionBean sessionBean = SystemUtils.getSessionBean();
			sessionBean.setUsuarioLogado(usuario);

			return IOutcome.REGISTRO;
		} else {
			Messages.addError("Usuário ou senha incorreto");

			return null;
		}
	}

	public String fazerLogOff() {
		SessionBean sessionBean = SystemUtils.getSessionBean();
		sessionBean.setUsuarioLogado(null);

		return IOutcome.LOGIN;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param nome the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
