package br.com.sbs.estacionamento.models;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant horaEntrada;
	private Instant horaSaida;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;

	private Long tempoDeUso;
	private String tempoDeUsoLegivel;

	public Movimentacao() {

	}

	public Movimentacao(Veiculo veiculo, Estabelecimento estabelecimento) {
		this.horaEntrada = Instant.now();
		this.veiculo = veiculo;
		this.estabelecimento = estabelecimento;
	}

	public Long getTempoDeUso() {
		return tempoDeUso;
	}

	/**
	 * Faz o cálculo do tempo de uso e seta na varável
	 */
	public void setTempoDeUso() {
		if (this.horaEntrada == null || this.horaSaida == null) {
			this.tempoDeUso = null;
		} else {
			Duration duration = Duration.between(this.horaEntrada, this.horaSaida);
			this.tempoDeUso = duration.toMillis();
		}

		setTempoDeUsoLegivel();
	}

	/**
	 * Pega o valor da varável tempo de uso e converte para uma string legível para
	 * o usuario.
	 * 
	 * @return
	 */
	public void setTempoDeUsoLegivel() {
		String tempoFormatado = String.format("%03d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(this.tempoDeUso),
				TimeUnit.MILLISECONDS.toMinutes(this.tempoDeUso) % 60,
				TimeUnit.MICROSECONDS.toSeconds(this.tempoDeUso) % 60);
		this.tempoDeUsoLegivel = tempoFormatado;
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

	public String getTempoDeUsoLegivel() {
		return tempoDeUsoLegivel;
	}

	public void setTempoDeUsoLegivel(String tempoDeUsoLegivel) {
		this.tempoDeUsoLegivel = tempoDeUsoLegivel;
	}

}
