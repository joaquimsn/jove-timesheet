package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jovetecnologia.infrastructure.util.annotation.Required;

/**
 * The persistent class for the atividade database table.
 */
@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {

	private static final long serialVersionUID = 7611907117834570933L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_atividade")
	private int idAtividade;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;
	
	@Required(label = "Descrição", minimo = 5 )
	private String descricao;
	
	@Required(label = "Nome", minimo = 3)
	private String nome;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Registro
	@OneToMany(mappedBy = "atividade")
	private List<Registro> registros;

	// bi-directional many-to-one association to RelAtividadeTarefa
	@OneToMany(mappedBy = "atividade")
	private List<RelAtividadeTarefa> relAtividadeTarefas;

	// bi-directional many-to-one association to RelProjetoAtividade
	@OneToMany(mappedBy = "atividade")
	private List<RelProjetoAtividade> relProjetoAtividades;

	public Atividade() {
	}

	public int getIdAtividade() {
		return this.idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	/**
	 * @author Joaquim Neto public byte getAtivo() { return this.ativo; } public void
	 *         setAtivo(byte ativo) { this.ativo = ativo; }
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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUsuarioModificador() {
		return this.usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<RelAtividadeTarefa> getRelAtividadeTarefas() {
		return this.relAtividadeTarefas;
	}

	public void setRelAtividadeTarefas(List<RelAtividadeTarefa> relAtividadeTarefas) {
		this.relAtividadeTarefas = relAtividadeTarefas;
	}

	public List<RelProjetoAtividade> getRelProjetoAtividades() {
		return this.relProjetoAtividades;
	}

	public void setRelProjetoAtividades(List<RelProjetoAtividade> relProjetoAtividades) {
		this.relProjetoAtividades = relProjetoAtividades;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAtividade;
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
		Atividade other = (Atividade) obj;
		if (idAtividade != other.idAtividade)
			return false;
		return true;
	}

}