package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import br.com.uniamerica.pregao.pregaoapi.entity.StatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.repository.DemandaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class DemandaService {
    @Autowired
    private DemandaRepository demandaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Demanda> listAll (){
        return this.demandaRepository.findAll();
    }

    public Optional<Demanda> getById (Long id){
        return this.demandaRepository.findById(id);
    }

    public Demanda inserir (Demanda demanda){
        return this.demandaRepository.save(demanda);
    }

    public void atualizar (Long id, Demanda demanda) throws Exception {
        Demanda demandaExiste = this.getById(id).orElse(null);

        if(demandaExiste == null){
            throw new Exception("Demanda não encontrada");
        } else {
            demandaExiste.setTitulo(demanda.getTitulo());
            demandaExiste.setDescricao(demanda.getDescricao());
            demandaExiste.setStatus(demanda.getStatus());

            this.demandaRepository.save(demandaExiste);
        }
    }

    public void atualizarStatusDemanda (Long id, StatusDemanda status) throws Exception {
        Demanda demandaExiste = this.getById(id).orElse(null);

        if(demandaExiste == null){
            throw new Exception("Demanda não encontrada");
        } else {
            demandaExiste.setStatus(status);
            this.demandaRepository.save(demandaExiste);
        }
    }


    public void delete (Long id) throws Exception{
        Demanda demandaExiste = this.getById(id).orElse(null);

         if (demandaExiste == null){
             throw new Exception("Demanda não encontrada");
         } else {
             this.demandaRepository.delete(demandaExiste);
         }

    }
}
