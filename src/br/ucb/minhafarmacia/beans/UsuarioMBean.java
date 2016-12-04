package br.ucb.minhafarmacia.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	private Usuario usuario = new Usuario();
	private String dataNascimento;
	

	public String gravar() throws ParseException {
		getUsuario().setData_nascimento((GregorianCalendar) converteStringCalendar(getDataNascimento()));
		getUsuario().setData_cadastro((GregorianCalendar) Calendar.getInstance());
		
		new UsuarioDAO().cadastrar(getUsuario());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", getUsuario()); // coloca na sessao
		//usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); recuperar da sessao


		setUsuario(new Usuario());
		return "listagem.xhtml";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuario(){
		return usuario;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	private static Calendar converteStringCalendar(String data) throws ParseException{
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		 
		 
		Calendar c = Calendar.getInstance();
		c.setTime(formatoData.parse(data));
		return c;
	}
}
