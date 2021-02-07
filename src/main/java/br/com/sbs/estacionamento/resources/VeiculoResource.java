package br.com.sbs.estacionamento.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estacionamento")
public class VeiculoResource {
	
	@GetMapping
	public String listar() {
		return "Testando REST!";
	}

}
