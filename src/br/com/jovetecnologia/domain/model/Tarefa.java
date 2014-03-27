package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tarefa database table.
 */
@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tarefa")
	private int idTarefa;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	private String descricao;

	private String nome;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "tarefa")
	private List<Registro> registros;

	// bi-directional many-to-one association to RelAtividadeTarefa
	@OneToMany(mappedBy = "tarefa")
	private List<RelAtividadeTarefa> relAtividadeTarefas;

	public Tarefa() {
	}

	public int getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
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

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setTarefa(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setTarefa(null);

		return registro;
	}

	public List<RelAtividadeTarefa> getRelAtividadeTarefas() {
		return this.relAtividadeTarefas;
	}

	public void setRelAtividadeTarefas(List<RelAtividadeTarefa> relAtividadeTarefas) {
		this.relAtividadeTarefas = relAtividadeTarefas;
	}

	public RelAtividadeTarefa addRelAtividadeTarefa(RelAtividadeTarefa relAtividadeTarefa) {
		getRelAtividadeTarefas().add(relAtividadeTarefa);
		relAtividadeTarefa.setTarefa(this);

		return relAtividadeTarefa;
	}

	public RelAtividadeTarefa removeRelAtividadeTarefa(RelAtividadeTarefa relAtividadeTarefa) {
		getRelAtividadeTarefas().remove(relAtividadeTarefa);
		relAtividadeTarefa.setTarefa(null);

		return relAtividadeTarefa;
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