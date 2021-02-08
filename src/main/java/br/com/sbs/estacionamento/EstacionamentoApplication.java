package br.com.sbs.estacionamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;
import br.com.sbs.estacionamento.repositories.VeiculoRepository;

@SpringBootApplication
public class EstacionamentoApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Veiculo v1 = new Veiculo(null, "FIAT", "Uno", CorVeiculo.BRANCO, "ABC1234", TipoVeiculo.CARRO);
//		Veiculo v2 = new Veiculo(null, "HYUNDAI", "Civic", CorVeiculo.VERMELHO, "ZYB4567", TipoVeiculo.CARRO);
//		Veiculo v3 = new Veiculo(null, "HONDA", "CG125", CorVeiculo.AZUL, "KCL6969", TipoVeiculo.MOTO);
//		Veiculo v4 = new Veiculo(null, "YAMAHA", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
//
//		veiculoRepo.saveAll(Arrays.asList(v1, v2, v3, v4));

	}

}
