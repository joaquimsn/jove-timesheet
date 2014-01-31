package br.com.jovetecnologia.domain.vo;

import java.io.Serializable;

public class Sessao implements Serializable {
	
	private static final long serialVersionUID = 7517019360432808819L;
	
//	private Usuario usuarioLogado;
//	private int contadorBemvindo = 0;
//
//	/**
//	 * Retorna a Transportadora a qual pertence o Usuário logado no momento
//	 * @author Renan Baggio
//	 * @return Transportadora a qual pertence o Usuário logado
//	 */
//	public Transportadora getTransportadoraVinculadaUsuarioLogado() {
//		return usuarioLogado.getPessoa().getTransportadora();
//	}
//	
//	/**
//	 * Retorna o nome do usuário logado se o contador de mensagens de bem-vindo for 0 (zero)
//	 * @return String
//	 */
//	public String getUsuarioBemvindo() {
//		try {
//			if (getContadorBemvindo() != 0)
//				return null;
//
//			setContadorBemvindo(getContadorBemvindo() + 1);
//			return getUsuarioLogado().getNome();
//
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	// ========================================== \\
//	// ========== Getters and Setters =========== \\
//	// ========================================== \\
//
//	/**
//	 * @return the usuarioLogado
//	 */
//	public Usuario getUsuarioLogado() {
//		return usuarioLogado;
//	}
//
//	/**
//	 * @param usuarioLogado the usuarioLogado to set
//	 */
//	public void setUsuarioLogado(Usuario usuarioLogado) {
//		this.usuarioLogado = usuarioLogado;
//	}
//
//	/**
//	 * @return the contadorBemvindo
//	 */
//	public int getContadorBemvindo() {
//		return contadorBemvindo;
//	}
//
//	/**
//	 * @param contadorBemvindo the contadorBemvindo to set
//	 */
//	public void setContadorBemvindo(int contadorBemvindo) {
//		this.contadorBemvindo = contadorBemvindo;
//	}
}