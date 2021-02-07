package br.com.sbs.estacionamento.VeiculoDto;

import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;

public class VeiculoDto {

	private String marca;
	private String modelo;
	private CorVeiculo cor;
	private String placa;
	private TipoVeiculo tipo;

	public VeiculoDto() {
		
	}

	public VeiculoDto(String marca, String modelo, CorVeiculo cor, String placa, TipoVeiculo tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
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
