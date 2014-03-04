package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.domain.service.EmpresaService;
import br.com.jovetecnologia.infrastructure.util.Messages;

@ManagedBean
@ViewScoped
public class EmpresaBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -4308003149561237529L;
	
	private Empresa empresaSelecionada;
	private List<Empresa> listaEmpresa;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina empresa
	 * @author Joaquim Neto
	 */
	
	@PostConstruct
	public void inicializarPagina() {
		empresaSelecionada = new Empresa();
	}
	
	/**
	 * Zera os atributos da empresa fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	public void limparCampos() {
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
		empresaSelecionada.setDataManutencao(new Date());
		new EmpresaService().cadastrar(getEmpresaSelecionada());
		limparCampos();
		
		Messages.addInfo("Empresa Cadastrada com sucesso!");
	}
	
	/**
	 * Lista de todas as empresas
	 * @author Joaquim Neto
	 * @return List de empresas
	 */
	private List<Empresa> listarTodos() {
		listaEmpresa = new EmpresaService().listarTodos();
		return listaEmpresa;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return
	 */
	public boolean hasEmpresaSelecionada() {
		if (empresaSelecionada.getRazaoSocial() == null) {
			return false;
		}
		
		return true;
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

	/**
	 * @author Joaquim Neto
	 * @return the listaEmpresa
	 */
	public List<Empresa> getListaEmpresa() {
		return listarTodos();
	}

	/**
	 * @author Joaquim Neto
	 * @param listaEmpresa the listaEmpresa to set
	 */
	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

}
