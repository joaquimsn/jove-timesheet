package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Departamento;
import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.domain.service.DepartamentoService;
import br.com.jovetecnologia.domain.service.EmpresaService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class DepartamentoBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -3779041589727892789L;

	private Departamento departamentoSelecionado;
	private List<Empresa> listaEmpresa;
	private List<Departamento> listaDepartamento;
	private List<Departamento> listaDepartamentoFiltrado;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		departamentoSelecionado = new Departamento();
		setReadonly(false);
		listarTodos();
	}

	@Override
	public void listarTodos() {
		setListaDepartamento(new DepartamentoService().listarTodos());
		setListaEmpresa(new EmpresaService().listarTodos());
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
		
		new DepartamentoService().cadastrar(departamentoSelecionado);
		inicializarPagina();
		Messages.addInfo("Departamento cadastradado com sucesso");
	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getDepartamentoSelecionado())) {
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}	
		
		departamentoSelecionado.setAtivo(true);
		new DepartamentoService().alterar(getDepartamentoSelecionado());
		Messages.addInfo("Departamento alterado com sucesso");
	}
	
	/**
	 * Ativar ou inativa o departamento como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param departamento Objeto departamento
	 */
	public void ativarOuInativar(Departamento departamento) {

		StringBuilder info = new StringBuilder("O departamento ");
		info.append(departamento.getNome()).append(" foi ");

		if (departamento.isAtivo()) {
			info.append("inativado com sucesso");
			departamento.setAtivo(false);
		} else {
			info.append("ativado com sucesso");
			departamento.setAtivo(true);
		}

		new DepartamentoService().alterar(departamento);

		Messages.addInfo(info.toString());
		listarTodos();
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (getDepartamentoSelecionado().getIdUsuario() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * @author Joaquim Neto
	 * @return the departamentoSelecionado
	 */
	public Departamento getDepartamentoSelecionado() {
		return departamentoSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param departamentoSelecionado the departamento to set
	 */
	public void setDepartamentoSelecionado(Departamento departamento) {
		if (departamento != null) {
			this.departamentoSelecionado = departamento;
		} else if (isReadonly() && hasObjetoSelecionado()) {
			this.departamentoSelecionado = departamento;
		}		
		if (hasObjetoSelecionado()) {
			setReadonly(true);
		} else {
			setReadonly(false);
		}
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaDepartamentoFiltrado
	 */
	public List<Departamento> getListaDepartamentoFiltrado() {
		return listaDepartamentoFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaDepartamentoFiltrado the listaDepartamentoFiltrado to set
	 */
	public void setListaDepartamentoFiltrado(List<Departamento> listaDepartamentoFiltrado) {
		this.listaDepartamentoFiltrado = listaDepartamentoFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaDepartamento
	 */
	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaDepartamento the listaDepartamento to set
	 */
	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
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

}
