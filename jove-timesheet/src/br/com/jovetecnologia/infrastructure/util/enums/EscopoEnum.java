package br.com.jovetecnologia.infrastructure.util.enums;

import java.util.ArrayList;
import java.util.List;

public enum EscopoEnum {
	
	PROJETO("Projeto", 1),
	ATIVIDADE("Atividade", 2),
	TAREFA("Tarefa", 3);
	
	private String display;
	private int value;

	private EscopoEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static int getValueByDisplay(String display) {
		for (EscopoEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(int value){
		for (EscopoEnum objeto : values()) {
			if (objeto.getValue() == value) {
				return objeto.getDisplay();
			}
		}
		return null;
	}
	
	public static List<String> getDisplayList() {
		List<String> listDisplay = new ArrayList<String>();
		for (EscopoEnum objeto : values()) {
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
