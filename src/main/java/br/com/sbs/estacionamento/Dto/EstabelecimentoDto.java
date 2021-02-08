package br.com.sbs.estacionamento.Dto;

public class EstabelecimentoDto {
	
	private String nome;
	private String cnpj;
	private Integer vagasParaCarro;
	private Integer vagasParaMoto;
	private String telefone;
	private String endereco;
	
	public EstabelecimentoDto() {
		// TODO Auto-generated constructor stub
	}

	public EstabelecimentoDto(String nome, String cnpj, Integer vagasParaCarro, Integer vagasParaMoto, String telefone,
			String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.vagasParaCarro = vagasParaCarro;
		this.vagasParaMoto = vagasParaMoto;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getVagasParaCarro() {
		return vagasParaCarro;
	}

	public void setVagasParaCarro(Integer vagasParaCarro) {
		this.vagasParaCarro = vagasParaCarro;
	}

	public Integer getVagasParaMoto() {
		return vagasParaMoto;
	}

	public void setVagasParaMoto(Integer vagasParaMoto) {
		this.vagasParaMoto = vagasParaMoto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
