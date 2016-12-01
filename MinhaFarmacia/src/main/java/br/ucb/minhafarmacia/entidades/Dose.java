package br.ucb.minhafarmacia.entidades;

import br.ucb.minhafarmacia.entidades.Medicacao;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dose
 *
 */
@Entity
@Table(name = "doses")
public class Dose implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idDose;
	private Integer quantidade;
	private String tipo;
	@Temporal(TemporalType.DATE)
	private Calendar data_inicio;
	@Temporal(TemporalType.DATE)
	private Calendar hora_inicio;
	private Integer intervalo;
	private Integer periodo_consumo;
	@ManyToOne
	private Medicacao medicacao_id;
	private static final long serialVersionUID = 1L;

	public Dose() {
		super();
	}   
	public Integer getIdDose() {
		return this.idDose;
	}

	public void setIdDose(Integer idDose) {
		this.idDose = idDose;
	}   
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}   
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}   
	public Calendar getData_inicio() {
		return this.data_inicio;
	}

	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}   
	public Calendar getHora_inicio() {
		return this.hora_inicio;
	}

	public void setHora_inicio(Calendar hora_inicio) {
		this.hora_inicio = hora_inicio;
	}   
	public Integer getIntervalo() {
		return this.intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}   
	public Integer getPeriodo_consumo() {
		return this.periodo_consumo;
	}

	public void setPeriodo_consumo(Integer periodo_consumo) {
		this.periodo_consumo = periodo_consumo;
	}   
	public Medicacao getMedicacao_id() {
		return this.medicacao_id;
	}

	public void setMedicacao_id(Medicacao medicacao_id) {
		this.medicacao_id = medicacao_id;
	}
   
}
