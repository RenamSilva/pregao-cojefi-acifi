package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import br.com.uniamerica.pregao.pregaoapi.entity.StatusDemanda;
import br.com.uniamerica.pregao.pregaoapi.service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/demanda")
public class DemandaController {

    @Autowired
    private DemandaService demandaService;

    @GetMapping
    public ResponseEntity<?> listAll(){
        try{
            List<Demanda> demandas = this.demandaService.listAll();
            return ResponseEntity.ok().body(demandas);
        } catch (Exception error) {
            return ResponseEntity.internalServerError().body(error.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id){
        try{
            Optional<Demanda> demanda = this.demandaService.getById(id);
            return ResponseEntity.ok().body(demanda);
        } catch (Exception error){
            return ResponseEntity.internalServerError().body(error.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody final Demanda demanda){
        try {
            this.demandaService.inserir(demanda);
            return ResponseEntity.status(201).body("Demanda criada com sucesso!");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizar (@PathVariable final Long id, @RequestBody final Demanda demanda){
        try{
            this.demandaService.atualizar(id, demanda);
            return ResponseEntity.status(202).body("Demanda atualizada com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable final Long id){
        try{
            this.demandaService.delete(id);
            return ResponseEntity.status(202).body("Demanda excluida com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/aberto/{id}")
    public ResponseEntity<String> atualizarStatusAberto (@PathVariable final Long id){
        try{
            this.demandaService.atualizarStatusDemanda(id, StatusDemanda.ABERTO);
            return ResponseEntity.status(202).body("Satus atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/atendido/{id}")
    public ResponseEntity<String> atualizarStatusAtendido (@PathVariable final Long id){
        try{
            this.demandaService.atualizarStatusDemanda(id, StatusDemanda.ATENDIDO);
            return ResponseEntity.status(202).body("Satus atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/encerrado/{id}")
    public ResponseEntity<String> atualizarStatusEncerrado (@PathVariable final Long id){
        try{
            this.demandaService.atualizarStatusDemanda(id, StatusDemanda.ENCERRADO);
            return ResponseEntity.status(202).body("Satus atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/excluido/{id}")
    public ResponseEntity<String> atualizarStatusExcluido (@PathVariable final Long id){
        try{
            this.demandaService.atualizarStatusDemanda(id, StatusDemanda.EXCLUIDO);
            return ResponseEntity.status(202).body("Satus atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}