package br.ucb.minhafarmacia.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.utilidades.RecuperarSenha;

@ManagedBean
public class LoginMBean {
	private String email;
	private String senha;
	private String recuperarSenha;
	
	public String login(){
		System.out.println("login "+getEmail());
		System.out.println("Senha "+getSenha());
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.fazLogin(getEmail(), getSenha());
//		System.out.println(u.getNome());
		if(u != null){
			System.out.println("irei redirecionar");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u); // coloca na sessao
			return "/listagem.xhtml?faces-redirect=true";
		}else{
			System.out.println("nao irei redirecionar");

			return "";
		}
	}
	
	
	public String getRecuperarSenha() {
		return recuperarSenha;
	}


	public void setRecuperarSenha(String recuperarSenha) {
		this.recuperarSenha = recuperarSenha;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String login) {
		this.email = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void recuperarSenha(){
		Usuario u = new UsuarioDAO().buscaDadosUsuario(getRecuperarSenha());
		if(u != null){
			System.out.println("Enviando email .....");
			RecuperarSenha rec = new RecuperarSenha();
			rec.setDestinatario(u.getEmail());
			rec.setAssunto("Recuperação de Senha");
			rec.setMsg(u.getSenha());
			rec.SendEmail();
		}else{
			System.out.println("nao vou enviar");
		}
		
	}
	
	
	
}
