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

import br.com.sbs.estacionamento.Dto.EstabelecimentoDto;
import br.com.sbs.estacionamento.Dto.VeiculoDto;
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
	 * 
	 * @return
	 */
	@GetMapping(value = "/estabelecimentos", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<List<Estabelecimento>> findAll() {
		List<Estabelecimento> lista = estabelecimentoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	/**
	 * Recebe os parametros para a busca de um estabelecimento por Id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/estabelecimento/{id}")
	public ResponseEntity<Estabelecimento> findByid(@PathVariable Integer id) {
		Estabelecimento estabelecimento = estabelecimentoService.findById(id);
		return ResponseEntity.ok().body(estabelecimento);
	}

	/**
	 * Recebe os dados para cadastro de um novo estabelicento e retorna o Id enviado
	 * pelo banco.
	 * 
	 * @param objDto
	 * @return
	 */
	@PostMapping(value = "/novoEstabelecimento", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Void> insert(@RequestBody EstabelecimentoDto objDto) {
		Estabelecimento novoEstabelecimento = new Estabelecimento(objDto.getNome(), objDto.getCnpj(),
				objDto.getVagasParaCarro(), objDto.getVagasParaMoto(), objDto.getTelefone(), objDto.getEndereco());
		novoEstabelecimento = estabelecimentoService.insert(novoEstabelecimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novoEstabelecimento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Recebe os dados de um estabelecimento para serem alterados
	 * 
	 * @param objDto
	 * @param id
	 * @return
	 */
	@PutMapping(value = "/editaEstabelecimento/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Void> update(@RequestBody EstabelecimentoDto objDto, @PathVariable Integer id) {
		Estabelecimento estabelecimento = estabelecimentoService.fromDto(objDto);
		estabelecimento.setId(id);
		estabelecimentoService.update(estabelecimento);
		return ResponseEntity.noContent().build();
	}

	/**
	 * recebe o id de um estabeleciemnto para ser deletado
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/deletaEstabelecimento/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		estabelecimentoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
