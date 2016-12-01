package br.ucb.minhafarmacia.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ucb.minhafarmacia.dao.DAO;
import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
@ViewScoped
public class MedicacaoMBean {

	private Medicacao medicacao = new Medicacao();
	private Integer idUsuario;
	
	public void gravarUsuario(){
		new DAO<Usuario>(Usuario.class);
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Medicacao getMedicacao(){
		return medicacao;
	}

	public Usuario getThisUsuario(){
		return this.medicacao.getUsuario_id();
	}
	public List<Usuario> getUsuarios(){
		return new UsuarioDAO().listar();
		//return new DAO<Usuario>(Usuario.class).listar();
	}
	public void gravarAutor(){
		Usuario usuario = new UsuarioDAO().consultar(this.idUsuario);
		this.medicacao.setUsuario_id(usuario);
		System.out.print("Escrito por " + usuario.getNome());
	}

	public void gravar() {
		System.out.println("Gravou" + this.medicacao.getNome());
		new DAO<Medicacao>(Medicacao.class).cadastrar(this.medicacao);
		this.medicacao = new Medicacao();
	}
}
