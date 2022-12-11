package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.*;
import br.com.uniamerica.pregao.pregaoapi.repository.DemandaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DemandaService {
    @Autowired
    private DemandaRepository demandaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistoricoAtualizacaoStatusDemandaService historicoAtualizacaoStatusDemandaService;

    public List<Demanda> listAll () {
        final List<Demanda> demandas = this.demandaRepository.findByAtivoTrue();

        demandas.forEach(demanda -> {
            Set<AreaAtuacao> activeAreasAtuacao = demanda.getAreasAtuacao().stream().filter(AbstractEntity::isAtivo).collect(Collectors.toSet());

            demanda.setAreasAtuacao(activeAreasAtuacao);
        });

        return demandas;
    }

    public Optional<Demanda> getById (Long id){
        return this.demandaRepository.findByIdAtivoTrue(id);
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

            this.demandaRepository.save(demandaExiste);
        }
    }

    public void atualizarStatusDemanda (Long id, Long idUsuario, StatusDemanda status) throws Exception {
        Demanda demandaExiste = this.getById(id).orElse(null);

        Usuario usuarioExiste = this.usuarioRepository.findById(idUsuario).orElse(null);

        if(usuarioExiste == null){
            throw new Exception("Usuario não encontrada");
        }


        if(demandaExiste == null){
            throw new Exception("Demanda não encontrada");
        } else {
            demandaExiste.setStatus(status);

            HistoricoAtualizacaoStatusDemanda historicoAtualizacaoStatusDemanda1 = new HistoricoAtualizacaoStatusDemanda();
            historicoAtualizacaoStatusDemanda1.setUsuario(usuarioExiste);
            historicoAtualizacaoStatusDemanda1.setStatus(status);
            historicoAtualizacaoStatusDemanda1.setDemanda(demandaExiste);
            this.historicoAtualizacaoStatusDemandaService.inserir(historicoAtualizacaoStatusDemanda1);

            this.demandaRepository.save(demandaExiste);
        }
    }


    public void delete (Long id) throws Exception{
        Demanda demandaExiste = this.getById(id).orElse(null);

         if (demandaExiste == null){
             throw new Exception("Demanda não encontrada");
         } else {
             this.demandaRepository.setAtivoFalse(demandaExiste.getId());
         }

    }
}
