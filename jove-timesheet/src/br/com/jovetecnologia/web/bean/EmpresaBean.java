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
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class EmpresaBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = -4308003149561237529L;
	
	private Empresa empresaSelecionada;
	private List<Empresa> listaEmpresa;
	private List<Empresa> empresasFiltradas;
	private boolean readonly;
	
	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina empresa
	 * @author Joaquim Neto
	 */
	
	@PostConstruct
	public void inicializarPagina() {
		empresaSelecionada = new Empresa();
		setReadonly(false);
		listarTodos();
	}

	
	public void habilitarCampo() {
		setReadonly(false);
	}
	
	/**
	 * Cadastra a empresa e limpa os campos
	 * @author Joaquim Neto
	 */
	public void cadastrar() {
		
		if(!validar()){
			return;
		}
		
		//Remover só teste o setCidade e setUf
		empresaSelecionada.setCidade("São Paulo");
		empresaSelecionada.setUf("SP");
		empresaSelecionada.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		empresaSelecionada.setAtivo(true);
		empresaSelecionada.setDataManutencao(new Date());
		new EmpresaService().cadastrar(getEmpresaSelecionada());
		inicializarPagina();
		
		Messages.addInfo("Empresa Cadastrada com sucesso!");
	}
	
	/**
	 * @author Joaquim Neto
	 * @return
	 */
	private boolean validar() {
		if(!SystemUtils.isCamposObrigatoriosPreenchidos(empresaSelecionada)) {
			return false;
		}
		return true;
	}

	/**
	 * Persiste a empresa alterada na base e limpa os campos;
	 * @author Joaquim Neto
	 */
	public void alterar() {
		empresaSelecionada.setCidade("São Paulo");
		empresaSelecionada.setUf("SP");
		
		new EmpresaService().alterar(getEmpresaSelecionada());
		inicializarPagina();
		
		Messages.addInfo("Empresa Alterada com sucesso!");
	}
	
	/**
	 * Retorna true se existir empresa selecionada, caso contrario retorna false
	 * @author Joaquim Neto
	 * @return <b>true</b> Se tiver empresa selecionado
	 */
	public boolean hasEmpresaSelecionada() {
		if (empresaSelecionada.getIdUsuario() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Lista de todas as empresas
	 * @author Joaquim Neto
	 * @return List de empresas
	 */
	private void listarTodos() {
		setListaEmpresa(new EmpresaService().listarTodos());
	}

	/**
	 * @author Joaquim Neto
	 * @param empresaSelecionada the empresaSelecionada to set
	 */
	public void setEmpresaSelecionada(Empresa empresa) {
		if(empresa != null && empresaSelecionada.getIdUsuario() == 0) {
			empresaSelecionada = empresa;
			
			if(hasEmpresaSelecionada()) {
				setReadonly(true);
			} else {
				setReadonly(false);
			}
			
		}
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
		return listaEmpresa;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaEmpresa the listaEmpresa to set
	 */
	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	/**
	 * @author Joaquim NetohasEmpresaSelecionada()
	 * @return the empresasFiltradas
	 */
	public List<Empresa> getEmpresasFiltradas() {
		return empresasFiltradas;
	}

	/**
	 * @author Joaquim Neto
	 * @param empresasFiltradas the empresasFiltradas to set
	 */
	public void setEmpresasFiltradas(List<Empresa> empresasFiltradas) {
		this.empresasFiltradas = empresasFiltradas;
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
