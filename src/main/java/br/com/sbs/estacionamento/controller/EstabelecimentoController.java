package br.com.sbs.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.services.EstabelecimentoService;

/**
 * 
 * @author sergi
 *
 */
@RestController
@RequestMapping(value = "/estacionamento")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	/**
	 * apresenta a lista de estabelecimento cadastrados
	 * @return
	 */
	@GetMapping(value = "/estabelecimentos", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<List<Estabelecimento>> findAll() {
		List<Estabelecimento> lista = estabelecimentoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

}
