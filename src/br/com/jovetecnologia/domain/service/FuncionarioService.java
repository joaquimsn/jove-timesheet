package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.infrastructure.dao.FuncionarioDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

/**
 * Contem as principais regras de negocio do objeto Funcionario
 * @author Joaquim Neto
 *
 */
public class FuncionarioService implements Serializable {
	
	private static final long serialVersionUID = -5136997522696666349L;
	
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioService() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	/**
	 * Salva o funcionario na base, definindo a data do cadastro e  o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario que será persistido
	 */
	public void cadastrar(Funcionario funcionario) {
		funcionario.setAtivo(true);
		funcionario.setDataCadastro(new Date());
		funcionario.setDataManutencao(new Date());
		funcionario.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		funcionarioDAO.cadastar(funcionario);
	}
	
	/**
	 * Altera o funcionario na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario que será alterado
	 */
	public void alterar(Funcionario funcionario) {
		funcionario.setDataManutencao(new Date());
		funcionario.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		funcionarioDAO.alterar(funcionario);
	}
	
	/**
	 * Retorna todos os funcionarios salvo na base em ordem decrescente
	 * @author Joaquim Neto
	 * @return Lista com todos os funcionarios persistido
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos() {
		return funcionarioDAO.listarTodosDesc();
	}
	
	
	/**
	 * Consulta o funcionario na Base, pela sua PK
	 * @author Joaquim Neto
	 * @param idFuncionario PK do funcionario
	 * @return Funcionario
	 */
	public Funcionario consultarPorId(int idFuncionario) {
		return new FuncionarioDAO().consultarPorId(idFuncionario);
	}
}
