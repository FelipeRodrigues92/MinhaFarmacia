package br.ucb.minhafarmacia.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;

@ManagedBean
public class ListagemMBean {
	public ListagemMBean(){
		
	}
	public List<Medicacao> medicamentos(){
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		List<Medicacao> arrayMedicamentos = new ArrayList<>();
		arrayMedicamentos.addAll(new UsuarioDAO().buscaDadosUsuario(usuario.getEmail()).getMedicacoes());
		return arrayMedicamentos;
	}
	public String detalharDosagem(Medicacao m){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("medicamentoDetalhar", m); // coloca na sessao
		System.out.println("aqui");
		return "/detalhaDosagem.xhtml?faces-redirect=true";
	}
	
	public List<Medicacao> detalhaMedicamento(){
		Medicacao medicacao = (Medicacao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("medicamentoDetalhar");
		List<Medicacao> ms = new ArrayList<>();
		ms.add(medicacao);
		return ms;
	}
}
