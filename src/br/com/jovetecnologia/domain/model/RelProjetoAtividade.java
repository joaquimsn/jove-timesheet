package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the rel_projeto_atividade database table.
 */
@Entity
@Table(name = "rel_projeto_atividade")
public class RelProjetoAtividade implements Serializable {

	private static final long serialVersionUID = 5695976882659358146L;

	@EmbeddedId
	private RelProjetoAtividadePK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name = "id_projeto", insertable = false, updatable = false)
	private Projeto projeto;

	// bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name = "id_atividade", insertable = false, updatable = false)
	private Atividade atividade;

	public RelProjetoAtividade() {
	}

	/**
	 * Instancia relProjetoAtividade para criar sua PK automaticamente
	 * @author Joaquim Neto
	 * @param projeto Objeto Projeto que irá compor o relacionamento
	 * @param atividade Objeto Atividade que irá compor o realcionamento
	 */
	public RelProjetoAtividade(Projeto projeto, Atividade atividade) {
		RelProjetoAtividadePK pk = new RelProjetoAtividadePK();

		pk.setIdProjeto(projeto.getIdProjeto());
		pk.setIdAtividade(atividade.getIdAtividade());

		setProjeto(projeto);
		setAtividade(atividade);
		setId(pk);
	}

	public RelProjetoAtividadePK getId() {
		return this.id;
	}

	public void setId(RelProjetoAtividadePK id) {
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

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}