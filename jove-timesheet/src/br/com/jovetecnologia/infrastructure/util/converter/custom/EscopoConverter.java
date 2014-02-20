package br.com.jovetecnologia.infrastructure.util.converter.custom;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jovetecnologia.infrastructure.util.enums.EscopoEnum;

@FacesConverter(value="escopoConverter")
public class EscopoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return EscopoEnum.getValueByDisplay(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(arg2);
	}
	
}
