package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Projeto;
import br.com.jovetecnologia.domain.model.RelProjetoFuncionario;
import br.com.jovetecnologia.infrastructure.dao.RelProjetoFuncionarioDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

public class RelProjetoFuncionarioService implements Serializable {

	private static final long serialVersionUID = 4081422723474520978L;

	private RelProjetoFuncionarioDAO relProjetoFuncionarioDAO;

	public RelProjetoFuncionarioService() {
		relProjetoFuncionarioDAO = new RelProjetoFuncionarioDAO();
	}

	/**
	 * Grava o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionario
	 */
	public void cadastrar(RelProjetoFuncionario relacionamento) {
		relacionamento.setDataCadastro(new Date());
		relacionamento.setUsuarioModificador(SystemUtils.getUsuarioLogado().getIdUsuario());

		relProjetoFuncionarioDAO.cadastar(relacionamento);
	}

	/**
	 * Excluir o relacionamento entre Projeto e Funcionário
	 * @author Joaquim Neto
	 * @param relacionamento Objeto relProjetoFuncionatio
	 */
	public void deletar(RelProjetoFuncionario relacionamento) {
		relProjetoFuncionarioDAO.deletar(relacionamento);
	}

	public List<Funcionario> listarFuncionarioPorProjeto(Projeto projeto) {
		return new FuncionarioService().consultarFuncionairoPorProjeto(projeto);
	}

}
