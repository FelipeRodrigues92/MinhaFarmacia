package br.ucb.minhafarmacia.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

import com.mysql.jdbc.Blob;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;
	private String nome;
	private String email;
	private String senha;
	private GregorianCalendar data_nascimento;
	private GregorianCalendar data_cadastro;
	private char sexo;
	
	@OneToMany(mappedBy = "usuario_id" , fetch=FetchType.LAZY)
	private List<Receita> receitas;
	
	@OneToMany(mappedBy = "usuario_id" , fetch=FetchType.LAZY,targetEntity=Medicacao.class)
	private List<Medicacao> medicacoes;
	
	@ManyToMany
	 @JoinTable(name="alertas", joinColumns=
	 {@JoinColumn(name="usuario_id")}, inverseJoinColumns=
	 {@JoinColumn(name="medicacao_id")})
	  private List<Medicacao> medicacao_alerta;
	  
	
	public Usuario() {
		setMedicacoes(new ArrayList<>());
		setReceitas(new ArrayList<>());
	} 
	
	public List<Medicacao> getMedicacoes() {
		return medicacoes;
	}
	public void setMedicacoes(ArrayList<Medicacao> medicacoes) {
		this.medicacoes = medicacoes;
	}

	private static final long serialVersionUID = 1L;

	public List<Receita> getReceitas() {
		return receitas;
	}
	public void setReceitas(ArrayList<Receita> receitas) {
		this.receitas = receitas;
	}
	  
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public GregorianCalendar getData_nascimento() {
		return this.data_nascimento;
	}

	public void setData_nascimento(GregorianCalendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}   
	public GregorianCalendar getData_cadastro() {
		return this.data_cadastro;
	}

	public void setData_cadastro(GregorianCalendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}   
	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}   
   
}
