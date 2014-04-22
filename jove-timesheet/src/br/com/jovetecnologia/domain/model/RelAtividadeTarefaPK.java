package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rel_atividade_tarefa database table.
 */
@Embeddable
public class RelAtividadeTarefaPK implements Serializable {

	private static final long serialVersionUID = -7547923645138350726L;

	// default serial version id, required for serializable classes.

	@Column(name = "id_atividade")
	private int idAtividade;

	@Column(name = "id_tarefa")
	private int idTarefa;

	public RelAtividadeTarefaPK() {
	}

	public int getIdAtividade() {
		return this.idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	public int getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelAtividadeTarefaPK)) {
			return false;
		}
		RelAtividadeTarefaPK castOther = (RelAtividadeTarefaPK) other;
		return (this.idAtividade == castOther.idAtividade) && (this.idTarefa == castOther.idTarefa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAtividade;
		hash = hash * prime + this.idTarefa;

		return hash;
	}
}