package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Atividade;

@ManagedBean
@ViewScoped
public class AtividadeBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -4624461885675885559L;
	
	private Atividade atividadeSelecionada;

	@Override
	public void inicializarPagina() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void habilitarCampo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasObjetoSelecionado() {
		// TODO Auto-generated method stub
		return false;
	}
	
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
