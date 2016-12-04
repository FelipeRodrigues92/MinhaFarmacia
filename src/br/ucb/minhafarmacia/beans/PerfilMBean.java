package br.ucb.minhafarmacia.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
public class PerfilMBean {
	private Usuario usuario;
	public PerfilMBean(){
		setUsuario(new Usuario());
	}
	public List<Usuario> usuarioPerfil(){
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		List<Usuario> us = new ArrayList<>();
		us.add(usuario);
		return us;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
