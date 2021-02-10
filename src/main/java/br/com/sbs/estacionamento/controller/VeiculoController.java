package br.com.sbs.estacionamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sbs.estacionamento.Dto.VeiculoDto;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.services.VeiculoService;

@RestController
@RequestMapping(value = "/estacionamento")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	/**
	 * Apresenta todos os veiculos cadastrados
	 * 
	 * @return
	 */
	@GetMapping(value = "/veiculos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE })
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> lista = veiculoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	/**
	 * Apresenta um veiculo cadastrado, pelo id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/veiculos/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id) {
		Veiculo veiculo = veiculoService.findById(id);
		return ResponseEntity.ok().body(veiculo);
	}

	/**
	 * Recebe do usuario os dados do novo veículo utilizando a classe Veiculo Dto
	 * para inserção no banco de dados e retorna a URI com o Id do veiculo inserido.
	 * 
	 * @param objDto
	 * @return
	 */
	@PostMapping(value = "/novoVeiculo", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
			MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Void> insert(@RequestBody VeiculoDto objDto) {
		Veiculo novoVeiculo = new Veiculo(objDto.getMarca(), objDto.getModelo(), objDto.getCor(), objDto.getPlaca(),
				objDto.getTipo());
		novoVeiculo = veiculoService.insert(novoVeiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoVeiculo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Recebe os dados de um veiculo que o usuario deseja atualizar
	 * 
	 * @param objDto
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/editaVeiculo/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Void> update(@RequestBody VeiculoDto objDto, @PathVariable Integer id) {
		Veiculo veiculo = veiculoService.fromDto(objDto);
		veiculo.setId(id);
		veiculoService.update(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Recebe o id de um veiculo que o usuario deseja deletar
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/apagaVeiculo/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
