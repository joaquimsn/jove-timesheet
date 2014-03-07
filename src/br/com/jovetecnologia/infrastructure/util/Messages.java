package br.com.jovetecnologia.infrastructure.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class Messages {
	
	public static void addInfo(String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", detail));
	}

	public static void addWarn(String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", detail));
	}

	public static void addError(String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", detail));
	}

	public static void addFatal(String detail) {
		RequestContext.getCurrentInstance().addCallbackParam("businessError", true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "", detail));
	}
}