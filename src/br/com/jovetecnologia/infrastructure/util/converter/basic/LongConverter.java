package br.com.jovetecnologia.infrastructure.util.converter.basic;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="longConverter")
public class LongConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		try {
			return Long.parseLong(arg2);
		} catch (java.lang.NumberFormatException e) {
			return "";
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {		
		return String.valueOf(arg2);
	}
}