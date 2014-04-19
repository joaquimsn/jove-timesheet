package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;

import br.com.jovetecnologia.domain.model.RelAtividadeTarefa;

public class RelAtividadeTarefaDAO extends DAO<RelAtividadeTarefa> implements Serializable {

	private static final long serialVersionUID = 2668827291182192508L;

	public RelAtividadeTarefaDAO() {
		super(RelAtividadeTarefa.class);
	}
}
