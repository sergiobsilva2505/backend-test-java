package br.com.sbs.estacionamento.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;

/**
 * Modelo para o objeto veiculo
 * 
 * @author sergi
 *
 */
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Campo marca é obrigatório")
	private String marca;
	
	@NotBlank(message = "Campo modelo é obrigatório")
	private String modelo;

//	@NotBlank(message = "Campo cor é obrigatório")
	@Enumerated(value = EnumType.STRING)
	private CorVeiculo cor;
	
	@NotBlank(message = "Campo placa é obrigatório")
	private String placa;

//	@NotBlank(message = "campo tipo é obrigatório")
	@Enumerated(value = EnumType.STRING)
	private TipoVeiculo tipo;

	@JsonIgnore
	@OneToMany(mappedBy = "veiculo")
	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Veiculo() {

	}

	public Veiculo(Integer id, String marca, String modelo, CorVeiculo cor, String placa, TipoVeiculo tipo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Veiculo(String marca, String modelo, CorVeiculo cor, String placa, TipoVeiculo tipo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public CorVeiculo getCor() {
		return cor;
	}

	public void setCor(CorVeiculo cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
