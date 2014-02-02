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
	private static final long serialVersionUID = 1L;

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

}