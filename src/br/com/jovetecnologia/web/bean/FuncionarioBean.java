package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.enums.ModalidadeContratoEnum;
import br.com.jovetecnologia.domain.enums.NivelUsuarioEnum;
import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Departamento;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.domain.service.DepartamentoService;
import br.com.jovetecnologia.domain.service.FuncionarioService;
import br.com.jovetecnologia.domain.service.UsuarioService;
import br.com.jovetecnologia.infrastructure.util.Criptografia;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class FuncionarioBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = -1348326016045328338L;

	private Funcionario funcionarioSelecionado;
	private Usuario usuarioSelecionado;

	private String senhaAtual;
	private String confirmarSenha;

	private boolean next;
	
	private List<Funcionario> listaFuncionarioFiltrado;
	private List<Funcionario> listaFuncionario;
	private List<Funcionario> listaSupervisor;
	private List<Departamento> listaDepartamento;
	private List<String> listaModalidadeContrato;
	private List<String> listaNivelUsuario;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		funcionarioSelecionado = new Funcionario();
		usuarioSelecionado = new Usuario();
		listaFuncionarioFiltrado = null;

		next = false;
		limparSenha();

		listarTodos();
		setReadonly(false);
	}

	/**
	 * Limpa os campos senha atual e confirmar senha
	 * @author Joaquim Neto
	 */
	private void limparSenha() {
		senhaAtual = "";
		confirmarSenha = "";

	}

	@Override
	public void listarTodos() {
		setListaFuncionario(new FuncionarioService().listarTodos());
		setListaDepartamento(new DepartamentoService().listarTodos());
		setListaSupervisor(new FuncionarioService().listarSupervisor());
		setListaModalidadeContrato(ModalidadeContratoEnum.getDisplayList());
		setListaNivelUsuario(NivelUsuarioEnum.getDisplayList());
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
		funcionarioSelecionado.setCidade("São Paulo");
		funcionarioSelecionado.setUf("SP");

		new FuncionarioService().cadastrar(getFuncionarioSelecionado());

		// Cadastra o Usuario junto como o funcionario
		usuarioSelecionado.setSenha(Criptografia.criptografar(usuarioSelecionado.getSenha()));
		usuarioSelecionado.setFuncionario(getFuncionarioSelecionado());
		
		new UsuarioService().cadastrar(usuarioSelecionado);

		Messages.addInfo("Funcionário cadastrado com sucesso");
		
		inicializarPagina();
	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getFuncionarioSelecionado())
				|| !SystemUtils.isCpfValido(funcionarioSelecionado.getCpf())
				|| !SystemUtils.isCamposObrigatoriosPreenchidos(getUsuarioSelecionado()) || !validarSenha()) {

			return false;
		}
		return true;
	}

	/**
	 * Valida se as senhas informadas são iguais.
	 * @author Joaquim Neto
	 * @return <b>true</b> As senhas informadas forem iguais.
	 */
	public boolean validarSenha() {
//		if (usuarioSelecionado.getSenha().equals(confirmarSenha)) {
//			return true;
//		} //else if (hasObjetoSelecionado() && Criptografia.criptografar(senhaAtual).equals(usuarioSelecionado.getSenha())) {
//			return true;
//		}
		
		//remover 
//
//		Messages.addError("As senhas informadas são diferentes");
//
//		return false;
		return true;
	}

	@Override
	public void alterar() {

		if (!validar()) {
			return;
		}

		// Remover só teste o setCidade e setUf
		funcionarioSelecionado.setCidade("São Paulo");
		funcionarioSelecionado.setUf("SP");

		new FuncionarioService().alterar(getFuncionarioSelecionado());

		Messages.addInfo("Funcionário alterado com sucesso");
		
		inicializarPagina();

	}

	/**
	 * Ativar ou inativa o funcionário como base no método <b>isAtivo</b> se <b>true</b> será alterado para inativo
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario
	 */
	public void ativarOuInativar(Funcionario funcionario) {

		StringBuilder info = new StringBuilder("O funcionário ");
		info.append(funcionario.getNome()).append(" foi ");

		if (funcionario.isAtivo()) {
			info.append("inativado com sucesso");
			funcionario.setAtivo(false);
		} else {
			info.append("ativado com sucesso");
			funcionario.setAtivo(true);
		}

		new FuncionarioService().ativarOuInativar(funcionario);

		Messages.addInfo(info.toString());
		listarTodos();
	}

	/**
	 * Responsável pela flag de troca de pagina 
	 * @author Joaquim Neto
	 */
	public void mudarPagina() {
		if (next) {
			setNext(false);
		} else {
			setNext(true);
		}
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (funcionarioSelecionado.getIdUsuario() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * @author Joaquim Neto
	 * @return the funcionarioSelecionado
	 */
	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionarioSelecionado the funcionarioSelecionado to set
	 */
	public void setFuncionarioSelecionado(Funcionario funcionario) {
		if (funcionario != null && !isReadonly() && funcionarioSelecionado != funcionario) {
			funcionarioSelecionado = funcionario;
			setReadonly(true);
		} else if (isReadonly() && hasObjetoSelecionado()) {
			funcionarioSelecionado = funcionario;
			setReadonly(true);
		}
		if (hasObjetoSelecionado()) {
			setUsuarioSelecionado(new UsuarioService().pesquisarPorFuncionario(getFuncionarioSelecionado()));
		}

	}

	/**
	 * @author Joaquim Neto
	 * @return the usuarioSelecionado
	 */
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param usuarioSelecionado the usuarioSelecionado to set
	 */
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the senhaAtual
	 */
	public String getSenhaAtual() {
		return senhaAtual;
	}

	/**
	 * @author Joaquim Neto
	 * @param senhaAtual the senhaAtual to set
	 */
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	/**
	 * @author Joaquim Neto
	 * @return the confirmarSenha
	 */
	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	/**
	 * @author Joaquim Neto
	 * @param confirmarSenha the confirmarSenha to set
	 */
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	/**
	 * @author Joaquim Neto
	 * @return the next
	 */
	public boolean isNext() {
		return next;
	}

	/**
	 * @author Joaquim Neto
	 * @param next the next to set
	 */
	public void setNext(boolean next) {
		this.next = next;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaFuncionario
	 */
	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaFuncionario the listaFuncionario to set
	 */
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
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
	 * @return the listaFuncionarioFiltrado
	 */
	public List<Funcionario> getListaFuncionarioFiltrado() {
		return listaFuncionarioFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaFuncionarioFiltrado the listaFuncionarioFiltrado to set
	 */
	public void setListaFuncionarioFiltrado(List<Funcionario> listaFuncionarioFiltrado) {
		this.listaFuncionarioFiltrado = listaFuncionarioFiltrado;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaSupervisor
	 */
	public List<Funcionario> getListaSupervisor() {
		return listaSupervisor;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaSupervisor the listaSupervisor to set
	 */
	public void setListaSupervisor(List<Funcionario> listaSupervisor) {
		this.listaSupervisor = listaSupervisor;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaModalidadeContrato
	 */
	public List<String> getListaModalidadeContrato() {
		return listaModalidadeContrato;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaModalidadeContrato the listaModalidadeContrato to set
	 */
	public void setListaModalidadeContrato(List<String> listaModalidadeContrato) {
		this.listaModalidadeContrato = listaModalidadeContrato;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaNivelUsuario
	 */
	public List<String> getListaNivelUsuario() {
		return listaNivelUsuario;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaNivelUsuario the listaNivelUsuario to set
	 */
	public void setListaNivelUsuario(List<String> listaNivelUsuario) {
		this.listaNivelUsuario = listaNivelUsuario;
	}

}
