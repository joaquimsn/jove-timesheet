package br.com.jovetecnologia.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.enums.EscopoEnum;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class AcompanhamentoBean {
	
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionario;
	private List<String> listaEscopo;
	private int escopoSelecionado;
	
	/**
	 * Abri a pagina acompanhamento
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada
	 */
	public String abrirPagina(){
		return IOutcome.ACOMPANHAMENTO;
	}
	
	@PostConstruct
	public void inicializarPagina() {
		funcionario = new Funcionario();
		listaFuncionario = new ArrayList<Funcionario>();
		setListaEscopo(EscopoEnum.getDisplayList());
				
	    // TODO Caguei aqui, favor limpar	
		String[] nomes =  {"Joaquim", "Nicolas", "Renan", "Neto", "Baggio", "Carlos", "Verissimo", "Pedro", "Marcos", "Maria" };
		
		for(int i = 0; i < 10; i++){
			funcionario = new Funcionario();
			double aleatorio = Math.random() * 10;
			
			String numero = "" + aleatorio;
			
			funcionario.setNome(nomes[i]);
			funcionario.setNumero(numero);
			
			listaFuncionario.add(funcionario);
			
		}
		
		limpar();
		
	}
	
	/** REFAZER só Testepri
	 * @author Joaquim Neto
	 */
	public void limpar(){
		funcionario = new Funcionario();
	}
	
	public boolean isFuncionarioSelecionado(){
		
//		if (funcionario.getNome() == null){
//			return false;
//		}
		
		return false;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}


	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the listaFuncionario
	 */
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	/**
	 * @param listaFuncionario the listaFuncionario to set
	 */
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	/**
	 * @return the listaEscopo
	 */
	public List<String> getListaEscopo() {
		return listaEscopo;
	}

	/**
	 * @param listaEscopo the listaEscopo to set
	 */
	public void setListaEscopo(List<String> listaEscopo) {
		this.listaEscopo = listaEscopo;
	}

	/**
	 * @return the escopoSelecionado
	 */
	public int getEscopoSelecionado() {
		return escopoSelecionado;
	}

	/**
	 * @param escopoSelecionado the escopoSelecionado to set
	 */
	public void setEscopoSelecionado(int escopoSelecionado) {
		this.escopoSelecionado = escopoSelecionado;
	}
	

}
