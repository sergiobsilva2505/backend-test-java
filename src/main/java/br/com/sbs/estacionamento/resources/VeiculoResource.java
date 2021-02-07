package br.com.sbs.estacionamento.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.models.enums.CorVeiculo;
import br.com.sbs.estacionamento.models.enums.TipoVeiculo;

@RestController
@RequestMapping(value = "/estacionamento")
public class VeiculoResource {

	@GetMapping(value = "/veiculos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE })
	public List<Veiculo> listar() {
		List<Veiculo> lista = new ArrayList<Veiculo>();
		Veiculo v1 = new Veiculo(1, "FIAT", "Uno", CorVeiculo.BRANCO, "ABC1234", TipoVeiculo.CARRO);
		Veiculo v2 = new Veiculo(2, "HYUNDAI", "Civic", CorVeiculo.VERMELHO, "ZYB4567", TipoVeiculo.CARRO);
		Veiculo v3 = new Veiculo(3, "HONDA", "CG125", CorVeiculo.AZUL, "KCL6969", TipoVeiculo.MOTO);
		Veiculo v4 = new Veiculo(3, "YAMAHA", "Factor150", CorVeiculo.CINZA, "STF0157", TipoVeiculo.MOTO);
		lista.addAll(Arrays.asList(v1, v2, v3, v4));
		return lista;
	}

}
