package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.HistoricoAtualizacaoStatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.entity.Proposta;
import br.com.uniamerica.pregao.pregaoapi.repository.HistoricoAtualizacaoStatusDemandaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoAtualizacaoStatusDemandaService {

    @Autowired
    private HistoricoAtualizacaoStatusDemandaRepository historicoAtualizacaoStatusDemandaRepository;

    public void inserir (HistoricoAtualizacaoStatusDemanda historicoAtualizacaoStatusDemanda){
        this.historicoAtualizacaoStatusDemandaRepository.save(historicoAtualizacaoStatusDemanda);
    }
}
