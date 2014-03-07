package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the atividade_tarefa database table.
 */
@Entity
@Table(name = "atividade_tarefa")
public class AtividadeTarefa implements Serializable {
	private static final long serialVersionUID = 6875222893306252941L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_atividade_tarefa")
	private int idAtividadeTarefa;

	// bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;

	// bi-directional many-to-one association to Tarefa
	@ManyToOne
	@JoinColumn(name = "id_tarefa")
	private Tarefa tarefa;

	public AtividadeTarefa() {
	}

	/**
	 * @return the idAtividadeTarefa
	 */
	public int getIdAtividadeTarefa() {
		return idAtividadeTarefa;
	}

	/**
	 * @param idAtividadeTarefa the idAtividadeTarefa to set
	 */
	public void setIdAtividadeTarefa(int idAtividadeTarefa) {
		this.idAtividadeTarefa = idAtividadeTarefa;
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

	public AtividadeTarefa(int idAtividadeTarefa) {
		super();
		this.idAtividadeTarefa = idAtividadeTarefa;
	}

}