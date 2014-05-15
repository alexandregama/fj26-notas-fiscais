package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Fases implements PhaseListener {

	private static final long serialVersionUID = 849917237485375945L;

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Antes da fase");
		System.out.println(event.getPhaseId());
		System.out.println("Depois da fase");
	}
	
	@Override 
	public void afterPhase(PhaseEvent event) {
		System.out.println("Antes da fase");
		System.out.println(event.getPhaseId());
		System.out.println("Depois da fase");
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
