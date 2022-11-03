package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import br.com.uniamerica.pregao.pregaoapi.entity.HistoricoAtualizacaoStatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.entity.StatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import br.com.uniamerica.pregao.pregaoapi.repository.DemandaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
import br.com.uniamerica.pregao.pregaoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandaService {
    @Autowired
    private DemandaRepository demandaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistoricoAtualizacaoStatusDemandaService historicoAtualizacaoStatusDemandaService;

    public List<Demanda> listAll (){
        return this.demandaRepository.findByAtivoTrue();
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
