package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;

/**
 * The persistent class for the registro database table.
 */
@Entity
@Table(name = "registro")
public class Registro implements Serializable {
	private static final long serialVersionUID = 8578478159773527453L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_registro")
	private int idRegistro;

	private int aprovado;

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_acatamento")
	private Date dataAcatamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_registro")
	private Date dataRegistro;

	private Time fim;

	@Column(name = "id_usuario")
	private int idUsuario;

	private Time inicio;

	private String observacao;

	// bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	// bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;

	// bi-directional many-to-one association to Tarefa
	@ManyToOne
	@JoinColumn(name = "id_tarefa")
	private Tarefa tarefa;

	public Registro() {
	}

	/**
	 * @return the idRegistro
	 */
	public int getIdRegistro() {
		return idRegistro;
	}

	/**
	 * @param idRegistro the idRegistro to set
	 */
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	/**
	 * @return the aprovado
	 */
	public int getAprovado() {
		return aprovado;
	}

	/**
	 * @param aprovado the aprovado to set
	 */
	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
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
	 * @return the dataAcatamento
	 */
	public Date getDataAcatamento() {
		return dataAcatamento;
	}

	/**
	 * @param dataAcatamento the dataAcatamento to set
	 */
	public void setDataAcatamento(Date dataAcatamento) {
		this.dataAcatamento = dataAcatamento;
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
	 * @return the dataRegistro
	 */
	public Date getDataRegistro() {
		return dataRegistro;
	}

	/**
	 * @param dataRegistro the dataRegistro to set
	 */
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	/**
	 * @return the fim
	 */
	public Time getFim() {
		return fim;
	}

	/**
	 * @param fim the fim to set
	 */
	public void setFim(Time fim) {
		this.fim = fim;
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
	 * @return the inicio
	 */
	public Time getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the atividade
	 */
	public Atividade getAtividade() {
		return atividade;
	}

	/**
	 * @param atividade the atividade to set
	 */
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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
	 * @return the projeto
	 */
	public Projeto getProjeto() {
		return projeto;
	}

	/**
	 * @param projeto the projeto to set
	 */
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	/**
	 * @return the tarefa
	 */
	public Tarefa getTarefa() {
		return tarefa;
	}

	/**
	 * @param tarefa the tarefa to set
	 */
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRegistro;
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
		Registro other = (Registro) obj;
		if (idRegistro != other.idRegistro)
			return false;
		return true;
	}
}