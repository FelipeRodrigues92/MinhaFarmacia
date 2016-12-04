package br.ucb.minhafarmacia.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.dao.DAO;
import br.ucb.minhafarmacia.dao.MedicamentoDAO;
import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.ws.BuscaMedicamentoWS;

@ManagedBean
public class MedicacaoMBean {

	private Medicacao medicacao = new Medicacao();
	private String cod;
	private String restricao;
	private Integer idUsuario;
	private String hora;
	private String dataInicio;
	public void buscar() {
		// System.out.println(usuario.getNome());
		System.out.println("buscar " + medicacao.getCod_barras());
		BuscaMedicamentoWS busca = new BuscaMedicamentoWS();
		setMedicacao(busca.buscaMedicamento(medicacao.getCod_barras()));
	}

	public String gravarMedicamento() throws ParseException {
		// new DAO<Usuario>(Usuario.class);
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		getMedicacao().setUsuario_id(usuario);
		getMedicacao().setData_cadastro((GregorianCalendar) Calendar.getInstance());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("medicamento", getMedicacao()); // coloca na sessao
//		new MedicamentoDAO().cadastrar(getMedicacao());
//		new UsuarioDAO().alterar(usuario);
		return "/cadastraDosagem.xhtml?faces-redirect=true";
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getRestricao() {
		return restricao;
	}

	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Medicacao getMedicacao() {
		return medicacao;
	}

	public List<Usuario> getUsuarios() {
		return new DAO<Usuario>(Usuario.class).listar();
	}

	public void gravar() {
		System.out.println("Gravou" + this.medicacao.getNome());
		new DAO<Medicacao>(Medicacao.class).cadastrar(this.medicacao);
		this.medicacao = new Medicacao();
	}

	public void setMedicacao(Medicacao medicacao) {
		this.medicacao = medicacao;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}



}
