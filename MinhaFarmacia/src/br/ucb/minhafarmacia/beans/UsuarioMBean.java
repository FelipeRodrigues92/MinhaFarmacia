package br.ucb.minhafarmacia.beans;

import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;

import br.ucb.minhafarmacia.dao.DAO;
import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
public class UsuarioMBean {
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return usuario;
	}
//Linha comentada pra fazer commit
	public void gravar() {
		System.out.println("Gravou" + this.usuario.getNome());
		new DAO<Usuario>(Usuario.class).cadastrar(this.usuario);
		this.usuario = new Usuario();
	}
}
