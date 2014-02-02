package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity
@Table(name="projeto")
@NamedQuery(name="Projeto.findAll", query="SELECT p FROM Projeto p")
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_projeto")
	private int idProjeto;

	private int ativo;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="projeto")
	private List<Registro> registros;

	public Projeto() {
	}

	public int getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public int getAtivo() {
		return this.ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
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

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setProjeto(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setProjeto(null);

		return registro;
	}

}