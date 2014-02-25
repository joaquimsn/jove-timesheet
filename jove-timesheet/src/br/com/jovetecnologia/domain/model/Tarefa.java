package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the tarefa database table.
 */
@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 8979888423992685324L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tarefa")
	private int idTarefa;

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	private String descricao;

	private String nome;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "tarefa")
	private List<Registro> registros;

	public Tarefa() {
	}

	/**
	 * @return the idTarefa
	 */
	public int getIdTarefa() {
		return idTarefa;
	}

	/**
	 * @param idTarefa the idTarefa to set
	 */
	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
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
		result = prime * result + idTarefa;
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
		Tarefa other = (Tarefa) obj;
		if (idTarefa != other.idTarefa)
			return false;
		return true;
	}

}