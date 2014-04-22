package br.com.jovetecnologia.domain.service;

import java.util.List;

import br.com.jovetecnologia.domain.model.Endereco;
import br.com.jovetecnologia.infrastructure.dao.EnderecoDAO;

public class EnderecoService {

	private EnderecoDAO enderecoDAO;

	public EnderecoService() {
		enderecoDAO = new EnderecoDAO();
	}

	/**
	 * Lista todos os UF do Brasil
	 * @author Joaquim Neto
	 * @return Lista de UF
	 */
	public List<String> listarUf() {
		return enderecoDAO.listarTodosUf();
	}

	/**
	 * Retorna uma lista que conterá todas as cidades pertencentes a uf informada
	 * @author Joaquim Neto
	 * @param uf String com a UF
	 * @return Lista de cidades
	 */
	public List<String> listarCidadePorUf(String uf) {
		return enderecoDAO.listarCidadePorUf(uf);
	}
	
	/**
	 * Retorna um objeto endereço com todos os atributos preenchido com base no cep informado
	 * @author Joaquim Neto
	 * @param cep
	 * @return Objeto endereço
	 */
	public Endereco obterEnderecoPorCep(String cep) {
		return enderecoDAO.consultarEnderecoPorCep(cep);
	}
}
