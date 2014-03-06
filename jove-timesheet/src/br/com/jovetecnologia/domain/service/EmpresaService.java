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
	 * Cadastra uma empresa
	 * @author Joaquim Neto
	 * @param empresa para ser cadastrada
	 */
	public void cadastrar(Empresa empresa) {
		empresa.setAtivo(true);
		
		//Verifica se a empresa já tem uma data de cadastro registrada
		if(empresa.getDataCadastro() == null) {
			empresa.setDataCadastro( new Date());			
		}
		
		empresaDAO.cadastar(empresa);
	}
	
	/**
	 * Alterar salva a empresa alterada, define a data da modificação e qual usuário a fez;
	 * @author Joaquim Neto
	 * @param empresa Empresa modificada que será atualizada na base
	 */
	public void alterar(Empresa empresa) {
		empresa.setIdUsuario(SystemUtils.getUsuarioLogado().getIdUsuario());
		empresa.setDataManutencao(new Date());
		
		empresaDAO.alterar(empresa);
	}
	
	/**
	 * Retorna todas as empresas cadastradas.
	 * @author Joaquim Neto
	 * @return Lista com todas as empresa cadastradas
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
