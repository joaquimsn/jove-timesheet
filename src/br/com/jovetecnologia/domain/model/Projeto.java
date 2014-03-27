package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the projeto database table.
 */
@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = -5387120707045799384L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_projeto")
	private int idProjeto;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_fim")
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	@Required(label = "Descrição", minimo = 5)
	private String descricao;

	@Required(label = "Nome", minimo = 3)
	private String nome;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "projeto")
	private List<Registro> registros;

	// bi-directional many-to-one association to RelProjetoAtividade
	@OneToMany(mappedBy = "projeto")
	private List<RelProjetoAtividade> relProjetoAtividades;

	// bi-directional many-to-one association to RelProjetoFuncionario
	@OneToMany(mappedBy = "projeto")
	private List<RelProjetoFuncionario> relProjetoFuncionarios;

	public Projeto() {
	}

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	/**
	 * @author Joaquim Neto
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @author Joaquim Neto
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataManutencao() {
		return this.dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUsuarioModificador() {
		return this.usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<RelProjetoAtividade> getRelProjetoAtividades() {
		return this.relProjetoAtividades;
	}

	public void setRelProjetoAtividades(List<RelProjetoAtividade> relProjetoAtividades) {
		this.relProjetoAtividades = relProjetoAtividades;
	}

	public List<RelProjetoFuncionario> getRelProjetoFuncionarios() {
		return this.relProjetoFuncionarios;
	}

	public void setRelProjetoFuncionarios(List<RelProjetoFuncionario> relProjetoFuncionarios) {
		this.relProjetoFuncionarios = relProjetoFuncionarios;
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