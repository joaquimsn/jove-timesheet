package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.infrastructure.dao.AtividadeDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;


public class AtividadeService implements Serializable{
	
	private static final long serialVersionUID = -4186254508747889305L;
	
	private AtividadeDAO atividadeDAO;
	
	public AtividadeService() {
		atividadeDAO = new AtividadeDAO();
	}
	
	/**
	 * Salva a atividade na base, definindo a data do cadastro e o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param atividade Objeta atividade que será persistido
	 */
	public void cadastrar(Atividade atividade) {
		atividade.setAtivo(true);
		atividade.setDataCadastro(new Date());
		atividade.setDataManutencao(new Date());
		atividade.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		atividadeDAO.cadastar(atividade);
	}
	
	/**
	 * Altera a atividade na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param atividade Objeto que será alterado
	 */
	public void alterar(Atividade atividade) {
		atividade.setAtivo(true);
		atividade.setDataManutencao(new Date());
		atividade.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		atividadeDAO.alterar(atividade);
	}
	
	/**
	 * Ativa/Inativa a atividade com base no valor do método <b>isAtivo()</b> do objeto.
	 * @author Joaquim Neto
	 * @param atividade Objeto que será modificado na base
	 */
	public void ativarOuInativar(Atividade atividade) {
		atividadeDAO.ativarOuInativar(atividade);
	}
	
	
	/**
	 * Busca todas as atvidades que tenha um relacionamento com o projeto informado por parametro.
	 * @author Joaquim Neto
	 * @param projeto Objeto projeto que será usado na pesquisa
	 * @return Lista com todas as atividades relacionada ao projeto informado
	 */
	public List<Atividade> buscarAtividadePorProjeto(Projeto projeto) {
		return new AtividadeDAO().buscarAtividadePorProjeto(projeto);
	}
	
	/**
	 * Retorna todos os projeto salvo na base em ordem decrescente
	 * @author Joaquim Netoprojeto
	 * @return Lista com todos os projetos persistido
	 */
	@SuppressWarnings("unchecked")
	public List<Atividade> listarTodos(){
		return atividadeDAO.listarTodosDesc();
	}
}
