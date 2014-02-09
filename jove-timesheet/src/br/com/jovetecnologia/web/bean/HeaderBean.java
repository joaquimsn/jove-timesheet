package br.com.jovetecnologia.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.web.util.IOutcome;

@ManagedBean
@SessionScoped
public class HeaderBean {
	
	/**
	 * Retorna o nome da pagina que o usuário solicitou
	 * @author Joaquim Neto
	 * @return String
	 */
	public String registro(){
		return IOutcome.REGISTRO;
	}
	
	/**
	 * Retorna o nome da pagina que o usuário solicitou
	 * @author Joaquim Neto
	 * @return String
	 */
	public String cadastro(){
		return IOutcome.CADASTRO;
	}
	
	/**
	 * Retorna o nome da pagina que o usuário solicitou
	 * @author Joaquim Neto
	 * @return String
	 */
	public String acompanhamento(){
		return IOutcome.ACOMPANHAMENTO;
	}
	
	/**
	 * Retorna o nome da pagina que o usuário solicitou
	 * @author Joaquim Neto
	 * @return String
	 */
	public String meuPerfil(){
		return IOutcome.MEU_PERFIL;
	}

	/**
	 * Retorna o nome da pagina que o usuário solicitou
	 * @author Joaquim Neto
	 * @return String
	 */
	public String sair(){
		return IOutcome.SAIR;
	}

	
}
