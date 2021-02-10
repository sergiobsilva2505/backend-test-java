package br.com.sbs.estacionamento.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sbs.estacionamento.Dto.EntradaVeiculoDto;
import br.com.sbs.estacionamento.Dto.SaidaVeiculoDto;
import br.com.sbs.estacionamento.models.Estabelecimento;
import br.com.sbs.estacionamento.models.Movimentacao;
import br.com.sbs.estacionamento.models.Veiculo;
import br.com.sbs.estacionamento.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private VeiculoService veiculoService;
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepo;
	
	
	/**
	 * Busca todas a movimentacçoes no bancode dados.
	 * @return
	 */
	public List<Movimentacao> findAll() {
		List<Movimentacao> lista = movimentacaoRepo.findAll();
		return lista;
	}
	
	
	


	/**
	 * Inseri uma movimentacao no banco de dados nesse caso especifico, resgistrando apenas a
	 * entrada de um veiculo em um estabelecimento 
	 * @param obj
	 * @return
	 */
	public Movimentacao insert(Movimentacao obj) {
		obj.setId(null);
		obj = movimentacaoRepo.save(obj);
		return obj;
	}
	
	/**
	 * Recebe um objeto MovimetacaoDto, encontra os respectivos objetos veiculo e estabelecimento, informados
	 * pelo usuario e retorna o modelo Movimentacao.
	 * @param objDto
	 * @return
	 */
	public Movimentacao fromDto(EntradaVeiculoDto objDto) {
		Veiculo veiculo = veiculoService.findById(objDto.getIdVeiculo());
		Estabelecimento estabelecimento = estabelecimentoService.findById(objDto.getIdEstabelecimento());
		Movimentacao movimentacao = new Movimentacao(veiculo, estabelecimento);
		return movimentacao;
	}

	/**
	 * Busca de movimentacção por id
	 * @param idMovimentacao
	 * @return
	 */
	public Movimentacao findById(Integer idMovimentacao) {
		Optional<Movimentacao> obj = movimentacaoRepo.findById(idMovimentacao);
		return obj.orElse(null);
	}
	
	/**
	 * Registra o horario de saida de um veiculo do estacionamento,
	 * recupera o tempo estcionado e salva no banco de dados.
	 * @param obj
	 * @return
	 */
	public Movimentacao update(SaidaVeiculoDto obj) {
		Movimentacao newObj = findById(obj.getIdMovimentacao());
		newObj.setHoraSaida(Instant.now());
		newObj.setSegundosEstacionado(newObj.getTempoDeUso());
		movimentacaoRepo.save(newObj);
		return newObj;
	}

	

}
