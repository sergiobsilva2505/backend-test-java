package br.com.sbs.estacionamento.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	private Integer vagasParaCarro;
	private Integer vagasParaMoto;
	private String telefone;
	private String endereco;
	
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Estabelecimento() {

	}

	public Estabelecimento(Integer id, String nome, String cnpj, Integer vagasParaCarro, Integer vagasParaMoto,
			String telefone, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.vagasParaCarro = vagasParaCarro;
		this.vagasParaMoto = vagasParaMoto;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Estabelecimento(String nome, String cnpj, Integer vagasParaCarro, Integer vagasParaMoto,
			String telefone, String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.vagasParaCarro = vagasParaCarro;
		this.vagasParaMoto = vagasParaMoto;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
