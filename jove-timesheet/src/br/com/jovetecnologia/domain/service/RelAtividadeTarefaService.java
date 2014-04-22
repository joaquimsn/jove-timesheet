package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.RelAtividadeTarefa;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.infrastructure.dao.RelAtividadeTarefaDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

public class RelAtividadeTarefaService implements Serializable {

	private static final long serialVersionUID = -2109740455553572190L;

	private RelAtividadeTarefaDAO relAtividadeTarefaDAO;

	public RelAtividadeTarefaService() {
		relAtividadeTarefaDAO = new RelAtividadeTarefaDAO();
	}

	/**
	 * Grava o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionario
	 */
	public void cadastrar(RelAtividadeTarefa relacionamento) {
		relacionamento.setDataCadastro(new Date());
		relacionamento.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());

		relAtividadeTarefaDAO.cadastar(relacionamento);
	}

	/**
	 * Excluir o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionatio
	 */
	public void deletar(RelAtividadeTarefa relacionamento) {
		relAtividadeTarefaDAO.deletar(relacionamento);
	}

	/**
	 * Lista todas as tarefas que possuir um relacionamento com a atividade informada
	 * @author Joaquim Neto
	 * @param atividade Objeto Atividade
	 * @return Lista com objetos tarefa presente em um relacionamento, com a atividade
	 *         informada por paramentro
	 */
	public List<Tarefa> consultarTarefaPorProjeto(Atividade atividade) {
		return new TarefaService().consultarTarefaPorAtividade(atividade);
	}

}
