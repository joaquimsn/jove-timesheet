package br.com.jovetecnologia.domain.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jovetecnologia.domain.model.Empresa;
import br.com.jovetecnologia.infrastructure.dao.EmpresaDAO;
import br.com.jovetecnologia.infrastructure.util.SystemUtils;


/**
 * Contem as principais regras de negocio do objeto Empresa
 * @author Joaquim Neto
 *
 */
public class EmpresaService implements Serializable {

	private static final long serialVersionUID = -1533531032670588261L;
	
	private EmpresaDAO empresaDAO;
	
	public EmpresaService() {
		empresaDAO = new EmpresaDAO();
	}
	
	/**
	 * Salva a empresa na base, definindo a data do cadastro e  o usuário que realizou o cadastro
	 * @author Joaquim Neto
	 * @param empresa Objeto empresa que será persistido
	 */
	public void cadastrar(Empresa empresa) {

		empresa.setAtivo(true);
		empresa.setDataManutencao(new Date());
		empresa.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		
		empresa.setDataCadastro( new Date());			
		
		empresaDAO.cadastar(empresa);
	}
	
	/**
	 * Altera a empresa na base, definindo a data da manutenção e o usuário que a realizou
	 * @author Joaquim Neto
	 * @param empresa Objeto empresa que será alterado
	 */
	public void alterar(Empresa empresa) {
		empresa.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		empresa.setDataManutencao(new Date());
		
		empresaDAO.alterar(empresa);
	}
	
	/**
	 * Retorna todas as empresas salva na base em ordem decrescente
	 * @author Joaquim Neto
	 * @return Lista com todas as empresas persistidas
	 */
	@SuppressWarnings("unchecked")
	public List<Empresa> listarTodos() {
		List<Empresa> lista = new ArrayList<Empresa>();
		
		try {
			lista = empresaDAO.listarTodosDesc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
