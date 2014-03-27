package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rel_projeto_atividade database table.
 */
@Embeddable
public class RelProjetoAtividadePK implements Serializable {

	private static final long serialVersionUID = -7653420918512604716L;

	@Column(name = "id_projeto")
	private int idProjeto;

	@Column(name = "id_atividade")
	private int idAtividade;

	public RelProjetoAtividadePK() {
	}

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public int getIdAtividade() {
		return this.idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelProjetoAtividadePK)) {
			return false;
		}
		RelProjetoAtividadePK castOther = (RelProjetoAtividadePK) other;
		return (this.idProjeto == castOther.idProjeto) && (this.idAtividade == castOther.idAtividade);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProjeto;
		hash = hash * prime + this.idAtividade;

		return hash;
	}
}