package br.com.jovetecnologia.infrastructure.util.converter.basic;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="doubleConverter")
public class DoubleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			return Double.parseDouble(arg2.replace(".", "").replace(",", "."));
		} catch (java.lang.NumberFormatException e) {
			return "";
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(null == arg2 || "".equals(arg2.toString().trim()) || "0.0".equals(arg2.toString().trim())) {
			return "0,0";			
		}
		StringBuilder valor = new StringBuilder();
		String numeroReal = String.valueOf(arg2).replace(".", ",");
		
		if(numeroReal.contains(",")) {
			String inteiros = numeroReal.split(",")[0];
			String centavos = numeroReal.split(",")[1];
			for(int i = inteiros.length() - 1, y = 0; i >= 0; i--, y++) {
				if(y % 3 == 0 && y != 0) {
					valor.append(".");
				}
				valor.append(inteiros.charAt(i));
			}
			return inverterString(valor.charAt(0) == '.' ? valor.substring(1, valor.length()) : valor.toString()) + "," + centavos;
		
		} else {
			for(int i = numeroReal.length() - 1, y = 0; i >= 0; i--, y++) {
				if(y % 3 == 0 && y != 0) {
					valor.append(".");
				}
				valor.append(numeroReal.charAt(i));
			}
			return inverterString(valor.toString());
		}
	}	
	
	/**
	 * Inverte a cadeia de caracteres
	 * @param valor
	 * @return String invertida
	 */
	private String inverterString(String valor) {
		String retorno = "";
		for(int i = valor.length() - 1; i >= 0; i--) {
			retorno += valor.charAt(i);
		}
		return retorno;
	}
}