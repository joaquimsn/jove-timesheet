package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class ComporProjetoBean implements Serializable{

	private static final long serialVersionUID = 7237727711358695530L;
	
	private boolean readonly;

	/**
	 * Abre a tela de compor projeto
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada pelo cliente
	 */
	public String abrirPagina() {
		return IOutcome.COMPORPROJETO;
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
