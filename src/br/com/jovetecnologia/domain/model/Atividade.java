package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the atividade database table.
 */
@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {
	private static final long serialVersionUID = -2928312462548852293L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_atividade")
	private int idAtividade;

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;
	
	@Required(label = "Descrição", minimo = 5)
	private String descricao;

	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Required(label = "Nome", minimo = 5)
	private String nome;

	// bi-directional many-to-one association to AtividadeTarefa
	@OneToMany(mappedBy = "atividade")
	private List<AtividadeTarefa> listaAtividadeTarefas;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "atividade")
	private List<Registro> listaRegistros;

	public Atividade() {
	}

	/**
	 * @return the idAtividade
	 */
	public int getIdAtividade() {
		return idAtividade;
	}

	/**
	 * @param idAtividade the idAtividade to set
	 */
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
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
	 * @return the listaAtividadeTarefas
	 */
	public List<AtividadeTarefa> getListaAtividadeTarefas() {
		return listaAtividadeTarefas;
	}

	/**
	 * @param listaAtividadeTarefas the listaAtividadeTarefas to set
	 */
	public void setListaAtividadeTarefas(List<AtividadeTarefa> listaAtividadeTarefas) {
		this.listaAtividadeTarefas = listaAtividadeTarefas;
	}

	/**
	 * @return the listaRegistros
	 */
	public List<Registro> getListaRegistros() {
		return listaRegistros;
	}

	/**
	 * @param listaRegistros the listaRegistros to set
	 */
	public void setListaRegistros(List<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAtividade;
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
		Atividade other = (Atividade) obj;
		if (idAtividade != other.idAtividade)
			return false;
		return true;
	}

}