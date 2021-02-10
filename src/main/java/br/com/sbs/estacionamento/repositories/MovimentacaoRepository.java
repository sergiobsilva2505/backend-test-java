package br.com.sbs.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sbs.estacionamento.models.Movimentacao;

/**
 * 
 * @author sergi
 *
 */
@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
