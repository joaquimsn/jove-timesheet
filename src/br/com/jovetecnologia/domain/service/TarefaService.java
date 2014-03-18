package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.infrastructure.dao.TarefaDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;


public class TarefaService implements Serializable{
	
	private static final long serialVersionUID = -4158416550383484298L;

	private TarefaDAO tarefaDAO;
	
	public TarefaService() {
		tarefaDAO = new TarefaDAO();
	}
	
	/**
	 * Salva a tarefa na base, definindo a data do cadastro e o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param tarefa Objeto projeto que será persistido
	 */
	public void cadastrar(Tarefa tarefa) {
		tarefa.setAtivo(true);
		tarefa.setDataCadastro(new Date());
		tarefa.setDataManutencao(new Date());
		tarefa.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		tarefaDAO.cadastar(tarefa);
	}
	
	/**
	 * Altera a tarefa na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param tarefa Objeto que será alterado
	 */
	public void alterar(Tarefa tarefa) {
		tarefa.setAtivo(true);
		tarefa.setDataManutencao(new Date());
		tarefa.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		tarefaDAO.alterar(tarefa);
	}
	
	/**
	 * Ativa/Inativa tarefa com base no valor do método <b>isAtivo()</b> do objeto.
	 * @author Joaquim Neto
	 * @param tarefa Objeto que será modificado na base
	 */
	public void ativarOuInativar(Tarefa tarefa) {
		tarefaDAO.ativarOuInativar(tarefa);
	}
	
	/**
	 * Retorna todos os projeto salvo na base em ordem decrescente
	 * @author Joaquim Neto 
	 * @return Lista com todos os projetos persistido
	 */
	@SuppressWarnings("unchecked")
	public List<Tarefa> listarTodos(){
		return tarefaDAO.listarTodosDesc();
	}
}
