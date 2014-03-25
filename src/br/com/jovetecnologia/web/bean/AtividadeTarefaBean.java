package br.com.jovetecnologia.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Atividade;
import br.com.jovetecnologia.domain.model.AtividadeTarefa;
import br.com.jovetecnologia.domain.model.Tarefa;
import br.com.jovetecnologia.domain.service.AtividadeService;
import br.com.jovetecnologia.domain.service.AtividadeTarefaService;
import br.com.jovetecnologia.domain.service.TarefaService;

@ManagedBean
@ViewScoped
public class AtividadeTarefaBean extends CadastroBean implements Serializable{

	private static final long serialVersionUID = 4412312771962724732L;

	private AtividadeTarefa atividadeTarefa;

	private List<AtividadeTarefa> listaAtividadeTarefa;
	private List<AtividadeTarefa> listaAtividadeTarefaFiltrada;
	
	private List<Tarefa> listaTarefa;
	
	private List<Atividade> listaAtividade;
	
	private int tipoDoObjeto;
	
	
	/**
	 * Inicializa todos os componetes da pagina, identificando qual será o objeto trabalhado nós métodos,
	 * @author Joaquim Neto
	 * @param object O parametro deve receber um objeto do tipo <b>Tarefa</b> ou <b>Atividade</b>.
	 */
	@PostConstruct
	public void inicializarPagina() {
		
		atividadeTarefa = new AtividadeTarefa();
		
		listarTodos();
	}
	
	public void identificarObjeto(Object object) {
		try {
			if (object instanceof Tarefa) {
				getAtividadeTarefa().setTarefa((Tarefa) object);
				
				setTipodoObjeto(1);
//				setTipo(AtividadeTarefaEnum.getValueByDisplay(object.getClass().getName()));
				
			} else if (object instanceof Atividade) {
				getAtividadeTarefa().setAtividade((Atividade) object);
				
				setTipodoObjeto(2);
//				setTipo(AtividadeTarefaEnum.getValueByDisplay(object.getClass().getName()));
				
			} else {
				setTipodoObjeto(0);
			}
		} catch (Exception e) {
			//Pedir uma explição dos erros personalizado ao Renan
			System.out.println("Não foi possivel identificar o tipo do objeto\n" + e.getCause() );
			e.printStackTrace();
		}
		
		listarTodos();
	}

	
	/**
	 * Lista todos os objetos persistidos na base com base no método <b>getTipoDoObjeto</b>
	 * @author Joaquim Neto
	 */
	public void listarTodos() {
		if (getTipoDoObjeto() == 1) {
			setListaAtividade(new AtividadeService().listarTodos());
		} else if (getTipoDoObjeto() == 2) {
			setListaTarefa(new TarefaService().listarTodos());
		} 
		
		setListaAtividadeTarefa(new AtividadeTarefaService().listarTodos());
	}
	
	
	/**
	 * Faz uma nova instacias de todos os objetos
	 * @author Joaquim Neto
	 */
	public void LimparCampo() {
		atividadeTarefa = new AtividadeTarefa();
		
		listarTodos();
	}

	public void cadastrar() {
		new AtividadeTarefaService().cadastrar(getAtividadeTarefa());

	}

	public void deletar() {
		new AtividadeTarefaService().deletar(getAtividadeTarefa());
	}

	public boolean hasObjetoSelecionado() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @author Joaquim Neto
	 * @return the atividadeTarefa
	 */
	public AtividadeTarefa getAtividadeTarefa() {
		return atividadeTarefa;
	}

	/**
	 * @author Joaquim Neto
	 * @param atividadeTarefa the atividadeTarefa to set
	 */
	public void setAtividadeTarefa(AtividadeTarefa atividadeTarefa) {
		if (atividadeTarefa != null) {
			this.atividadeTarefa = atividadeTarefa;
		}
	}

	/**
	 * Referencia dos Tipos:<br/>
	 * <p>Tipo = <b>1</b> representa <b>Objeto Tarefa</b> </p>
	 *  <p>Tipo = <b>2</b> representa <b>Objeto Atividade</b> </p>
	 * <p>Tipo = <b>0</b> representa <b>Desconhecido</b> </p>
	 * @author Joaquim Neto
	 * @return the tipoDoObjeto
	 */
	public int getTipoDoObjeto() {
		return tipoDoObjeto;
	}

	/**
	 * @author Joaquim Neto
	 * @param tipo the tipo to set
	 */
	public void setTipodoObjeto(int tipo) {
		this.tipoDoObjeto = tipo;
	}


	/**
	 * @author Joaquim Neto
	 * @return the listaAtividadeTarefa
	 */
	public List<AtividadeTarefa> getListaAtividadeTarefa() {
		return listaAtividadeTarefa;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaAtividadeTarefa the listaAtividadeTarefa to set
	 */
	public void setListaAtividadeTarefa(List<AtividadeTarefa> listaAtividadeTarefa) {
		this.listaAtividadeTarefa = listaAtividadeTarefa;
	}

	/**
	 * @author Joaquim Neto
	 * @return the listaAtividadeTarefaFiltrada
	 */
	public List<AtividadeTarefa> getListaAtividadeTarefaFiltrada() {
		return listaAtividadeTarefaFiltrada;
	}

	/**
	 * @author Joaquim Neto
	 * @param listaAtividadeTarefaFiltrada the listaAtividadeTarefaFiltrada to set
	 */
	public void setListaAtividadeTarefaFiltrada(List<AtividadeTarefa> listaAtividadeTarefaFiltrada) {
		this.listaAtividadeTarefaFiltrada = listaAtividadeTarefaFiltrada;
	}
	
	/**
	 * @author Joaquim Neto
	 * @return the listaAtividade
	 */
	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}


	/**
	 * @author Joaquim Neto
	 * @param listaAtividade the listaAtividade to set
	 */
	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}


	/**
	 * @author Joaquim Neto
	 * @return the listaTarefa
	 */
	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}


	/**
	 * @author Joaquim Neto
	 * @param listaTarefa the listaTarefa to set
	 */
	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

}

