package br.ucb.minhafarmacia.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

import com.mysql.jdbc.Blob;

/**
 * Entity implementation class for Entity: Medicacao
 *
 */
@Entity
@Table(name = "medicacoes")
public class Medicacao implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMedicamento;
	private String cod_barras;
	private String nome;
	private String classe_terapeutica;
	private String principio_ativo;
	private boolean restricao;
	@Temporal(TemporalType.DATE)
	private Calendar data_cadastro = Calendar.getInstance();
	
	@ManyToOne
	private Usuario usuario_id;
	
	@OneToMany(mappedBy = "medicacao_id" , fetch=FetchType.LAZY,targetEntity=Dose.class)
	private List<Dose> doses;
	
	@ManyToMany
	private List<Usuario> usuario_alerta;
	
	private static final long serialVersionUID = 1L;

	public Medicacao() {
		super();
	}   
	public Integer getIdMedicamento() {
		return this.idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento) {
		this.idMedicamento = idMedicamento;
	}   
	public String getCod_barras() {
		return this.cod_barras;
	}

	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getClasse_terapeutica() {
		return this.classe_terapeutica;
	}

	public void setClasse_terapeutica(String classe_terapeutica) {
		this.classe_terapeutica = classe_terapeutica;
	}   
	public String getPrincipio_ativo() {
		return this.principio_ativo;
	}

	public void setPrincipio_ativo(String principio_ativo) {
		this.principio_ativo = principio_ativo;
	}   
	public boolean getRestricao() {
		return this.restricao;
	}

	public void setRestricao(boolean restricao) {
		this.restricao = restricao;
	}   
	public Calendar getData_cadastro() {
		return this.data_cadastro;
	}

	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}   
	public Usuario getUsuario_id() {
		return this.usuario_id;
	}

	public void setUsuario_id(Usuario usuario) {
		this.usuario_id = usuario;
	}
   
}
