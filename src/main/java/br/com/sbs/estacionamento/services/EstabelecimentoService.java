package br.com.sbs.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.sbs.estacionamento.Dto.EstabelecimentoDto;
import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.repositories.EstabelecimentoRepository;
import br.com.sbs.estacionamento.services.exception.DataIntegrityException;
import br.com.sbs.estacionamento.services.exception.ObjectNotFoundException;

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

	/**
	 * Retorna do banco de dados um estabelecimento solicitado pelo Id cadastrado
	 * 
	 * @param id
	 * @return
	 */
	public Estabelecimento findById(Integer id) {
		Optional<Estabelecimento> obj = estabelecimentoRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estabelecimento.class.getName()));
	}

	/**
	 * Insere no banco de dados um novo estabelecimento enviado pelo usuario
	 * 
	 * @param novoEstabelecimento
	 * @return retorna os dados conforme inserido no banco
	 */
	public Estabelecimento insert(Estabelecimento novoEstabelecimento) {
		Estabelecimento obj = estabelecimentoRepo.save(novoEstabelecimento);
		return obj;
	}

	/**
	 * altera os dados de um estabelecimento no banco de daos
	 * 
	 * @param obj
	 * @return
	 */
	public Estabelecimento update(Estabelecimento obj) {
		Estabelecimento est = findById(obj.getId());
		est.setNome(obj.getNome());
		est.setCnpj(obj.getCnpj());
		est.setVagasParaCarro(obj.getVagasParaCarro());
		est.setVagasParaMoto(obj.getVagasParaMoto());
		est.setTelefone(obj.getTelefone());
		est.setEndereco(obj.getEndereco());
		return estabelecimentoRepo.save(est);
	}

	/**
	 * Deleta um estabelecimento pelo id
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		try {
			estabelecimentoRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Impossivel deletar");
		}

	}

	/**
	 * Faz a troca de tipos de objeto estabelecimento de Dto para o modelo.
	 * 
	 * @param objDto
	 * @return
	 */
	public Estabelecimento fromDto(EstabelecimentoDto objDto) {
		Estabelecimento obj = new Estabelecimento(objDto.getNome(), objDto.getCnpj(), objDto.getVagasParaCarro(),
				objDto.getVagasParaMoto(), objDto.getTelefone(), objDto.getEndereco());
		return obj;
	}

}
