package br.com.sbs.estacionamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepo;
	
	/**
	 * Faz a persistencia de um novo veiculo no banco de dados recebendo um,
	 * @param veiculo da entidade controller e enviando ao repositorie para persistencia.
	 * @return
	 */
	public Veiculo insert(Veiculo veiculo) {
		veiculo = veiculoRepo.save(veiculo);
		return veiculo;
	}

}
