package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import br.com.jovetecnologia.domain.enums.NivelUsuarioEnum;

/**
 * The persistent class for the usuario database table.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3198675969842101851L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@Column(name="ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	private int nivel;

	private String senha;
	
	@Column(name = "usuario")
	private String login;

	// bi-directional one-to-one association to Funcionario
	@OneToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public Usuario() {
	}

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @return the ativo
	 */
	public boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * Verifica se o usuário possuir nível de permissão Administrador
	 * @return <b>true</b> se o usuário possuir nível de permissão Administrador
	 */
	public boolean isAdministrador() {
		if(nivel == NivelUsuarioEnum.ADMINISTRADOR.getValue()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		return true;
	}

}