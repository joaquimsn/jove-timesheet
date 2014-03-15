package br.com.jovetecnologia.infrastructure.util.converter.basic;

import java.text.ParseException;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jovetecnologia.infrastructure.util.Constants;

@FacesConverter(value="timeConverter")
public class TimeConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if(arg2 == null || arg2.equals("")) { return null; } 
		try {
			Date data = Constants.TIME_FORMAT.parse(arg2);
			return data;
		} catch (ParseException e) {e.printStackTrace();}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null) { return null; }
		String data = Constants.TIME_FORMAT.format(arg2);
		return data.replace("-", "às");
	}
}