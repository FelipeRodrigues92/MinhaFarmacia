package br.ucb.minhafarmacia.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.dao.DAO;
import br.ucb.minhafarmacia.dao.MedicamentoDAO;
import br.ucb.minhafarmacia.dao.UsuarioDAO;
import br.ucb.minhafarmacia.entidades.Dose;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;
import br.ucb.minhafarmacia.ws.BuscaMedicamentoWS;

@ManagedBean
public class DoseManagedBeam {

	private Dose dose = new Dose();
	private String dataInicio;
	private String horaInicio;
	public void buscar() {
	}

	public String gravarMedicamento() throws ParseException {
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		Medicacao medicamento = (Medicacao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("medicamento");
		
		getDose().setData_inicio((GregorianCalendar) converteStringCalendar(getDataInicio()));
		getDose().setHora_inicio((GregorianCalendar) converteStringHora(getHoraInicio()));
		System.out.println(getDose().getData_inicio());
		System.out.println(getDose().getHora_inicio());
		
		medicamento.setDose(getDose());
		getDose().setMedicacao_id(medicamento);
		new MedicamentoDAO().cadastrar(medicamento);
		new UsuarioDAO().alterar(usuario);
//		return "/cadastraDosagem.xhtml?faces-redirect=true";
		return "/listagem.xhtml?faces-redirect=true";
	}

	public Dose getDose() {
		return dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	private static Calendar converteStringHora(String hora) throws ParseException {
		SimpleDateFormat formatoData = new SimpleDateFormat("HH:mm");

		Calendar c = Calendar.getInstance();
		c.setTime(formatoData.parse(hora));
		return c;
	}

	private static Calendar converteStringCalendar(String data) throws ParseException {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();
		c.setTime(formatoData.parse(data));
		return c;
	}

	
	
}
