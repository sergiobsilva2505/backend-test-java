package br.com.sbs.estacionamento.models;

import java.time.Duration;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant horaEntrada;
	private Instant horaSaida;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;

	private Long segundosEstacionado;

	public Movimentacao() {

	}

	public Movimentacao(Veiculo veiculo, Estabelecimento estabelecimento) {
		this.horaEntrada = Instant.now();
		this.veiculo = veiculo;
		this.estabelecimento = estabelecimento;
	}

	public Long getTempoDeUso() {
		// variaveis horaEntrada e horaSaida foram declaradas como Instant
		Duration duration = Duration.between(this.horaEntrada, this.horaSaida);
		return duration.getSeconds();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Instant horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Instant getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Instant horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Long getGegundosEstacionado() {
		return segundosEstacionado;
	}

	public void setSegundosEstacionado(Long segundosEstacionado) {
		this.segundosEstacionado = segundosEstacionado;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
