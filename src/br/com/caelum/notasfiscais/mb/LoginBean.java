package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1410748902384124487L;

	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	public String efetuaLogin() {
		if (dao.existe(usuario)) {
			return "produto?faces-redirect=true";
		}
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
