package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	/**
	 * Instancia relAtividadeTarefa para criar sua PK automaticamente
	 * @author Joaquim Neto
	 * @param atividade Objeto Atividade que irá compor o realcionamento
	 * @param tarefa Objeto Tarefa que irá compor o relacionamento
	 */
	public RelAtividadeTarefa(Atividade atividade, Tarefa tarefa) {
		RelAtividadeTarefaPK pk = new RelAtividadeTarefaPK();

		pk.setIdAtividade(atividade.getIdAtividade());
		pk.setIdTarefa(tarefa.getIdTarefa());

		setAtividade(atividade);
		setTarefa(tarefa);
		setId(pk);
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