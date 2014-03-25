package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.List;

import br.com.jovetecnologia.domain.model.AtividadeTarefa;
import br.com.jovetecnologia.infrastructure.dao.AtividadeTarefaDAO;

public class AtividadeTarefaService  implements Serializable{
	
	private static final long serialVersionUID = -6384525098073681124L;
	
	private AtividadeTarefaDAO atividadeTarefaDAO;
	
	public AtividadeTarefaService() {
		atividadeTarefaDAO = new AtividadeTarefaDAO();
	}
	
		/**
		 * Salva o atividadeTarefa na base, definindo a data do cadastro e o usuário que realizou o cadastro
		 * @author Joaquim Neto
		 * @param atividadeTarefa Objeto atividadeTarefa que será persistido
		 */
		public void cadastrar(AtividadeTarefa atividadeTarefa) {
			atividadeTarefaDAO.cadastar(atividadeTarefa);
		}
		
		/**
		 * Altera a atividadeTarefa na base, definindo a data da manutenção e o usuário que a realizou
		 * @author Joaquim Neto
		 * @param atividadeTarefa Objeto que será alterado
		 */
		public void alterar(AtividadeTarefa  atividadeTarefa) {
			atividadeTarefaDAO.alterar(atividadeTarefa);
		}
		
		/**
		 * deleta a atividadeTarefa
		 * @author Joaquim Neto
		 * @param atividadeTarefa Objeto que será removido da base
		 */
		public void deletar(AtividadeTarefa  atividadeTarefa) {
			atividadeTarefaDAO.deletar(atividadeTarefa);
		}
		
		/**
		 * Retorna todos as atividadeTarefa salvo na base em ordem decrescente
		 * @author Joaquim Neto
		 * @return Lista com todos as atividadeTarefas persistido
		 */
		@SuppressWarnings("unchecked")
		public List<AtividadeTarefa > listarTodos(){
			return atividadeTarefaDAO.listarTodos();
		}
	}