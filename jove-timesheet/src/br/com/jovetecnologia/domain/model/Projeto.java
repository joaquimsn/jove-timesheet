package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the projeto database table.
 */
@Entity
@Table(name = "projeto")
@NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p")
public class Projeto implements Serializable {

	private static final long serialVersionUID = -7301561406528812734L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_projeto")
	private int idProjeto;

	private byte ativo;

	private String descricao;

	private String nome;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "projeto")
	private List<Registro> registros;

	public Projeto() {
	}

	/**
	 * @return the idProjeto
	 */
	public int getIdProjeto() {
		return idProjeto;
	}

	/**
	 * @param idProjeto the idProjeto to set
	 */
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	/**
	 * @return the ativo
	 */
	public byte getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the registros
	 */
	public List<Registro> getRegistros() {
		return registros;
	}

	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProjeto;
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
		Projeto other = (Projeto) obj;
		if (idProjeto != other.idProjeto)
			return false;
		return true;
	}

}