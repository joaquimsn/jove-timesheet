package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.domain.service.EmpresaService;

@ManagedBean
@ViewScoped
public class EmpresaBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -4308003149561237529L;
	
	private Empresa empresaSelecionada;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina empresa
	 * @author Joaquim Neto
	 */
	
	@Override
	public void inicializarPagina() {
		empresaSelecionada = new Empresa();
	}
	
	/**
	 * Zera os atributos da empresa fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		empresaSelecionada = new Empresa();
	}
	
	/**
	 * Cadastra a empresa e limpa os campos
	 * @author Joaquim Neto
	 */
	public void cadastrar() {
		
		//Remover só teste o setCidade e setUf
		empresaSelecionada.setCidade("São Paulo");
		empresaSelecionada.setUf("SP");
		empresaSelecionada.setIdUsuario(1);
		
		empresaSelecionada.setAtivo(true);
		empresaSelecionada.setDataCadastro(new Date());
		empresaSelecionada.setDataManutencao(new Date());
		new EmpresaService().cadastrar(getEmpresaSelecionada());
		limparCampos();
	}
	
	/**
	 * @author Joaquim Neto
	 * @param empresaSelecionada the empresaSelecionada to set
	 */
	public void setEmpresaSelecionada(Empresa empresa) {
		empresaSelecionada = empresa;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the empresaSelecionada
	 */
	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

}
