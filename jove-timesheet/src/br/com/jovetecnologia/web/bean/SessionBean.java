package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.domain.model.Funcionario;
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
	private Funcionario funcionarioLogado;

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
	
	/**
	 * @author Joaquim Neto
	 * @return the funcionarioLogado
	 */
	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionarioLogado the funcionarioLogado to set
	 */
	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	/**
	 * Usado somente no login para inicializar o sessionBean
	 * @return ""
	 */
	public String getInstancia() {
		return "";
	}

}
