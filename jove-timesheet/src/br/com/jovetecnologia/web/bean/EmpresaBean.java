package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.domain.model.Endereco;
import br.com.jovetecnologia.domain.service.EmpresaService;
import br.com.jovetecnologia.domain.service.EnderecoService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class EmpresaBean extends CadastroBean implements Serializable, ICrudBean {
	
	private static final long serialVersionUID = 1163863445999964629L;
	
	private Empresa empresaSelecionada;
	
	private Endereco endereco;
	
	private List<Empresa> listaEmpresa;
	private List<Empresa> listaEmpresaFiltrada;
	
	private List<String> listaUf;
	private List<String> listaCidade;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		empresaSelecionada = new Empresa();
		setReadonly(false);
		listarTodos();
	}

	@Override
	public void habilitarCampo() {
		setReadonly(false);
	}

	@Override
	public void cadastrar() {

		if (!validar()) {
			return;
		}

		// Remover só teste o setCidade e setUf
		empresaSelecionada.setCidade("São Paulo");
		empresaSelecionada.setUf("SP");
		
		new EmpresaService().cadastrar(getEmpresaSelecionada());
		inicializarPagina();

		Messages.addInfo("Empresa Cadastrada com sucesso");
	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(empresaSelecionada)
				|| !SystemUtils.isCnpjValido(empresaSelecionada.getCnpj())) {
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}

		empresaSelecionada.setCidade("São Paulo");
		empresaSelecionada.setUf("SP");
		empresaSelecionada.setAtivo(true);
		
		new EmpresaService().alterar(getEmpresaSelecionada());
		inicializarPagina();

		Messages.addInfo("Empresa Alterada com sucesso!");
	}

	/**
	 * Ativar ou inativa a empresa como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param empresa Objeto empresa
	 */
	public void ativarOuInativar(Empresa empresa) {

		StringBuilder info = new StringBuilder("A empresa ");
		info.append(empresa.getRazaoSocial()).append(" foi ");

		if (empresa.isAtivo()) {
			info.append("inativada com sucesso");
			empresa.setAtivo(false);
		} else {
			info.append("ativada com sucesso");
			empresa.setAtivo(true);
		}

		new EmpresaService().ativarOuInativar(empresa);

		Messages.addInfo(info.toString());
		listarTodos();
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (empresaSelecionada.getUsuarioModificador() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Pesquisa o cep na base, se existir preenche os campos logradouro, bairro, cidade, uf automaticamente
	 * @author Joaquim Neto
	 */
	public void consultarCep() {
		if (empresaSelecionada.getCep() != "") {
			endereco = new EnderecoService().obterEnderecoPorCep(empresaSelecionada.getCep());
			
			empresaSelecionada.setLogradouro(endereco.getLogradouro());
			empresaSelecionada.setBairro(endereco.getBairro());
			empresaSelecionada.setUf(endereco.getUf());
			empresaSelecionada.setCidade(endereco.getCidade());
		}
	}

	/**
	 * Lista de todas as empresas
	 * @author Joaquim Neto
	 * @return List de empresas
	 */
	@Override
	public void listarTodos() {
		setListaEmpresa(new EmpresaService().listarTodos());
		
		setListaUf(new EnderecoService().listarUf());
		setListaCidade(new EnderecoService().listarCidadePorUf(empresaSelecionada.getUf()));
	}

	/**
	 * @author Joaquim Neto
	 * @param empresaSelecionada the empresaSelecionada to set
	 */
	public void setEmpresaSelecionada(Empresa empresa) {
		if (empresa != null) {
			empresaSelecionada = empresa;

		} else if (isReadonly() && hasObjetoSelecionado()) {
			empresaSelecionada = empresa;
		}

		if (hasObjetoSelecionado()) {
			setReadonly(true);
		} else {
			setReadonly(false);
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
	 * @author Joaquim Netohas
	 * @return the listaAmpresaFiltrada
	 */
	public List<Empresa> getListaEmpresaFiltrada() {
		return listaEmpresaFiltrada;
	}

	/**
	 * @author Joaquim Neto
	 * @param empresaFiltrada the listaEmpresaFiltrada to set
	 */
	public void setListaEmpresaFiltrada(List<Empresa> empresaFiltrada) {
		this.listaEmpresaFiltrada = empresaFiltrada;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the listaUf
	 */
	public List<String> getListaUf() {
		return listaUf;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaUf the listaUf to set
	 */
	public void setListaUf(List<String> listaUf) {
		this.listaUf = listaUf;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaCidade
	 */
	public List<String> getListaCidade() {
		if(empresaSelecionada.getUf() != "") {
			return new EnderecoService().listarCidadePorUf(empresaSelecionada.getUf());
		}
		
		return listaCidade;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaCidade the listaCidade to set
	 */
	public void setListaCidade(List<String> listaCidade) {
		this.listaCidade = listaCidade;
	}

}
