package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the registro database table.
 * 
 */
@Entity
@Table(name="registro")
@NamedQuery(name="Registro.findAll", query="SELECT r FROM Registro r")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_registro")
	private int idRegistro;

	private int aprovado;

	@Temporal(TemporalType.DATE)
	@Column(name="data_acatamento")
	private Date dataAcatamento;

	@Temporal(TemporalType.DATE)
	@Column(name="data_registro")
	private Date dataRegistro;

	private Time fim;

	private Time inicio;

	private String observacao;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="id_projeto")
	private Projeto projeto;

	//bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name="id_atividade")
	private Atividade atividade;

	//bi-directional many-to-one association to Tarefa
	@ManyToOne
	@JoinColumn(name="id_tarefa")
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

	public Date getDataAcatamento() {
		return this.dataAcatamento;
	}

	public void setDataAcatamento(Date dataAcatamento) {
		this.dataAcatamento = dataAcatamento;
	}

	public Date getDataRegistro() {
		return this.dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Time getFim() {
		return this.fim;
	}

	public void setFim(Time fim) {
		this.fim = fim;
	}

	public Time getInicio() {
		return this.inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}