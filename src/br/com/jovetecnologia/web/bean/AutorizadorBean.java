package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@RequestScoped
public class AutorizadorBean implements Serializable {

	private static final long serialVersionUID = 9179253608783684613L;
	
	/**
	 * Retorna para a tela de login se o usuário não for autenticado
	 * @return URL da tela de login se o usuário não for autenticado
	 */
	public String autorizar() {
		if (!SystemUtils.isUsuarioLogado()) {
			return IOutcome.LOGIN;
		}
		return null;
	}
	
	/**
	 * Retorna para a tela de login se o usuário não for autenticado
	 * @return URL da tela de login se o usuário não for autenticado
	 */
	public String autorizarPaginaInicial() {
		if (!SystemUtils.isUsuarioLogado()) {
			return IOutcome.LOGIN;
		}
		return null;
	}

	/**
	 * Redireciona para a tela de início se o usuário estiver logado e tentar acessar a
	 * página de login novamente
	 * @return URL da tela de início se atender às condições
	 */
	public String redirecionar() {
		if (SystemUtils.isUsuarioLogado() && SystemUtils.getRequestURL().contains("/public/index.xhtml")) {
			return IOutcome.REGISTRO;
		}
		return null;
	}
}