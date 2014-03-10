package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Departamento;
import br.com.jovetecnologia.infrastructure.dao.DepartamentoDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

public class DepartamentoService implements Serializable{
	
	private static final long serialVersionUID = 3984921776656288324L;
	
	private DepartamentoDAO departamentoDAO;
	
	public DepartamentoService() {
		departamentoDAO = new DepartamentoDAO();
	}
	
	/**
	 * Salva o departamento na base, definindo a data do cadastro e  o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param departamento Objeto departamento que será persistido
	 */
	public void cadastrar(Departamento departamento) {
		departamento.setAtivo(true);
		departamento.setDataCadastro(new Date());
		departamento.setDataManutencao(new Date());
		departamento.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		departamentoDAO.cadastar(departamento);
	}
	
	/**
	 * Altera o departamento na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param departamento Objeto departamento que será alterado
	 */
	public void alterar(Departamento departamento) {
		departamento.setDataManutencao(new Date());
		departamento.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		departamentoDAO.alterar(departamento);
	}
	
	
	/**
	 * Retorna todos os depatamentos salvo na base em ordem decrescente
	 * @author Joaquim Neto
	 * @return Lista com todos os departamentos persistido
	 */
	@SuppressWarnings("unchecked")
	public List<Departamento> listarTodos() {
		return departamentoDAO.listarTodosDesc();
	}
}
