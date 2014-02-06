package br.com.jovetecnologia.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.web.util.IOutcome;

@ManagedBean
@ViewScoped
public class CadastroBean {
	
	public String abrirPagina(){
		return null;
	}
	
	public String tituloDaPagina(){
		return IOutcome.TITULO_CADASTRO;
	}
}
