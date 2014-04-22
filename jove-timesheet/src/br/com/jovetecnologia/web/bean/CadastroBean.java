package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1649345586752199997L;
	
	private boolean readonly;

	/**
	 * Abre a tela de cadastro
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada pelo cliente
	 */
	public String abrirPagina() {
		return IOutcome.CADASTRO;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the readonly
	 */
	public boolean isReadonly() {
		return readonly;
	}

	/**
	 * @author Joaquim Neto
	 * @param readonly the readonly to set
	 */
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

}
