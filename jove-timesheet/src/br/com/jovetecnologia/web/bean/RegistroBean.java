package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class RegistroBean implements Serializable {
	
	private static final long serialVersionUID = -1183856785057134758L;
	
	private boolean calendario;//Refazer só teste
	
	public RegistroBean(){
		calendario = false;
	}
	
	/**
	 * Inicializa os objetos necessario para o funcionamento da pagina
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada pelo cliente
	 */
	public String abrirPagina(){
		
		return IOutcome.REGISTRO;
	}
	
	/**
	 * Define o estado da pagina calendario, quando for false exibe a tela principal,
	 * true exibe a tela de registro
	 * @author Joaquim Neto
	 */
	public void setarCalendario() {
		if(calendario) {
			calendario = false;
		} else {
			calendario =  true;
		}
	}

	/**
	 * REFAZER só teste
	 * @return the calendario
	 */
	public boolean isCalendario() {
		return calendario;
	}

	/**
	 * REFAZER só teste
	 * @param calendario the calendario to set
	 */
	public void setCalendario(boolean calendario) {
		this.calendario = calendario;
	}
	


}
