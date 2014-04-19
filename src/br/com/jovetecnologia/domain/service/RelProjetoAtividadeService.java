package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;

import br.com.jovetecnologia.domain.model.RelProjetoAtividade;
import br.com.jovetecnologia.infrastructure.dao.RelProjetoAtividadeDAO;

public class RelProjetoAtividadeService implements Serializable {

	private static final long serialVersionUID = -7748779926962823897L;

	private RelProjetoAtividadeDAO relProjetoAtividadeDAO;

	public RelProjetoAtividadeService() {
		relProjetoAtividadeDAO = new RelProjetoAtividadeDAO();
	}

	/**
	 * Cadastra um relacionamento do tipo ProjetoAtividade
	 * @author Joaquim Neto
	 * @param rel Relacionamento entre Projeto e Atividade que será salvo
	 */
	public void cadastrar(RelProjetoAtividade rel) {
		rel.setDataCadastro(new Date());
		relProjetoAtividadeDAO.cadastar(rel);
	}

	/**
	 * Excluir o relacionamento entre Projeto e Atividade
	 * @author Joaquim Neto
	 * @param rel Relacionamento que será deletado
	 */
	public void deletar(RelProjetoAtividade rel) {
		relProjetoAtividadeDAO.deletar(rel);
	}

}
