package br.com.caelum.notasfiscais.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextFactory {

	@Produces @RequestScoped
	public FacesContext create() {
		return FacesContext.getCurrentInstance();
	}
	
}
