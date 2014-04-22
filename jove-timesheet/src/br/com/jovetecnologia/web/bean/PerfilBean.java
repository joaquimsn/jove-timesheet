package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.domain.service.UsuarioService;
import br.com.jovetecnologia.infrastructure.util.Criptografia;
import br.com.jovetecnologia.infrastructure.util.IOutcome;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class PerfilBean implements Serializable{

	private static final long serialVersionUID = -6473691824017602880L;

	private boolean readonly;

	private String novaSenha;
	private String senhaAtual;
	private String confirmarSenha;

	private Funcionario funcionario;
	private Usuario usuario;

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
		
		setUsuario(SystemUtils.getUsuarioLogado());
		
		setFuncionario(SystemUtils.getFuncionarioLogado());
		
		setReadonly(true);
		
		limparSenha();
		
	}
	
	private void limparSenha() {
		novaSenha = "";
		senhaAtual = "";
		confirmarSenha = "";
	}
	
	/**
	 * Altera a senha do usuario, fazendo a validação das senhas digitadas.
	 * @author Joaquim Neto
	 */
	public void alterar() {
		if (!validarSenha()) {
			return;
		}

		new UsuarioService().alterar(getUsuario());

		inicializarPagina();

		Messages.addInfo("Dados Alterados com sucesso");
	}
	
	/**
	 * Valida se as senhas informadas são iguais.
	 * @author Joaquim Neto
	 * @return <b>true</b> As senhas informadas forem iguais.
	 */
	public boolean validarSenha() {
		if (getNovaSenha().equals(confirmarSenha)) {
			
			if (!Criptografia.criptografar(senhaAtual).equals(getUsuario().getSenha())) {
				Messages.addError("A senha atual está incorreta");
				return false;
			}
			limparSenha();			
			return true;
		}
		
		Messages.addError("As senhas informadas são diferentes");
		limparSenha();
		return false;
	}

	/**
	 * @author Joaquim Neto
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @author Joaquim Neto
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			this.funcionario = funcionario;
		}
	}

	/**
	 * @author Joaquim Neto
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @author Joaquim Neto
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		if (usuario != null) {
			this.usuario = usuario;
		}
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
		if (novaSenha != null ) {
			this.novaSenha = novaSenha;
		}
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
		if (senhaAtual != null) {
			this.senhaAtual = senhaAtual;
		}
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
		if (confirmarSenha != null) {
			this.confirmarSenha = confirmarSenha;
		}
	}
}
