package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the registro database table.
 */
@Entity
@Table(name = "registro")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_fim")
	private Date horaFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicio")
	private Date horaInicio;

	private String observacao;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

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

	public int getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public int getAprovado() {
		return this.aprovado;
	}

	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
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

	public Date getDataAcatamento() {
		return this.dataAcatamento;
	}

	public void setDataAcatamento(Date dataAcatamento) {
		this.dataAcatamento = dataAcatamento;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return this.dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Date getDataRegistro() {
		return this.dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getHoraFim() {
		return this.horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getUsuarioModificador() {
		return this.usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

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