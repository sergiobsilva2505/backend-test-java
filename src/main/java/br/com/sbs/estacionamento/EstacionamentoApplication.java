package br.com.sbs.estacionamento;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.models.Movimentacao;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;
import br.com.sbs.estacionamento.repositories.EstabelecimentoRepository;
import br.com.sbs.estacionamento.repositories.MovimentacaoRepository;
import br.com.sbs.estacionamento.repositories.VeiculoRepository;

@SpringBootApplication
public class EstacionamentoApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepo;

	@Autowired
	private MovimentacaoRepository movimentacaoRepo;

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

		// entidades para teste
		Estabelecimento est1 = new Estabelecimento(null, "SAO JUDAS PARK", "05423757000101", 30, 20, "1932357490",
				"Rua Monsenhor João Baptista Martins Ladeira, 743 - VILA SAO JORGE - CAMPINAS/SP");
		Estabelecimento est2 = new Estabelecimento(null, "ALLIANZ PARK", "55176876000185", 40, 20, "1126695726",
				"Avenida Leonor, 398 - VILA AUGUSTA - GUARULHOS/SP");
		Estabelecimento est3 = new Estabelecimento(null, "ITAQUERA PARK", "77225336000187", 40, 25, "1935279716",
				"Rua Suécia, 743 - Loteamento Nardini - AMPARO/SP");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		// movimentacoes para teste
		Movimentacao mov1 = new Movimentacao();
		mov1.setEstabelecimento(est1);
		mov1.setHoraEntrada(sdf.parse("07/02/2021 11:05").toInstant());
		mov1.setHoraSaida(sdf.parse("07/02/2021 12:35").toInstant());
		mov1.setVeiculo(v1);
		mov1.setTempoDeUso();

		Movimentacao mov2 = new Movimentacao();
		mov2.setEstabelecimento(est1);
		mov2.setHoraEntrada(sdf.parse("07/02/2021 08:16").toInstant());
		mov2.setHoraSaida(sdf.parse("07/02/2021 18:25").toInstant());
		mov2.setVeiculo(v10);
		mov2.setTempoDeUso();

		Movimentacao mov3 = new Movimentacao();
		mov3.setEstabelecimento(est1);
		mov3.setHoraEntrada(sdf.parse("07/02/2021 09:12").toInstant());
		mov3.setHoraSaida(sdf.parse("07/02/2021 15:35").toInstant());
		mov3.setVeiculo(v12);
		mov3.setTempoDeUso();

		Movimentacao mov4 = new Movimentacao();
		mov4.setEstabelecimento(est1);
		mov4.setHoraEntrada(sdf.parse("07/02/2021 10:09").toInstant());
		mov4.setHoraSaida(sdf.parse("07/02/2021 12:35").toInstant());
		mov4.setVeiculo(v8);
		mov4.setTempoDeUso();

		Movimentacao mov5 = new Movimentacao();
		mov5.setEstabelecimento(est1);
		mov5.setHoraEntrada(sdf.parse("07/02/2021 13:33").toInstant());
		mov5.setHoraSaida(sdf.parse("07/02/2021 20:45").toInstant());
		mov5.setVeiculo(v5);
		mov5.setTempoDeUso();
		
		Movimentacao mov6 = new Movimentacao();
		mov6.setEstabelecimento(est2);
		mov6.setHoraEntrada(sdf.parse("07/02/2021 11:05").toInstant());
		mov6.setHoraSaida(sdf.parse("07/02/2021 12:35").toInstant());
		mov6.setVeiculo(v1);
		mov6.setTempoDeUso();

		Movimentacao mov7 = new Movimentacao();
		mov7.setEstabelecimento(est2);
		mov7.setHoraEntrada(sdf.parse("07/02/2021 08:16").toInstant());
		mov7.setHoraSaida(sdf.parse("07/02/2021 18:25").toInstant());
		mov7.setVeiculo(v10);
		mov7.setTempoDeUso();

		Movimentacao mov8 = new Movimentacao();
		mov8.setEstabelecimento(est1);
		mov8.setHoraEntrada(sdf.parse("07/02/2021 09:12").toInstant());
		mov8.setHoraSaida(sdf.parse("07/02/2021 15:35").toInstant());
		mov8.setVeiculo(v12);
		mov8.setTempoDeUso();

		Movimentacao mov9 = new Movimentacao();
		mov9.setEstabelecimento(est2);
		mov9.setHoraEntrada(sdf.parse("07/02/2021 10:09").toInstant());
		mov9.setHoraSaida(sdf.parse("07/02/2021 12:35").toInstant());
		mov9.setVeiculo(v8);
		mov9.setTempoDeUso();

		Movimentacao mov10 = new Movimentacao();
		mov10.setEstabelecimento(est2);
		mov10.setHoraEntrada(sdf.parse("07/02/2021 13:33").toInstant());
		mov10.setHoraSaida(sdf.parse("07/02/2021 20:45").toInstant());
		mov10.setVeiculo(v5);
		mov10.setTempoDeUso();

		// salva no banco de dados
		veiculoRepo.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15));
		estabelecimentoRepo.saveAll(Arrays.asList(est1, est2, est3));

		est1.getMovimentacoes().addAll(Arrays.asList(mov1, mov2, mov3, mov4, mov5));
		v1.getMovimentacoes().addAll(Arrays.asList(mov1));
		v10.getMovimentacoes().addAll(Arrays.asList(mov2));
		v12.getMovimentacoes().addAll(Arrays.asList(mov3));
		v8.getMovimentacoes().addAll(Arrays.asList(mov4));
		v5.getMovimentacoes().addAll(Arrays.asList(mov5));
		
		movimentacaoRepo.saveAll(Arrays.asList(mov1, mov2, mov3, mov4, mov5, mov6, mov7, mov8,mov9,mov10));

	}

}
