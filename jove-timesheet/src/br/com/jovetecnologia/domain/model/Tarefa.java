package br.com.jovetecnologia.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarefa database table.
 * 
 */
@Entity
@Table(name="tarefa")
@NamedQuery(name="Tarefa.findAll", query="SELECT t FROM Tarefa t")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tarefa")
	private int idTarefa;

	private int ativo;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="tarefa")
	private List<Registro> registros;

	public Tarefa() {
	}

	public int getIdTarefa() {
		return this.idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
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
		registro.setTarefa(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setTarefa(null);

		return registro;
	}

}