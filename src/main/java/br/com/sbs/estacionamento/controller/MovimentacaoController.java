package br.com.sbs.estacionamento.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sbs.estacionamento.Dto.EntradaVeiculoDto;
import br.com.sbs.estacionamento.Dto.SaidaVeiculoDto;
import br.com.sbs.estacionamento.models.Movimentacao;
import br.com.sbs.estacionamento.services.MovimentacaoService;

@RestController
@RequestMapping(value = "/estacionamento")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	/**
	 * Apresenta a lista de todas a movimentações existentes
	 * @return
	 */
	@GetMapping(value = "/movimentacoes", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	public ResponseEntity<List<Movimentacao>> findAll(){
		List<Movimentacao> lista = movimentacaoService.findAll(); 
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "movimentacao/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE} )
	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id ){
		Movimentacao obj = movimentacaoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * Recebe a entrada de um veiculo no estabelecimento
	 * @param obj
	 * @return
	 */
	@PostMapping(value = "/entradaVeiculo", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	public ResponseEntity<Void> insert(@RequestBody EntradaVeiculoDto obj){
		Movimentacao objMov = movimentacaoService.fromDto(obj);
		objMov = movimentacaoService.insert(objMov);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(objMov.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/saidaVeiculo", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	public ResponseEntity<Void> update(@RequestBody SaidaVeiculoDto objDto ){
		movimentacaoService.update(objDto);
		return ResponseEntity.noContent().build();
	}

}
