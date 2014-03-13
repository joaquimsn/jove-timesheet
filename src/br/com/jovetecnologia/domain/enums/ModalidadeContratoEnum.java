package br.com.jovetecnologia.domain.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Contem os escopos que serão exibidos nos combo box.
 * @author Joaquim Neto
 *
 */
public enum ModalidadeContratoEnum {
	
	ESTAGIARIO("Estagiário", 1),
	EFETIVO("Efetivo", 2),
	TERCERIZADO("Tecerizado", 3);
	
	private String display;
	private int value;

	private ModalidadeContratoEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static int getValueByDisplay(String display) {
		for (ModalidadeContratoEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(int value){
		for (ModalidadeContratoEnum objeto : values()) {
			if (objeto.getValue() == value) {
				return objeto.getDisplay();
			}
		}
		return null;
	}
	
	public static List<String> getDisplayList() {
		List<String> listDisplay = new ArrayList<String>();
		for (ModalidadeContratoEnum objeto : values()) {
			listDisplay.add(objeto.display);
		}
		return listDisplay;
	}
	
	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
