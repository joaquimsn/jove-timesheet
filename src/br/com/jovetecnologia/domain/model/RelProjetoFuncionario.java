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
 * The persistent class for the rel_projeto_funcionario database table.
 */
@Entity
@Table(name = "rel_projeto_funcionario")
public class RelProjetoFuncionario implements Serializable {

	private static final long serialVersionUID = 3743347025821445266L;

	@EmbeddedId
	private RelProjetoFuncionarioPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "usuario_modificador")
	private int usuarioModificador;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name = "id_funcionario", insertable = false, updatable = false)
	private Funcionario funcionario;

	// bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name = "id_projeto", insertable = false, updatable = false)
	private Projeto projeto;

	public RelProjetoFuncionario() {
	}
	
	/**
	 * Instancia relProjetoFuncionario criandao a sua PK
	 * @author Joaquim Neto
	 * @param funcionario Objeto Funcionário que irá compor o realcionamento
	 * @param projeto Objeto Projeto que irá compor o relacionamento
	 */
	public RelProjetoFuncionario(Funcionario funcionario, Projeto projeto) {
		RelProjetoFuncionarioPK pk = new RelProjetoFuncionarioPK();
		
		pk.setIdFuncionario(funcionario.getIdFuncionario());
		pk.setIdProjeto(projeto.getIdProjeto());
		
		setFuncionario(funcionario);
		setProjeto(projeto);
		setId(pk);
	}

	public RelProjetoFuncionarioPK getId() {
		return this.id;
	}

	public void setId(RelProjetoFuncionarioPK id) {
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

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}