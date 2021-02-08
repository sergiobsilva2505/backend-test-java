package br.com.sbs.estacionamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.repositories.EstabelecimentoRepository;

/**
 * 
 * @author sergi
 *
 */
@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepo;

	/**
	 * Retorna do banco de dados a lista com os estabelecimentos cadastrados
	 * 
	 * @return
	 */
	public List<Estabelecimento> findAll() {
		List<Estabelecimento> lista = estabelecimentoRepo.findAll();
		return lista;
	}

}
