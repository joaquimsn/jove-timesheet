package br.com.jovetecnologia.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class PerfilBean {

	/**
	 * Abri a pagina meuperfil
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada
	 */
	public String abrirPagina() {
		return IOutcome.MEU_PERFIL;
	}
}
