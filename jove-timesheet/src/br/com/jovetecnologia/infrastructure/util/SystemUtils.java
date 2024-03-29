package br.com.jovetecnologia.infrastructure.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;

import br.com.jovetecnologia.domain.model.Funcionario;
import br.com.jovetecnologia.domain.model.Usuario;
import br.com.jovetecnologia.infrastructure.util.annotation.Required;
import br.com.jovetecnologia.web.bean.SessionBean;

public class SystemUtils {
	
	/**
	 * Valida o preenchimento de um campo obrigatório por reflection
	 * @author Renan Baggio
	 * @param objeto Objeto com os campos (atributos) a serem validados
	 * @return <b>true</b> se todos campos obrigatórios foram preenchidos
	 */
	public static boolean isCamposObrigatoriosPreenchidos(Object objeto) {
		// Obtendo a classe do objeto e seus atributos
		Class<?> classe = objeto.getClass();
		Field[] atributos = classe.getDeclaredFields();
		boolean camposValidos = true;

		for (Field atributo : atributos) {
			// Tentando obter a annotation Required
			Required required = atributo.getAnnotation(Required.class);

			// Verificando se a anotação estava presente
			if (required != null) {
				// Tornando o atributo "public"
				atributo.setAccessible(true);
				try {
					// Obtendo o valor do atributo
					Object valor = atributo.get(objeto);

					// Verificando o tamanho mínimo (length) para este atributo
					if (valor == null || valor.toString().length() < required.minimo()) {
						// Criando mensagem de validação
						StringBuilder mensagem = new StringBuilder("Mínimo ");
						mensagem.append(required.minimo());
						mensagem.append(" caractere(s) para ");
						mensagem.append(required.label());

						// Adicionando mensagem de validação
						Messages.addError(mensagem.toString());
						camposValidos = false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return camposValidos;
	}
	
	/**
	 * Valida o preenchimento de um campo obrigatório por reflection e retorna uma lista
	 * com os campos obrigatórios não preenchidos.<br>
	 * Retorna uma lista vazia se todos os campos obrigatórios foram preenchidos
	 * @author Renan Baggio
	 * @param objeto Objeto com os campos (atributos) a serem validados
	 * @return <b>true</b> se todos campos obrigatórios foram preenchidos
	 */
	public static List<String> listaCamposObrigatoriosNaoPreenchidos(Object objeto) {
		// Obtendo a classe do objeto e seus atributos
		Class<?> classe = objeto.getClass();
		Field[] atributos = classe.getDeclaredFields();
		List<String> listaCampos = new ArrayList<String>();

		for (Field atributo : atributos) {
			// Tentando obter a annotation Required
			Required required = atributo.getAnnotation(Required.class);

			// Verificando se a anotação estava presente
			if (required != null) {
				// Tornando o atributo "public"
				atributo.setAccessible(true);
				try {
					// Obtendo o valor do atributo
					Object valor = atributo.get(objeto);

					// Verificando o tamanho mínimo (length) para este atributo
					if (valor == null || valor.toString().length() < required.minimo()) {
						// Criando mensagem de validação
						StringBuilder mensagem = new StringBuilder("Mínimo ");
						mensagem.append(required.minimo());
						mensagem.append(" caractere(s) para ");
						mensagem.append(required.label());

						// Adicionando mensagem de validação
						listaCampos.add(mensagem.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listaCampos;
	}
	
	/**
	 * Executa JavaScript no cliente a partir do servidor
	 * @author Renan Baggio
	 * @param function String com a função JavaScript
	 */
	public static void executaJavaScript(final String function) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute(function);
	}
	
	/**
	 * Limita o número de casas decimais para a quantidade desejada
	 * @author Renan Baggio
	 * @param valor double com valor a ser formatado
	 * @param casasDecimais Número de casas decimais
	 * @return double formatado
	 */
	public static double limitaCasasDecimais(double valor, int casasDecimais) {
		String valorString = String.valueOf(valor);
		int qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);
		if (qtdeCasasDecimais > casasDecimais)
			qtdeCasasDecimais = casasDecimais;

		valorString = valorString.substring(0, valorString.indexOf(".") + qtdeCasasDecimais + 1);
		qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);

		return Double.parseDouble(valorString);
	}

	/**
	 * Limita o número de casas decimais para a quantidade desejada
	 * @author Renan Baggio
	 * @param valor double com valor a ser formatado
	 * @param casasDecimais Número de casas decimais
	 * @return String com valor formatado
	 */
	public static String limitaCasasDecimaisString(double valor, int casasDecimais) {
		String valorString = String.valueOf(valor);
		int qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);
		if (qtdeCasasDecimais > casasDecimais)
			qtdeCasasDecimais = casasDecimais;

		valorString = valorString.substring(0, valorString.indexOf(".") + qtdeCasasDecimais + 1);
		qtdeCasasDecimais = valorString.length() - (valorString.indexOf(".") + 1);

		for (int i = qtdeCasasDecimais; i < casasDecimais; i++)
			valorString += "0";

		return valorString;
	}

	/**
	 * Compara duas datas e retorna o número de dias de diferença entre elas.<br />
	 * Diferença = <code>dataHigh - dataLow</code>
	 * @author Renan Baggio
	 * @param dataTeoricamenteMenor Date com a data teoricamente inferior
	 * @param dataTeoricamenteMaior Date com a data teoricamente superior
	 * @return Integer com número de dias de diferença entre as datas
	 */
	public static int getDiferencaDias(Date dataTeoricamenteMenor, Date dataTeoricamenteMaior) {
		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		startTime.setTime(dataTeoricamenteMenor);
		endTime.setTime(dataTeoricamenteMaior);

		int dif_multiplier = 1;

		// Verifica a ordem de início das datas
		if (dataTeoricamenteMenor.compareTo(dataTeoricamenteMaior) < 0) {
			baseTime.setTime(dataTeoricamenteMaior);
			curTime.setTime(dataTeoricamenteMenor);
			dif_multiplier = 1;
		} else {
			baseTime.setTime(dataTeoricamenteMenor);
			curTime.setTime(dataTeoricamenteMaior);
			dif_multiplier = -1;
		}

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando no total de dias. Já leva em consideração ano bissexto
		while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR)
				|| curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {
			int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);
		}

		// Marca que é um saldo negativo ou positivo
		result_months = result_months * dif_multiplier;

		// Retorna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}
	
	/**
	 * Retorna data somada ou subtraida pela quantidade de dias
	 * @author Nicolas Ibanheiz
	 * @param data Data base para a nova data
	 * @param quantidadeDias Quantidade de dias para acrescetar ou retirar da data base
	 * @return Nova data calculada através dos dias informados
	 */
	public static Date getDataAlteradaEmDias(Date data, int quantidadeDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_MONTH, quantidadeDias);
		return calendar.getTime();
	}
	
	/**
	 * Verifica se o CPF informado é válido
	 * @author Renan Baggio
	 * @param CPF String com CPF
	 * @return <b>true</b> se CPF é válido
	 */
	public static boolean isCpfValido(String CPF) {
		if (CPF == null) {
			Messages.addError("CPF informado é inválido");
			return false;
		}

		// Removendo máscara caso haja
		CPF = CPF.replace(".", "");
		CPF = CPF.replace("-", "");

		// Considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11)) {
			Messages.addError("CPF informado é inválido");
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1º Dígito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// Converte o i-esimo caractere do CPF em um numero:
				// Por exemplo, transforma o caractere '0' no inteiro 0 (48 eh a posicao
				// de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // Converte no respectivo caractere numerico

			// Calculo do 2º Dígito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else {
				Messages.addError("CPF informado é inválido");
				return false;
			}

		} catch (InputMismatchException erro) {
			Messages.addFatal("Erro ao validar o CPF");
			return false;
		}
	}

	/**
	 * Verifica se o CNPJ informado é válido
	 * @author Renan Baggio
	 * @param CNPJ String com CNPJ
	 * @return <b>true</b> se CNPJ é válido
	 */
	public static boolean isCnpjValido(String CNPJ) {
		if (CNPJ == null) {
			Messages.addError("CNPJ informado é inválido");
			return false;
		}

		// Removendo máscara caso haja
		CNPJ = CNPJ.replace(".", "");
		CNPJ = CNPJ.replace("/", "");
		CNPJ = CNPJ.replace("-", "");

		// Considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
			Messages.addError("CNPJ informado é inválido");
			return false;
		}

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1º Dígito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// Converte o i-ésimo caractere do CNPJ em um número:
				// Por exemplo, transforma o caractere '0' no inteiro 0 (48 eh a posição
				// de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2º Dígito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else {
				Messages.addError("CNPJ informado é inválido");
				return false;
			}

		} catch (InputMismatchException erro) {
			Messages.addFatal("Erro ao validar o CNPJ");
			return false;
		}
	}
	
	/**
	 * Retorna o valor arredondado e com o número de casas decimais informado
	 * @author Renan Baggio
	 * @param valor Valor a ser arredondado
	 * @param casasDecimais Número de casas decimais
	 * @return double
	 */
	public static double valorArredondado(double valor, int casasDecimais) {
		return new BigDecimal(valor).setScale(casasDecimais, RoundingMode.HALF_DOWN).doubleValue();
	}

	/**
	 * Retorna o valor concatenado entre parte inteira e parte decimal de um campo
	 * @author Renan Baggio
	 * @param parteInteira Parte inteira que compõe o valor
	 * @param parteDecimal Parte decimal que compõe o valor depois da vírgula
	 * @return double
	 */
	public static double valorConcatenado(String parteInteira, String parteDecimal) {
		return Double.parseDouble(parteInteira + "." + parteDecimal);
	}

	/**
	 * Retorna um int com valor aleatório
	 * @author Renan Baggio
	 * @param objeto
	 * @return int aleatório
	 */
	public static int ramdomId() {
		return (int) UUID.randomUUID().getLeastSignificantBits();
	}
	
	/**
	 * Exporta para download o arquivo informado existente no servidor
	 * @author Renan Baggio
	 * @param caminhoArquivo Caminho do arquivo existente
	 * @param nomeArquivo Nome do arquivo
	 * @throws Exception
	 */
	public static void exportaArquivoCriado(String caminhoArquivo, String nomeArquivo) throws Exception {
		// Formatando o nome do arquivo a ser gerado
		nomeArquivo = StringUtils.formataStringParaNomeArquivo(nomeArquivo);

		File arquivo;
		try {
			arquivo = new File(caminhoArquivo);
			InputStream inputStream = new FileInputStream(arquivo);

			// Obtendo o conteúdo do inputStream em bytes
			byte[] conteudoEmBytes = IOUtils.toByteArray(inputStream);
			inputStream.close();

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			OutputStream outputStream = null;

			// Mudando o tipo do Response e anexando o arquivo
			externalContext.responseReset();
			externalContext.setResponseContentType("txt");
			externalContext.setResponseContentLength(conteudoEmBytes.length);
			externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

			// Obtendo os dados do Response
			outputStream = externalContext.getResponseOutputStream();

			// Adicionado o arquivo ao anexo para download
			outputStream.write(conteudoEmBytes, 0, conteudoEmBytes.length);
			outputStream.flush();
			outputStream.close();
			System.out.println(nomeArquivo + " exportado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro fatal ao exportar o arquivo");
			throw e;

		} finally {
			FacesContext.getCurrentInstance().responseComplete();
		}
	}

	/**
	 * Exporta para download um arquivo a partir de seu conteúdo em String, sem a
	 * necessidade de ter um arquivo criado já no servidor
	 * @author Renan Baggio
	 * @param conteudoArquivo Conteúdo do arquivo
	 * @param nomeArquivo Nome do arquivo
	 * @param extensaoArquivo Extensão do arquivo
	 * @throws Exception
	 */
	public static void exportaArquivoStreaming(String conteudoArquivo, String nomeArquivo, String extensaoArquivo)
			throws Exception {
		if (nomeArquivo == "")
			throw new Exception("Nome do arquivo não informado para o arquivo a exportar");

		// Formatando o nome do arquivo a ser gerado
		nomeArquivo = StringUtils.formataStringParaNomeArquivo(nomeArquivo);

		// Obtendo o conteúdo da String em bytes
		byte[] conteudoEmBytes = conteudoArquivo.getBytes();

		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		OutputStream outputStream = null;

		try {
			// Mudando o tipo do Response e anexando o arquivo
			externalContext.responseReset();
			externalContext.setResponseContentType(extensaoArquivo);
			externalContext.setResponseContentLength(conteudoEmBytes.length);
			externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");

			// Obtendo os dados do Response
			outputStream = externalContext.getResponseOutputStream();

			// Adicionado o arquivo ao anexo para download
			outputStream.write(conteudoEmBytes, 0, conteudoEmBytes.length);
			outputStream.flush();
			outputStream.close();
			System.out.println(nomeArquivo + " exportado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro fatal ao exportar o arquivo " + nomeArquivo);
			throw e;

		} finally {
			FacesContext.getCurrentInstance().responseComplete();
		}
	}
	
	/**
	 * Retorna a URL requisitada
	 * @author Renan Baggio
	 * @return String com URL
	 */
	public static String getRequestURL() {
		Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();

		if (request instanceof HttpServletRequest) {
			return ((HttpServletRequest) request).getRequestURL().toString();
		} else {
			return "";
		}
	}
	

	/**
	 * Retorna a instancia do SessionBean da sessão do usuário
	 * @author Joaquim Neto
	 * @return Um objeto SessionBean
	 */
	public static SessionBean getSessionBean() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		return (SessionBean) externalContext.getSessionMap().get("sessionBean");
	}
	
	/**
	 * Retorna o usuário com os dados do usuarioLogado
	 * @author Joaquim Neto
	 * @return Objeto Usuario
	 */
	public static Usuario getUsuarioLogado() {
		return getSessionBean().getUsuarioLogado();
	}
	
	
	/**
	 * Retorna o funcionario logado
	 * @author Joaquim Neto
	 * @return Objeto Funcionario
	 */
	public static Funcionario getFuncionarioLogado() {
		return getSessionBean().getFuncionarioLogado();
	}
	
	/**
	 * Verifica se o usuário está logado
	 * @author Joaquim Neto
	 * @return <b>true</b> se o usuário estiver logado
	 */
	public static boolean isUsuarioLogado() {
		try {
			SessionBean sessionBean = getSessionBean();
			if(sessionBean == null) 
				return false;
			
			// Obtendo o usuário logado
			Usuario usuarioLogado = sessionBean.getUsuarioLogado();
			
			// Se não houver usuário logado, retornar para tela de login
			if (usuarioLogado == null)
				return false;
			
			// Se o usuário não for nulo, então está logado
			return true;
			
		} catch (Exception e) {
			Messages.addFatal("Erro fatal no sistema. Informe o administrador do sistema");
			e.printStackTrace();
			return false;
		}
	}
}