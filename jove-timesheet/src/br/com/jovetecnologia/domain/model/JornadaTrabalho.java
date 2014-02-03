package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.List;

/**
 * The persistent class for the jornada_trabalho database table.
 */
@Entity
@Table(name = "jornada_trabalho")
@NamedQuery(name = "JornadaTrabalho.findAll", query = "SELECT j FROM JornadaTrabalho j")
public class JornadaTrabalho implements Serializable {

	private static final long serialVersionUID = -469272113715000227L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jornada_trabalho")
	private int idJornadaTrabalho;

	private byte ativo;

	@Column(name = "carga_horaria")
	private Time cargaHoraria;

	private String folga;

	private String jornada;

	private String periodo;
	/**
	 * 
	 */
	@Column(name = "tempo_refeicao")
	private Time tempoRefeicao;

	@Column(name = "tipo_contrato")
	private String tipoContrato;

	// bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy = "jornadaTrabalho")
	private List<Funcionario> funcionarios;

	public JornadaTrabalho() {
	}

	/**
	 * @return the idJornadaTrabalho
	 */
	public int getIdJornadaTrabalho() {
		return idJornadaTrabalho;
	}

	/**
	 * @param idJornadaTrabalho the idJornadaTrabalho to set
	 */
	public void setIdJornadaTrabalho(int idJornadaTrabalho) {
		this.idJornadaTrabalho = idJornadaTrabalho;
	}

	/**
	 * @return the ativo
	 */
	public byte getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(byte ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the cargaHoraria
	 */
	public Time getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * @param cargaHoraria the cargaHoraria to set
	 */
	public void setCargaHoraria(Time cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * @return the folga
	 */
	public String getFolga() {
		return folga;
	}

	/**
	 * @param folga the folga to set
	 */
	public void setFolga(String folga) {
		this.folga = folga;
	}

	/**
	 * @return the jornada
	 */
	public String getJornada() {
		return jornada;
	}

	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the tempoRefeicao
	 */
	public Time getTempoRefeicao() {
		return tempoRefeicao;
	}

	/**
	 * @param tempoRefeicao the tempoRefeicao to set
	 */
	public void setTempoRefeicao(Time tempoRefeicao) {
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
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idJornadaTrabalho;
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
		JornadaTrabalho other = (JornadaTrabalho) obj;
		if (idJornadaTrabalho != other.idJornadaTrabalho)
			return false;
		return true;
	}

}