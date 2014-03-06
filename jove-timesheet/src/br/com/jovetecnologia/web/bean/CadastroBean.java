package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.util.IOutcome;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 8397217586141036024L;
	
	protected Tarefa tarefaSelecionada;
	protected Atividade atividadeSelecionada;
	protected Funcionario funcionarioSelecionado;
	protected Usuario usuarioSelecionado;

	/**
	 * Abre a tela de cadastro
	 * @author Joaquim Neto
	 * @return O nome da pagina solicitada pelo cliente
	 */
	public String abrirPagina() {
		return IOutcome.CADASTRO;
	}
	
	@PostConstruct
	public void inicializarPagina() {
		tarefaSelecionada = new Tarefa();
		atividadeSelecionada = new Atividade();
		funcionarioSelecionado = new Funcionario();
		usuarioSelecionado = new Usuario();
	}
	
}
