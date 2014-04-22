package br.com.jovetecnologia.infrastructure.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Criptografa senha com MD5
 * @author joaquim
 *
 */
public class Criptografia {
	
	private static MessageDigest messageDigest;
	
	static {
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Faz a criptografia
	 * @param text seguência que será criptografada
	 * @return senha criptografada
	 */
	private static char[] hexcodes(byte[] text ) {
		char[] hexOutput = new char[text.length * 2];
		String hexString;
		
		//Monta o padrão da criptografia
		for (int i = 0; i < text.length; i++) {
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() -2, hexString.length(), hexOutput, i * 2);
		}
		
		return hexOutput;
	}
	
	
	/**
	 * Criptografa a senha
	 * @param senha que será criptografada
	 * @return Senha criptografada
	 */
	public static String criptografar(String senha) {
		if (messageDigest != null) {
			return new String(hexcodes(messageDigest.digest(senha.getBytes())));
		}
		
		return null;
	}

}
