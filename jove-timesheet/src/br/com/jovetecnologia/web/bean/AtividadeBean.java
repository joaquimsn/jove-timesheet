package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Atividade;

@ManagedBean
@ViewScoped
public class AtividadeBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -4624461885675885559L;

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Atividade
	 * @author Joaquim Neto
	 */
	
		
	@PostConstruct
	public void inicializarComponentes() {
		
	}
	
	/**
	 * Zera os atributos da pagina Atividade fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		atividadeSelecionada = new Atividade();
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the atividadeSelecionada
	 */
	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeSelecionada the atividadeSelecionada to set
	 */
	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}
}