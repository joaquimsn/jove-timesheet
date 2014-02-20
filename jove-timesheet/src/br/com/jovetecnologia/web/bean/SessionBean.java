package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.domain.model.Usuario;

/**
 * Guarda o usuario durante toda a sessão se a validação ocorrer com sucesso
 * @author Joaquim Neto
 *
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 9085726862618841138L;
	private Usuario usuarioLogado;

	/**
	 * @return the usuarioLogado
	 */
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	/**
	 * @param usuarioLogado the usuarioLogado to set
	 */
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
