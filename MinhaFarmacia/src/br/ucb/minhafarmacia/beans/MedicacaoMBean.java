package br.ucb.minhafarmacia.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.ucb.minhafarmacia.dao.DAO;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
public class MedicacaoMBean {
//linha comentada
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
	
	public List<Usuario> getUsuarios(){
		return new DAO<Usuario>(Usuario.class).listar();
	}

	public void gravar() {
		System.out.println("Gravou" + this.medicacao.getNome());
		new DAO<Medicacao>(Medicacao.class).cadastrar(this.medicacao);
		this.medicacao = new Medicacao();
	}
}
