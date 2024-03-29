package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.infrastructure.dao.FuncionarioDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

/**
 * Contem as principais regras de negocio do objeto Funcionario
 * @author Joaquim Neto
 */
public class FuncionarioService implements Serializable {

	private static final long serialVersionUID = -5136997522696666349L;

	private FuncionarioDAO funcionarioDAO;

	public FuncionarioService() {
		funcionarioDAO = new FuncionarioDAO();
	}

	/**
	 * Salva o funcionario na base, definindo a data do cadastro e o usuário que realizou
	 * o cadastro
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario que será persistido
	 */
	public void cadastrar(Funcionario funcionario) {
		funcionario.setAtivo(true);
		funcionario.setDataCadastro(new Date());
		funcionario.setDataManutencao(new Date());
		funcionario.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());

		funcionarioDAO.cadastar(funcionario);
	}

	/**
	 * Altera o funcionario na base, definindo a data da manutenção e o usuário que a
	 * realizou
	 * @author Joaquim Neto
	 * @param funcionario Objeto funcionario que será alterado
	 */
	public void alterar(Funcionario funcionario) {
		funcionario.setAtivo(true);
		funcionario.setDataManutencao(new Date());
		funcionario.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());

		funcionarioDAO.alterar(funcionario);
	}

	/**
	 * Ativa/Inativa o funcionario e o usuario associado a ele com base no valor do método
	 * <b>isAtivo()</b> do objeto.
	 * @author Joaquim Neto
	 * @param funcionario Funcionário que será modificado na base
	 */
	public void ativarOuInativar(Funcionario funcionario) {
		funcionarioDAO.ativarOuInativar(funcionario);

		// Inativa o usuário associado ao funcionario
		new UsuarioService().ativarOuInativarPorFuncionario(funcionario);
	}

	/**
	 * Verifica se o e-mail informada já está cadastrado no sistema
	 * @author Joaquim Neto
	 * @param email
	 * @return <b>true</b> Se já exitir o email
	 */
	public boolean consultarEmail(String email) {
		return funcionarioDAO.consultarEmail(email);
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

	/**
	 * Retornar uma lista com os funcionarios supervisores
	 * @author Joaquim Neto
	 * @return Lista de funcionarios
	 */
	public List<Funcionario> listarSupervisor() {
		return funcionarioDAO.listarSupervisor();
	}

	/**
	 * Lista todos os funcionarios que estão relacionado com um projeto passado por
	 * paramentro
	 * @author Joaquim Neto
	 * @param projeto Objeto Projeto
	 * @return Lista com os funcionários que estão relacionado ao projeto informado por
	 *         paramentro
	 */
	public List<Funcionario> consultarFuncionairoPorProjeto(Projeto projeto) {
		return funcionarioDAO.consultarFuncionarioPorProjeto(projeto);
	}
}
