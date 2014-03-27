package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the rel_atividade_tarefa database table.
 */
@Entity
@Table(name = "rel_atividade_tarefa")
public class RelAtividadeTarefa implements Serializable {

	private static final long serialVersionUID = -6756925324765130446L;

	@EmbeddedId
	private RelAtividadeTarefaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manutencao")
	private Date dataManutencao;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name = "id_atividade", insertable = false, updatable = false)
	private Atividade atividade;

	// bi-directional many-to-one association to Tarefa
	@ManyToOne
	@JoinColumn(name = "id_tarefa", insertable = false, updatable = false)
	private Tarefa tarefa;

	public RelAtividadeTarefa() {
	}

	public RelAtividadeTarefaPK getId() {
		return this.id;
	}

	public void setId(RelAtividadeTarefaPK id) {
		this.id = id;
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

	public int getUsuarioModificador() {
		return this.usuarioModificador;
	}

	public void setUsuarioModificador(int usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}