package br.ucb.minhafarmacia.beans;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.minhafarmacia.entidades.Dose;
import br.ucb.minhafarmacia.entidades.Medicacao;
import br.ucb.minhafarmacia.entidades.Usuario;


@ManagedBean
@SessionScoped
public class DoseMBeanAPAGAR {
	private Dose dose;
	private String dataInicio;
	private String horaInicio;
	
	public DoseMBeanAPAGAR(){
		setDose(new Dose());
	}

	
	
	
	public String gravarDoseMedicamento() throws ParseException {
		System.out.println("ENTREI AKIIIII");
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		Medicacao medicamento = (Medicacao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("medicamento");
		
		System.out.println("Usuario ->"+usuario.getNome());
		System.out.println("Medicamento ---->"+medicamento.getLaboratorio());
		System.out.println(getDataInicio());
		System.out.println(getHoraInicio());
		
		return "";
	}
//	public void cadastrarDose(){
//		System.out.println("aki");
//
//		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
//				.get("usuario");
//		Medicacao medicamento = (Medicacao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
//				.get("medicamento");
//		System.out.println("Usuario ->"+usuario.getNome());
//		System.out.println("Medicamento ---->"+medicamento.getLaboratorio());
//	
//	}
	
	
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


	public Dose getDose() {
		return dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	
}
