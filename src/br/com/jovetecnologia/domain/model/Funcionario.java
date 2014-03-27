package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the funcionario database table.
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 5175622276239401610L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private boolean ativo;

	private String bairro;

	@Temporal(TemporalType.TIMESTAMP)
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

	@Required(label = "e-mail", minimo = 10)
	private String email;

	private String genero;

	@Required(label = "Logradouro", minimo = 5)
	private String logradouro;
	
	@Required(label = "Nome", minimo = 10)
	private String nome;

	private String numero;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tempo_refeicao")
	private Date tempoRefeicao;

	@Column(name = "tipo_contrato")
	private String tipoContrato;

	private String uf;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name = "id_superior")
	private Funcionario funcionario;

	// bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy = "funcionario")
	private List<Funcionario> funcionarios;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "funcionario")
	private List<Registro> registros;

	// bi-directional many-to-one association to RelProjetoFuncionario
	@OneToMany(mappedBy = "funcionario")
	private List<RelProjetoFuncionario> relProjetoFuncionarios;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "funcionario")
	private List<Usuario> usuarios;

	public Funcionario() {
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @author Joaquim Neto
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @author Joaquim Neto
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(Date cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return this.dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefoneFixo() {
		return this.telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public Date getTempoRefeicao() {
		return this.tempoRefeicao;
	}

	public void setTempoRefeicao(Date tempoRefeicao) {
		this.tempoRefeicao = tempoRefeicao;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getUsuarioModificador() {
		return this.usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<RelProjetoFuncionario> getRelProjetoFuncionarios() {
		return this.relProjetoFuncionarios;
	}

	public void setRelProjetoFuncionarios(List<RelProjetoFuncionario> relProjetoFuncionarios) {
		this.relProjetoFuncionarios = relProjetoFuncionarios;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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