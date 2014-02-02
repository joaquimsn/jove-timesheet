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

	private static final long serialVersionUID = 7418838017608429704L;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aprovado;
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((dataAcatamento == null) ? 0 : dataAcatamento.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + idRegistro;
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((tarefa == null) ? 0 : tarefa.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (aprovado != other.aprovado)
			return false;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (dataAcatamento == null) {
			if (other.dataAcatamento != null)
				return false;
		} else if (!dataAcatamento.equals(other.dataAcatamento))
			return false;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idRegistro != other.idRegistro)
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (tarefa == null) {
			if (other.tarefa != null)
				return false;
		} else if (!tarefa.equals(other.tarefa))
			return false;
		return true;
	}

}