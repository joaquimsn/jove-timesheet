package br.com.jovetecnologia.infrastructure.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jovetecnologia.domain.model.Endereco;
import br.com.jovetecnologia.infrastructure.util.MysqlConnection;

public class EnderecoDAO implements Serializable {

	private static final long serialVersionUID = 5323268046691183185L;

	private MysqlConnection connection;

	public EnderecoDAO() {
		connection = new MysqlConnection();
	}

	/**
	 * Retorna uma lista de todas as cidades cadastrada com base na UF desejada
	 * @author Joaquim Neto
	 * @param uf Parametro que será usada para pesquisar as cidades
	 * @return Lista com todas as cidades referente a UF informada
	 */
	public List<String> listarCidadePorUf(String uf) {
		List<String> listaCidade = new ArrayList<String>();
		ResultSet resultSet;

		String sql = "SELECT c.cidade FROM tend_cidade c WHERE c.uf = ?";

		try {

			PreparedStatement st = connection.getConn().prepareStatement(sql.toString());
			st.setString(1, uf);
			resultSet = st.executeQuery();

			while (resultSet.next()) {
				String cidade = new String(resultSet.getString(1));

				listaCidade.add(cidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return listaCidade;
	}

	/**
	 * Retorna uma lista de com todas as UFs cadastradas na base
	 * @author Joaquim Neto
	 * @return Lista de UF
	 */
	public List<String> listarTodosUf() {

		List<String> listaUf = new ArrayList<String>();
		ResultSet resultSet;

		String uf;

		try {
			String sql = "SELECT uf FROM tend_uf";

			PreparedStatement st = connection.getConn().prepareStatement(sql);
			resultSet = st.executeQuery();

			while (resultSet.next()) {
				uf = new String(resultSet.getString(1));

				listaUf.add(uf);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return listaUf;
	}

	/**
	 * Pesquisa um endereço com base no cep informado, retornando um objeto endereço
	 * @author Joaquim Neto
	 * @param cep Parametro que será utilizado para consultar o endereço
	 * @return Objeto Endereco
	 */
	public Endereco consultarEnderecoPorCep(String cep) {

		Endereco endereco = new Endereco();

		ResultSet resultSet;

		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT e.endereco, b.bairro, c.cidade, c.uf FROM tend_endereco e");
		sql.append(" INNER JOIN tend_bairro b ON e.cep = ? AND b.id_bairro = e.id_bairro");
		sql.append(" INNER JOIN tend_cidade c ON c.id_cidade = e.id_cidade");

		try {

			PreparedStatement st = connection.getConn().prepareStatement(sql.toString());
			st.setString(1, cep);
			resultSet = st.executeQuery();

			if (resultSet.next()) {
				endereco.setCep(cep);
				endereco.setLogradouro(resultSet.getString(1));
				endereco.setBairro(resultSet.getString(2));
				endereco.setCidade(resultSet.getString(3));
				endereco.setUf(resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return endereco;
	}
}
