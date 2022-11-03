package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.controller.PropostaController;
import br.com.uniamerica.pregao.pregaoapi.entity.Proposta;
import br.com.uniamerica.pregao.pregaoapi.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropostaService {
    @Autowired
    private PropostaRepository propostaRepository;


   public List<Proposta> findAll(){ return this.propostaRepository.findAll();}


    public Optional<Proposta> getById(Long id){return this.propostaRepository.findByIdAtivoTrue(id);}

    public Proposta inserir (Proposta proposta){
       return this.propostaRepository.save(proposta);
    }

    public void atualizar (Long id, Proposta proposta) throws Exception {
       Proposta proposta1 = this.getById(id).orElse(null);

       if (proposta1 == null){
           throw new Exception("Proposta não existente");
       } else {
           proposta1.setConteudo(proposta.getConteudo());
          proposta1.setDemanda(proposta.getDemanda());

           this.propostaRepository.save(proposta1);
       }
    }

    public void excluir (Long id) throws Exception {
       Proposta propostaDelete = this.getById(id).orElse(null);
       if (propostaDelete == null){
           throw new Exception("Proposta não existente");
       } else {
           this.propostaRepository.setAtivoFalse(propostaDelete.getId());
       }
    }


}
