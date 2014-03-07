package br.com.jovetecnologia.infrastructure.util;

import java.io.File;
import java.text.Normalizer;

public class StringUtils {

public static final char SEPARATOR = File.separatorChar;
	
	/**
	 * Normaliza a string removendo acentos
	 * @author Renan Baggio
	 * @param string String a ser normalizada
	 * @return String
	 */
	public static String normalizaString(String string) {
		String stringNormalizada = Normalizer.normalize(string, Normalizer.Form.NFD);
		return stringNormalizada.replaceAll("[^\\p{ASCII}]","");
	}
	
	/**
	 * Formata a string para nome de arquivo removendo os caracteres 
	 * especiais não permitidos para nomes de arquivos
	 * @author Renan Baggio
	 * @param string String a ser formatada
	 * @return String
	 */
	public static String formataStringParaNomeArquivo(String string) {
		String stringFormatada = normalizaString(string);
		
		// Substitui os caracteres não permitidos
		stringFormatada = stringFormatada.replaceAll("\\\\", "");
		stringFormatada = stringFormatada.replaceAll("/", "");
		stringFormatada = stringFormatada.replaceAll(":", "");
		stringFormatada = stringFormatada.replaceAll("\\*", "");
		stringFormatada = stringFormatada.replaceAll("\\?", "");
		stringFormatada = stringFormatada.replaceAll("\"", "");
		stringFormatada = stringFormatada.replaceAll("<", "");
		stringFormatada = stringFormatada.replaceAll(">", "");
		stringFormatada = stringFormatada.replaceAll("|", "");
		return stringFormatada.replaceAll(" ", "_");
	}
	
	/**
	 * Remove os caracteres do padrão informado dentro da String 
	 * usando String.replace
	 * @author Renan Baggio
	 * @param string String a ser removido os caracteres
	 * @param padraoParaRemover Padrão de caracteres a remover
	 * @return String
	 */
	public static String removeCaracteres(String string, String... padraoParaRemover) {
		for(String padrao : padraoParaRemover) {
			string = string.replace(padrao, "");
		}
		return string;
	}
	
	/**
	 * Remove os caracteres do padrão informado do início e final da String 
	 * usando StringUtils de commons.lang
	 * @author Renan Baggio
	 * @param string String a ser removido os caracteres
	 * @param padraoParaRemover Padrão de caracteres a remover
	 * @return String
	 */
	public static String removeCaracteresInicio(String string, String... padraoParaRemover) {
		for(String padrao : padraoParaRemover) {
			string = org.apache.commons.lang3.StringUtils.stripStart(string, padrao);
		}
		return string;
	}
	
	/**
	 * Remove os caracteres do padrão informado do início da String
	 * @param string String a ser removido os caracteres
	 * @author Renan Baggio
	 * @param padraoParaRemover Padrão de caracteres a remover
	 * @return String
	 */
	public static String removeCaractereInicio(String string, String padraoParaRemover) {
		return org.apache.commons.lang3.StringUtils.stripStart(string, padraoParaRemover);
	}
	
	/**
	 * Remove os caracteres do padrão informado do final da String
	 * @param string String a ser removido os caracteres
	 * @author Renan Baggio
	 * @param padraoParaRemover Padrão de caracteres a remover
	 * @return String
	 */
	public static String removeCaractereFinal(String string, String padraoParaRemover) {
		if(padraoParaRemover == null || padraoParaRemover.equals("")) 
			return string;
		
		while(string.endsWith(padraoParaRemover)) {
			string = string.substring(0, string.lastIndexOf(padraoParaRemover));
		}
		
		return string;
	}
	
	/**
	 * Remove os caracteres do padrão informado do início e final da String 
	 * usando StringUtils de commons.lang
	 * @author Renan Baggio
	 * @param string String a ser removido os caracteres
	 * @param padraoParaRemover Padrão de caracteres a remover
	 * @return String
	 */
	public static String removeCaractereInicioFinal(String string, String padraoParaRemover) {
		string = org.apache.commons.lang3.StringUtils.stripEnd(string, padraoParaRemover);
		return org.apache.commons.lang3.StringUtils.stripStart(string, padraoParaRemover);
	}
	
	/**
	 * Remove os caracteres de espaço em branco do início e final da String
	 * @author Renan Baggio
	 * @param string String a ser removido os caracteres em branco
	 * @return String
	 */
	public static String removeEspacosVazios(String string) {
		return removeCaractereInicioFinal(string, " ");
	}
	
	/**
	 * Remove os caracteres de zero (0) do início da String
	 * @author Renan Baggio
	 * @param string String a ser removido os caracteres zero (0)
	 * @return String
	 */
	public static String removeZerosInicio(String string) {
		return removeCaractereInicio(string, "0");
	}
	
	/**
	 * Retorna a String de valor inteiro formatado com ponto separador de milhar
	 * @author Renan Baggio
	 * @param inteiro String de valor inteiro <b>(int / java.lang.Integer)</b>
	 * @return String formatada
	 */
	public static String formataMilhar(String inteiro) {
		if(inteiro == null || inteiro.length() < 4) 
			return inteiro;
		
		StringBuilder valor = new StringBuilder();
		
		for(int i = inteiro.length() - 1, y = 0; i >= 0; i--, y++) {
			if(y % 3 == 0 && y != 0) {
				valor.append(".");
			}
			valor.append(inteiro.charAt(i));
		}
		return inverterString(valor.toString());
	}
	
	/**
	 * Inverte a cadeia de caracteres da String
	 * @author Renan Baggio
	 * @param valor String a ser invertida
	 * @return String invertida
	 */
	public static String inverterString(String valor) {
		if(valor == null || valor.length() < 2) 
			return valor;
		
		String retorno = "";
		for(int i = valor.length() - 1; i >= 0; i--) {
			retorno += valor.charAt(i);
		}
		return retorno;
	}
	
	/**
	 * Calcula a porcentagem de correspondência entre duas strings (matcher)
	 * utilizando o algoritmo Levenshtein Distance como base parta a seguinte fórmula:
	 * <pre>(1 - (levenshteinDistance / lengthStringMaior)) * 100</pre>
	 * @author Renan Baggio
	 * @param string1
	 * @param string2
	 * @return porcentagem em double com duas casas decimais
	 */
	public static double calculaCorrespondenciaEntreStrings(String string1, String string2) {
		// Removendo caracteres especiais comuns em logradouros
		string1 = StringUtils.removeCaracteres(string1.toUpperCase(), ".", ",", "/", "'", "-");
		string2 = StringUtils.removeCaracteres(string2.toUpperCase(), ".", ",", "/", "'", "-");
		
		// Removendo os espaços do início e final
		string1 = StringUtils.removeCaractereInicioFinal(string1, " ");
		string2 = StringUtils.removeCaractereInicioFinal(string2, " ");
		
		double lengthStringMaior = 0;
		double levenshteinDistance = 0;
		
		if(string1.length() > string2.length()) {
			lengthStringMaior = string1.length();
		} else {
			lengthStringMaior = string2.length();
		}
		
		// Calculando o índice de distância de Levenshtein
		levenshteinDistance = org.apache.commons.lang3.StringUtils.getLevenshteinDistance(string1, string2);
		
		// Fórmula para obtenção da porcentagem de correspondência: (1 - (levenshteinDistance / lengthStringMaior)) * 100
		double porcentagem = SystemUtils.valorArredondado((1 - (levenshteinDistance / lengthStringMaior)) * 100, 2);
		System.out.println("Correspondência entre " + string1 + " e " + string2 + ": " + porcentagem);
		return porcentagem;
	}
	
	/**
	 * Remove BOM (Byte Mark Order) de arquivos em UTF-8
	 * @author Renan Baggio
	 * @param conteudoArquivo
	 * @return String Conteúdo do arquivo sem BOM
	 */
	public static String removeUTF8BOM(String conteudoArquivo) {
        if (conteudoArquivo.startsWith(Constants.UTF8_BOM)) {
            conteudoArquivo = conteudoArquivo.substring(1);
        }
        return conteudoArquivo;
    }
}