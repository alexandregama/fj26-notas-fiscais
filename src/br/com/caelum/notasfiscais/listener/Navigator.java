package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class Navigator {

	@Inject
	private FacesContext context;

	public void redirectTo(String urlToRedirect) {
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, urlToRedirect);
		context.renderResponse();
	}
	
	
}
