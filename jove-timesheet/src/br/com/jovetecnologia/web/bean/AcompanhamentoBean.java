package br.com.jovetecnologia.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.web.util.IOutcome;

@ManagedBean
@SessionScoped
public class AcompanhamentoBean {
	
	private Funcionario funcionario;
	private List<Funcionario> listaFuncionario;
	
	/**
	 * Refazer esse metodo, só teste
	 * @author Joaquim Neto
	 */
	public AcompanhamentoBean(){
		listaFuncionario = new ArrayList<Funcionario>();
		
		String[] nomes =  {"Joaquim", "Nicolas", "Renan", "Neto", "Baggio", "Carlos", "Verissimo", "Pedro", "Marcos", "Maria" };
		
		for(int i = 0; i < 10; i++){
			funcionario = new Funcionario();
			double aleatorio = Math.random() * 10;
			
			String numero = "" + aleatorio;
			
			funcionario.setNome(nomes[i]);
			funcionario.setNumero(numero);
			
			listaFuncionario.add(funcionario);
			
		}
		
	}
	
	/**
	 * Responsavel por instanciar os objetos e variaveis essenciais para pagina
	 * 
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada
	 */
	public String abrirPagina(){
		funcionario = new Funcionario();
		listaFuncionario = new ArrayList<Funcionario>();
		
		return IOutcome.ACOMPANHAMENTO;
	}
	
	public boolean hasFuncionarioSelecionado(){
		
		if (funcionario.getNome().equals("")){
			return false;
		}
		
		return true;
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
	

}
