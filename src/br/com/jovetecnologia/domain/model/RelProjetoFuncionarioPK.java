package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rel_projeto_funcionario database table.
 */
@Embeddable
public class RelProjetoFuncionarioPK implements Serializable {

	private static final long serialVersionUID = -7681532056859273181L;

	@Column(name = "id_funcionario")
	private int idFuncionario;

	@Column(name = "id_projeto")
	private int idProjeto;

	public RelProjetoFuncionarioPK() {
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelProjetoFuncionarioPK)) {
			return false;
		}
		RelProjetoFuncionarioPK castOther = (RelProjetoFuncionarioPK) other;
		return (this.idFuncionario == castOther.idFuncionario) && (this.idProjeto == castOther.idProjeto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idFuncionario;
		hash = hash * prime + this.idProjeto;

		return hash;
	}
}