package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean extends CadastroBean implements Serializable {

	private static final long serialVersionUID = 4085651580409833887L;

	/**
	 * Inicia os compontes essenciais para o funcionamento da pagina Departamento
	 * @author Joaquim Neto
	 */

	@PostConstruct
	public void inicializarComponentes() {
		usuarioSelecionado = new Usuario();
	}
	
	/**
	 * Zera os atributos da departamento fazendo um nova instancia;
	 * @author Joaquim Neto
	 */
	private void limparCampos() {
		usuarioSelecionado = new Usuario();
	}

	/**
	 * @author Joaquim Neto
	 * @return the usuarioSelecionado
	 */
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	/**
	 * @author Joaquim Neto
	 * @param usuarioSelecionado the usuarioSelecionado to set
	 */
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}