package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 2160040241309177147L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_departamento")
	private int idDepartamento;
	
	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_manutencao")
	private Date dataManutencao;
	
	@Required(label = "Descrição", minimo = 5) 
	private String descricao;

	@Column(name="id_usuario")
	private int idUsuario;
	
	@Required(label = "Nome Departamento", minimo = 3)
	private String nome;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="departamento")
	private List<Funcionario> listaFuncionarios;

	public Departamento() {
	}

	/**
	 * @return the idDepartamento
	 */
	public int getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
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
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the listaFuncionarios
	 */
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	/**
	 * @param listaFuncionarios the listaFuncionarios to set
	 */
	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDepartamento;
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
		Departamento other = (Departamento) obj;
		if (idDepartamento != other.idDepartamento)
			return false;
		return true;
	}
	
}