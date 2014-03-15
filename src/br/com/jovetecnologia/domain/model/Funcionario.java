package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

/**
 * The persistent class for the funcionario database table.
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1173982713922256842L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@Column(name = "ativo", columnDefinition = "BIT", length = 1)
	private boolean ativo;

	private String bairro;

	@Column(name = "carga_horaria")
	private Date cargaHoraria;

	private String celular;

	@Required(label = "CEP", minimo = 9)
	private String cep;

	private String cidade;

	private String complemento;

	@Required(label = "CPF", minimo = 14)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Required(label = "e-mail", minimo = 15)
	private String email;

	private String genero;

	@Column(name = "id_usuario")
	private int idUsuario;

	@Required(label = "Logradouro", minimo = 5)
	private String logradouro;

	@Required(label = "Nome", minimo = 10)
	private String nome;

	@Required(label = "Numero", minimo = 1)
	private String numero;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@Column(name = "tempo_refeicao")
	private Date tempoRefeicao;

	@Column(name = "tipo_contrato")
	private String tipoContrato;

	private String uf;

	// bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name = "fk_id_funcionario")
	private Funcionario funcionario;

	// bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy = "funcionario")
	private List<Funcionario> listaFuncionarios;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "funcionario")
	private List<Registro> listaRegistros;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "funcionario")
	private List<Usuario> listaUsuarios;

	public Funcionario() {
	}

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cargaHoraria
	 */
	public Date getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * @param cargaHoraria the cargaHoraria to set
	 */
	public void setCargaHoraria(Date cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataManutencao
	 */
	public Date getDataManutencao() {
		return dataManutencao;
	}

	/**
	 * @param dataManutencao the dataManutencao to set
	 */
	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the telefoneFixo
	 */
	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	/**
	 * @param telefoneFixo the telefoneFixo to set
	 */
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	/**
	 * @return the tempoRefeicao
	 */
	public Date getTempoRefeicao() {
		return tempoRefeicao;
	}

	/**
	 * @param tempoRefeicao the tempoRefeicao to set
	 */
	public void setTempoRefeicao(Date tempoRefeicao) {
		this.tempoRefeicao = tempoRefeicao;
	}

	/**
	 * @return the tipoContrato
	 */
	public String getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the listaFuncionarios
	 */
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	/**
	 * @param listaFuncionarios the listaFuncionarios to set
	 */
	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}

	/**
	 * @return the listaRegistros
	 */
	public List<Registro> getListaRegistros() {
		return listaRegistros;
	}

	/**
	 * @param listaRegistros the listaRegistros to set
	 */
	public void setListaRegistros(List<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		return true;
	}

}