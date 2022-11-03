package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.HistoricoAtualizacaoStatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoAtualizacaoStatusDemandaRepository extends JpaRepository<HistoricoAtualizacaoStatusDemanda, Long> {
}
