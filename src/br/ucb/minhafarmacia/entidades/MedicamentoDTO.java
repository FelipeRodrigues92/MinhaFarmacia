package br.ucb.minhafarmacia.entidades;

public class MedicamentoDTO {
	private String codBarraEan;
	private String principioAtivo;
	private String cnpj;
	private String laboratorio;
	private String produto;
	private String apresentacao;
	private String classeTerapeutica;
	private String restricao;
	
	public String getCodBarraEan() {
		return codBarraEan;
	}
	public void setCodBarraEan(String codBarraEan) {
		this.codBarraEan = codBarraEan;
	}
	public String getPrincipioAtivo() {
		return principioAtivo;
	}
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getApresentacao() {
		return apresentacao;
	}
	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}
	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}
	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}
	public String getRestricao() {
		return restricao;
	}
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	
	
	
}
