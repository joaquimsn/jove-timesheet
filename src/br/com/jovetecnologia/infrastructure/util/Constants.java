package br.com.jovetecnologia.infrastructure.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constants {
	/**
	 * Padrão dd/MM/yyyy
	 */
	public final static String PATTERN_DD_MM_YYYY = "dd/MM/yyyy";
	
	/**
	 * Padrão yyyy-MM-dd
	 */
	public final static String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * Data nula ou vazia no padrão dd/MM/yyyy
	 */
	public final static String PATTERN_DD_MM_YYYY_NULL = "--/--/----";
	
	/**
	 * Padrão HH:mm
	 */
	public final static String PATTERN_HH_MM = "HH:mm";
	
	/**
	 * DateFormat no padrão dd/MM/yyyy
	 */
	public final static DateFormat DATE_FORMAT_BRASIL = new SimpleDateFormat(PATTERN_DD_MM_YYYY);

	/**
	 * DateFormat no padrão yyyy-MM-dd
	 */
	public final static DateFormat DATE_FORMAT_INTERNACIONAL = new SimpleDateFormat(PATTERN_YYYY_MM_DD);
	
	/**
	 * DateFormat no padrão dd/MM/yyyy HH:mm
	 */
	public final static DateFormat DATETIME_FORMAT_BRASIL = new SimpleDateFormat(PATTERN_DD_MM_YYYY + " " + PATTERN_HH_MM);
	
	/**
	 * DateFormat no padrão HH:mm
	 */
	public final static DateFormat TIME_FORMAT = new SimpleDateFormat(PATTERN_HH_MM);
	
	/**
	 * Byte Order Mark em UTF-8 (EF BB BF)
	 */
	public static final String UTF8_BOM = "\uFEFF";
}