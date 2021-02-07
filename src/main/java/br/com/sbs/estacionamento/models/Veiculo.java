package br.com.sbs.estacionamento.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	@Enumerated(value = EnumType.STRING)
	private CorVeiculo cor;
	private String placa;
	@Enumerated(value = EnumType.STRING)
	private TipoVeiculo tipo;

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

}
