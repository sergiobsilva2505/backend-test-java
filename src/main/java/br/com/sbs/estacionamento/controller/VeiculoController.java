package br.com.sbs.estacionamento.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sbs.estacionamento.VeiculoDto.VeiculoDto;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.services.VeiculoService;

@RestController
@RequestMapping(value = "/estacionamento")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@PostMapping(value = "/novoVeiculo")
	public ResponseEntity<Void> insert(@RequestBody VeiculoDto objDto) {

		Veiculo novoVeiculo = new Veiculo(objDto.getMarca(), objDto.getModelo(), objDto.getCor(), objDto.getPlaca(),
				objDto.getTipo());
		veiculoService.insert(novoVeiculo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoVeiculo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

}
