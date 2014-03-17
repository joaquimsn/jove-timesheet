package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.domain.service.PerfilService;
import br.com.jovetecnologia.infrastructure.util.Criptografia;
import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.Messages;

@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable{

	private static final long serialVersionUID = -6473691824017602880L;

	private boolean readonly;

	private String novaSenha;
	private String senhaAtual;
	private String confirmarSenha;

	private Funcionario funcionarioSelecionado;
	private Usuario usuarioSelecionado;

	/**
	 * Abre a pagina meuperfil
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada
	 */
	public String abrirPagina() {
		return IOutcome.MEU_PERFIL;
	}

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina
	 * @author Joaquim Neto
	 */
	@PostConstruct
	public void inicializarPagina() {
		PerfilService perfilService = new PerfilService();
		
		setUsuarioSelecionado(perfilService.obterUsuario());
		
		setFuncionarioSelecionado(perfilService.obterFuncionario());
		
		setReadonly(true);
	}
	
	/**
	 * Altera a senha do usuario, fazendo a validação das senhas digitadas.
	 * @author Joaquim Neto
	 */
	public void alterar() {
		if (!validarSenha()) {
			return;
		}

		new PerfilService().alterar(getUsuarioSelecionado());

		inicializarPagina();

		Messages.addInfo("Dados Alterados com sucesso");
	}

	/**
	 * Valida se as senhas informadas são iguais.
	 * @author Joaquim Neto
	 * @return <b>true</b> As senhas informadas forem iguais.
	 */
	public boolean validarSenha() {
		if (getSenhaAtual().equals(confirmarSenha)) {
			
			if (!Criptografia.criptografar(senhaAtual).equals(usuarioSelecionado.getSenha())) {
				Messages.addError("A senha atual está incorreta");
				return false;
			}
			
			return true;
		}
		
		Messages.addError("As senhas informadas são diferentes");

		return false;
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
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
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

	/**
	 * @author Joaquim Neto
	 * @return the novaSenha
	 */
	public String getNovaSenha() {
		return novaSenha;
	}

	/**
	 * @author Joaquim Neto
	 * @param novaSenha the novaSenha to set
	 */
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
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
}
