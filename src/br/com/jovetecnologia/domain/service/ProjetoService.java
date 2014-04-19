package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.infrastructure.dao.ProjetoDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

public class ProjetoService implements Serializable{
	
	private static final long serialVersionUID = 6059606048801351328L;
	
	private ProjetoDAO projetoDAO;
	
	public ProjetoService() {
		projetoDAO = new ProjetoDAO();
	}
	
	/**
	 * Salva o projeto na base, definindo a data do cadastro e o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param projeto Objeto projeto que será persistido
	 */
	public void cadastrar(Projeto projeto) {
		projeto.setAtivo(true);
		projeto.setDataCadastro(new Date());
		projeto.setDataManutencao(new Date());
		projeto.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		projetoDAO.cadastar(projeto);
	}
	
	/**
	 * Altera o projeto na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param projeto Objeto que será alterado
	 */
	public void alterar(Projeto projeto) {
		projeto.setAtivo(true);
		projeto.setDataManutencao(new Date());
		projeto.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		projetoDAO.alterar(projeto);
	}
	
	/**
	 * Ativa/Inativa o projeto com base no valor do método <b>isAtivo()</b> do objeto.
	 * @author Joaquim Neto
	 * @param projeto Objeto que será modificado na base
	 */
	public void ativarOuInativar(Projeto projeto) {
		projetoDAO.ativarOuInativar(projeto);
	}
	
	/**
	 * Retorna todos os projeto salvo na base em ordem decrescente
	 * @author Joaquim Neto
	 * @return Lista com todos os projetos persistido
	 */
	@SuppressWarnings("unchecked")
	public List<Projeto> listarTodos(){
		return projetoDAO.listarTodosDesc();
	}
}
