package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

public class AutenticadorListener implements PhaseListener {

	private static final long serialVersionUID = 5332703415334395849L;

	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Override
	public void beforePhase(PhaseEvent event) {
			
	}
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		String pagina = context.getViewRoot().getViewId();
		if (pagina.contains("login.xhtml")) {
			return;
		}
		
		if (!usuarioLogado.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
		
	}
	
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
