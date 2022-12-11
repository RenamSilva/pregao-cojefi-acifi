package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.Contato;
import br.com.uniamerica.pregao.pregaoapi.entity.TipoContato;
import br.com.uniamerica.pregao.pregaoapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    @PreAuthorize("hasAuthority(ROLE_ADMINISTRADOR)")
    public ResponseEntity<?> listAll() {
        try {
            List<Contato> contatos = this.contatoService.listAll();
            return ResponseEntity.ok().body(contatos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable final Long id) {
        try {
            Optional<Contato> proposta = this.contatoService.getById(id);
            return ResponseEntity.ok().body(proposta);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> inserir (@RequestBody Contato contato){

        try{
            this.contatoService.inserir(contato);
        return ResponseEntity.status(201).body("Contato adicionado com sucesso");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizar (@PathVariable final Long id, @RequestBody final Contato contato){
        try{
            this.contatoService.atualizar(id, contato);
            return ResponseEntity.status(202).body("contato atualizada com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/email/{id}")
    public ResponseEntity<String> atualizarContatoEmail (@PathVariable final Long id){
        try{
            this.contatoService.atualizarContato(id, TipoContato.EMAIL);
            return ResponseEntity.status(202).body("Contato Atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/telefone/{id}")
    public ResponseEntity<String> atualizarContatoTelefone (@PathVariable final Long id){
        try{
            this.contatoService.atualizarContato(id, TipoContato.TELEFONE);
            return ResponseEntity.status(202).body("Contato Atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/whatsapp/{id}")
    public ResponseEntity<String> atualizarContatoWhatsapp (@PathVariable final Long id){
        try{
            this.contatoService.atualizarContato(id, TipoContato.WHATSAPP);
            return ResponseEntity.status(202).body("Contato Atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.contatoService.setAtivoFalse(id);
            return ResponseEntity.ok().body("Contato Excluido com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
