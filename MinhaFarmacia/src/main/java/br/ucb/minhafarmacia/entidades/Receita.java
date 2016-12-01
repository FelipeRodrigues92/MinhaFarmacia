package br.ucb.minhafarmacia.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.*;

import com.mysql.jdbc.Blob;

/**
 * Entity implementation class for Entity: Receita
 *
 */
@Entity
@Table(name = "receitas")
public class Receita implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idReceita;
	@Temporal(TemporalType.DATE)
	private Calendar data_cadastro;
	@ManyToOne
	private Usuario usuario_id;
	private static final long serialVersionUID = 1L;

	public Receita() {
		super();
	}   
	public Integer getIdReceita() {
		return this.idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}   
	public Calendar getData_cadastro() {
		return this.data_cadastro;
	}

	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}    
	public Usuario getUsuario() {
		return this.usuario_id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario_id = usuario;
	}
   
}

