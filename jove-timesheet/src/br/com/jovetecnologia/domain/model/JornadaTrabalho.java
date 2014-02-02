package br.com.jovetecnologia.domain.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the jornada_trabalho database table.
 * 
 */
@Entity
@Table(name="jornada_trabalho")
@NamedQuery(name="JornadaTrabalho.findAll", query="SELECT j FROM JornadaTrabalho j")
public class JornadaTrabalho implements Serializable {

	private static final long serialVersionUID = -7300054924676881886L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_jornada_trabalho")
	private int idJornadaTrabalho;

	private int ativo;

	@Column(name="carga_horaria")
	private Time cargaHoraria;

	private String folga;

	private String jornada;

	private String periodo;

	@Column(name="tempo_refeicao")
	private Time tempoRefeicao;

	@Column(name="tipo_contrato")
	private String tipoContrato;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="jornadaTrabalho")
	private List<Funcionario> funcionarios;

	public JornadaTrabalho() {
	}

	public int getIdJornadaTrabalho() {
		return this.idJornadaTrabalho;
	}

	public void setIdJornadaTrabalho(int idJornadaTrabalho) {
		this.idJornadaTrabalho = idJornadaTrabalho;
	}

	public int getAtivo() {
		return this.ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public Time getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(Time cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getFolga() {
		return this.folga;
	}

	public void setFolga(String folga) {
		this.folga = folga;
	}

	public String getJornada() {
		return this.jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Time getTempoRefeicao() {
		return this.tempoRefeicao;
	}

	public void setTempoRefeicao(Time tempoRefeicao) {
		this.tempoRefeicao = tempoRefeicao;
	}

	public String getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setJornadaTrabalho(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setJornadaTrabalho(null);

		return funcionario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ativo;
		result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
		result = prime * result + ((folga == null) ? 0 : folga.hashCode());
		result = prime * result + ((funcionarios == null) ? 0 : funcionarios.hashCode());
		result = prime * result + idJornadaTrabalho;
		result = prime * result + ((jornada == null) ? 0 : jornada.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		result = prime * result + ((tempoRefeicao == null) ? 0 : tempoRefeicao.hashCode());
		result = prime * result + ((tipoContrato == null) ? 0 : tipoContrato.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (ativo != other.ativo)
			return false;
		if (cargaHoraria == null) {
			if (other.cargaHoraria != null)
				return false;
		} else if (!cargaHoraria.equals(other.cargaHoraria))
			return false;
		if (folga == null) {
			if (other.folga != null)
				return false;
		} else if (!folga.equals(other.folga))
			return false;
		if (funcionarios == null) {
			if (other.funcionarios != null)
				return false;
		} else if (!funcionarios.equals(other.funcionarios))
			return false;
		if (idJornadaTrabalho != other.idJornadaTrabalho)
			return false;
		if (jornada == null) {
			if (other.jornada != null)
				return false;
		} else if (!jornada.equals(other.jornada))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (tempoRefeicao == null) {
			if (other.tempoRefeicao != null)
				return false;
		} else if (!tempoRefeicao.equals(other.tempoRefeicao))
			return false;
		if (tipoContrato == null) {
			if (other.tipoContrato != null)
				return false;
		} else if (!tipoContrato.equals(other.tipoContrato))
			return false;
		return true;
	}

}