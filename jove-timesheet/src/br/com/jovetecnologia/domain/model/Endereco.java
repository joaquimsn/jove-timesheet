package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 5643776236033391416L;

	private String cep;
	private String logradouro;
	private String bairro;
	private String uf;
	private String cidade;

	/**
	 * @author Joaquim Neto
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @author Joaquim Neto
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @author Joaquim Neto
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @author Joaquim Neto
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @author Joaquim Neto
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @author Joaquim Neto
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @author Joaquim Neto
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @author Joaquim Neto
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @author Joaquim Neto
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @author Joaquim Neto	private List<String> ListaUf;
	private List<String> listaCidade;

	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
