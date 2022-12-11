package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.Proposta;
import br.com.uniamerica.pregao.pregaoapi.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("api/proposta")

public class PropostaController {


    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
       try{
           List<Proposta> proposta = this.propostaService.findAll();
           return ResponseEntity.ok().body(proposta);
       } catch (Exception e){
           return ResponseEntity.internalServerError().body(e.getMessage());
       }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById (@PathVariable final Long id){
        try{
            Optional<Proposta> proposta = this.propostaService.getById(id);
            return ResponseEntity.ok().body(proposta);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> inserir (@RequestBody final Proposta proposta){
        try{
            this.propostaService.inserir(proposta);
            return ResponseEntity.status(201).body("Proposta criada com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @PutMapping("{id}")
    public ResponseEntity<String> atualizar(@PathVariable final Long id, @RequestBody final Proposta proposta){

        try{
            this.propostaService.atualizar(id, proposta);
            return ResponseEntity.status(201).body("Proposta atualizada com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluir (@PathVariable final Long id){
        try {
            this.propostaService.excluir(id);
            return ResponseEntity.status(202).body("Proposta excluida com sucesso");

        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
