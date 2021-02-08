package br.com.sbs.estacionamento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;
import br.com.sbs.estacionamento.repositories.EstabelecimentoRepository;
import br.com.sbs.estacionamento.repositories.VeiculoRepository;

@SpringBootApplication
public class EstacionamentoApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepo;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		// entidades para teste
		Veiculo v1 = new Veiculo(null, "FIAT", "UNO", CorVeiculo.BRANCO, "ABC1234", TipoVeiculo.CARRO);
		Veiculo v2 = new Veiculo(null, "HYUNDAI", "CIVIC", CorVeiculo.VERMELHO, "ZYB4567", TipoVeiculo.CARRO);
		Veiculo v3 = new Veiculo(null, "HONDA", "CG 160", CorVeiculo.AZUL, "KCL6969", TipoVeiculo.MOTO);
		Veiculo v4 = new Veiculo(null, "CHEVROLET", "ONYX", CorVeiculo.BRANCO, "STF0157", TipoVeiculo.CARRO);
		Veiculo v5 = new Veiculo(null, "HYUNDAI", "HB20", CorVeiculo.PRETO, "RPM0007", TipoVeiculo.CARRO);
		Veiculo v6 = new Veiculo(null, "HONDA", "BIZ", CorVeiculo.VERDE, "FCA1474", TipoVeiculo.MOTO);
		Veiculo v7 = new Veiculo(null, "YAMAHA", "FAZER 250", CorVeiculo.PRATA, "KLC3333", TipoVeiculo.MOTO);
		Veiculo v8 = new Veiculo(null, "FORD", "ECOSPORT", CorVeiculo.AMARELO, "CDB0171", TipoVeiculo.CARRO);
		Veiculo v9 = new Veiculo(null, "FIAT", "STRADA", CorVeiculo.BRANCO, "KKK6969", TipoVeiculo.CARRO);
		Veiculo v10 = new Veiculo(null, "HARLEY-DAVIDSON", "SPORTSTER IRON 883", CorVeiculo.PRETO, "HJB8G74",
				TipoVeiculo.MOTO);
		Veiculo v11 = new Veiculo(null, "HARLEY-DAVIDSON", "SOFTAIL FAT BOY", CorVeiculo.VERMELHO, "LJB9PJ",
				TipoVeiculo.MOTO);
		Veiculo v12 = new Veiculo(null, "HARLEY-DAVIDSON", "ULTRA LIMITED", CorVeiculo.VERMELHO, "HGF0P57",
				TipoVeiculo.MOTO);
		Veiculo v13 = new Veiculo(null, "YAMAHA", "CROSSER 150", CorVeiculo.CINZA, "CCJ9B765", TipoVeiculo.MOTO);
		Veiculo v14 = new Veiculo(null, "HONDA", "XRE 190", CorVeiculo.PRETO, "ABC0Y123", TipoVeiculo.MOTO);
		Veiculo v15 = new Veiculo(null, "BMW", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
		Veiculo v16 = new Veiculo(null, "YAMAHA", "XTZ 125", CorVeiculo.VERMELHO, "STJ4789", TipoVeiculo.MOTO);
		Veiculo v17 = new Veiculo(null, "SUZUKI", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
		Veiculo v18 = new Veiculo(null, "DAFRA", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
		Veiculo v19 = new Veiculo(null, "KAWASAKI", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
		Veiculo v20 = new Veiculo(null, "KASINSKI", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);

		

		// entidades para teste
		Estabelecimento est1 = new Estabelecimento(null, "SAO JUDAS PARK", "05423757000101", 30, 20, "1932357490",
				"Rua Monsenhor João Baptista Martins Ladeira, 743 - VILA SAO JORGE - CAMPINAS/SP");
		Estabelecimento est2 = new Estabelecimento(null, "ALLIANZ PARK", "55176876000185", 40, 20, "1126695726",
				"Avenida Leonor, 398 - VILA AUGUSTA - GUARULHOS/SP");
		Estabelecimento est3 = new Estabelecimento(null, "ITAQUERA PARK", "77225336000187", 40, 25, "1935279716",
				"Rua Suécia, 743 - Loteamento Nardini - AMPARO/SP");
		
		// salva no banco de dados
		veiculoRepo.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17,
				v18, v19, v20));		
		estabelecimentoRepo.saveAll(Arrays.asList(est1, est2, est3));

	}

}
