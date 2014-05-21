package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = 7816010528258775566L;

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public void desloga() {
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
