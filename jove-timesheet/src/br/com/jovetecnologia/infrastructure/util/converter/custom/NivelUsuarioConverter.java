package br.com.jovetecnologia.infrastructure.util.converter.custom;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jovetecnologia.domain.enums.NivelUsuarioEnum;

@FacesConverter(value = "nivelUsuarioConverter")
public class NivelUsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return NivelUsuarioEnum.getValueByDisplay(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof String)
			return String.valueOf(arg2);
		return NivelUsuarioEnum.getDisplayByValue(Integer.parseInt(String.valueOf(arg2).trim()));
	}
}