package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jovetecnologia.domain.enums.NivelUsuarioEnum;
import br.com.jovetecnologia.infrastructure.util.annotation.Required;

/**
 * The persistent class for the usuario database table.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 5309645625068380023L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	@Column(name = "fk_id_usuario")
	private int fkIdUsuario;

	@Required(label = "Login", minimo = 3)
	private String login;

	private int nivel;
	
	@Required(label = "Senha", minimo = 6)
	private String senha;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public Usuario() {
	}

	/**
	 * Verifica se o usuário possuir nível de permissão Administrador
	 * @return <b>true</b> se o usuário possuir nível de permissão Administrador
	 */
	public boolean isAdministrador() {
		if (nivel == NivelUsuarioEnum.ADMINISTRADOR.getValue()) {
			return true;
		}
		return false;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataManutencao
	 */
	public Date getDataManutencao() {
		return dataManutencao;
	}

	/**
	 * @param dataManutencao the dataManutencao to set
	 */
	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	/**
	 * @return the fkIdUsuario
	 */
	public int getFkIdUsuario() {
		return fkIdUsuario;
	}

	/**
	 * @param fkIdUsuario the fkIdUsuario to set
	 */
	public void setFkIdUsuario(int fkIdUsuario) {
		this.fkIdUsuario = fkIdUsuario;
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
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
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

}