package br.com.sbs.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.sbs.estacionamento.Dto.VeiculoDto;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.repositories.VeiculoRepository;
import br.com.sbs.estacionamento.services.exception.DataIntegrityException;
import br.com.sbs.estacionamento.services.exception.ObjectNotFoundException;

/**
 * 
 * @author sergi
 *
 */
@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepo;

	/**
	 * Retorna todos os veiculos cadastrados
	 * 
	 * @return
	 */
	public List<Veiculo> findAll() {
		List<Veiculo> lista = veiculoRepo.findAll();
		return lista;
	}

	/**
	 * Retorna um veiculo cadastrado por id.
	 * 
	 * @param id
	 * @return
	 */
	public Veiculo findById(Integer id) {
		Optional<Veiculo> veiculo = veiculoRepo.findById(id);
		return veiculo.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
	}

	/**
	 * Faz a persistencia de um novo veiculo no banco de dados recebendo um veiculo
	 * da entidade controller e enviando ao repositorie para persistencia.
	 * 
	 * @param veiculo
	 * @return
	 */
	public Veiculo insert(Veiculo veiculo) {
		veiculo = veiculoRepo.save(veiculo);
		return veiculo;
	}

	/**
	 * Atualiza pelo id no banco de dados um veiculo solicitado pelo uuario
	 * 
	 * @param obj
	 * @return
	 */
	public Veiculo update(Veiculo obj) {
		Veiculo veiculo = findById(obj.getId());
		veiculo.setCor(obj.getCor());
		veiculo.setMarca(obj.getMarca());
		veiculo.setModelo(obj.getModelo());
		veiculo.setPlaca(obj.getPlaca());
		veiculo.setTipo(obj.getTipo());
		return veiculoRepo.save(veiculo);
	}

	/**
	 * Realiza a troca do objeto VeiculoDto pelo Modelo Veiculo
	 * 
	 * @param objDto
	 * @return
	 */
	public Veiculo fromDto(VeiculoDto objDto) {
		Veiculo veiculo = new Veiculo(objDto.getMarca(), objDto.getModelo(), objDto.getCor(), objDto.getPlaca(),
				objDto.getTipo());
		return veiculo;
	}

	/**
	 * Deleta por id, um veiculo cadastrado do banco de dados
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		try {
			veiculoRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Impossivel deletar");
		}
	}

}
