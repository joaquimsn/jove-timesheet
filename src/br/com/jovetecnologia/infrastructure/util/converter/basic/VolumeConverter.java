package br.com.jovetecnologia.infrastructure.util.converter.basic;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="volumeConverter")
public class VolumeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(null == arg2 ||  "".equals(arg2)) {
			arg2 = "0,0";
		}
		double peso = Double.parseDouble(arg2.replace(".", "").replace(",", "."));
		return peso;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(null == arg2 || "".equals(arg2.toString().trim()) || "0".equals(arg2.toString().trim())) {
			arg2 = "0.0";			
		}
		String volume = String.valueOf(arg2).replace(".", ",");		
		if(volume.contains(",")) {
			volume += "00000";
			volume = volume.substring(0, volume.indexOf(",") + 6);
		}
		
		String quilos = volume.split(",")[0];
		String gramas = volume.split(",")[1];
		StringBuilder valor = new StringBuilder();
		for(int i = quilos.length() - 1, y = 0; i >= 0; i--, y++) {
			if(y % 3 == 0 && y != 0) {
				valor.append(".");
			}
			valor.append(quilos.charAt(i));
		}
				
		return inverterString(valor.charAt(0) == '.' ? valor.substring(1, valor.length()) : valor.toString()) + "," + gramas;
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