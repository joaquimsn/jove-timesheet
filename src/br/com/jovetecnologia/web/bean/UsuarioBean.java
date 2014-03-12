package br.com.jovetecnologia.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jovetecnologia.domain.interfaces.ICrudBean;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.domain.service.UsuarioService;
import br.com.jovetecnologia.infrastructure.util.Messages;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;

@ManagedBean
@ViewScoped
public class UsuarioBean extends CadastroBean implements Serializable, ICrudBean {

	private static final long serialVersionUID = 4085651580409833887L;

	private Usuario usuarioSelecionado;

	@Override
	@PostConstruct
	public void inicializarPagina() {
		usuarioSelecionado = new Usuario();
	}

	@Override
	public void listarTodos() {
		// TODO Auto-generated method stub

	}

	@Override
	public void habilitarCampo() {
		setReadonly(false);

	}

	@Override
	public void cadastrar() {
		if (!validar()) {
			return;
		}
		
		new UsuarioService().cadastrar(getUsuarioSelecionado());
		
		Messages.addInfo("Usuário cadastrado com sucesso");

	}

	@Override
	public boolean validar() {
		if (!SystemUtils.isCamposObrigatoriosPreenchidos(getUsuarioSelecionado())) {
			return false;
		}
		return true;
	}

	@Override
	public void alterar() {
		if (!validar()) {
			return;
		}
		
		usuarioSelecionado.setAtivo(true);
		
		new UsuarioService().cadastrar(getUsuarioSelecionado());
		
		Messages.addInfo("Usuário Alterado com sucesso");
	}

	@Override
	public boolean hasObjetoSelecionado() {
		if (usuarioSelecionado.getIdUsuario() == 0) {
			return false;
		}
		return true;
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
