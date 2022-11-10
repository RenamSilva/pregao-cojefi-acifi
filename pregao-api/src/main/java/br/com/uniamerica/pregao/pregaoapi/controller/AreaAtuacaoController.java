package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.AreaAtuacao;
import br.com.uniamerica.pregao.pregaoapi.service.AreaAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/areas-atuacao")
public class AreaAtuacaoController {
    @Autowired
    private AreaAtuacaoService areaAtuacaoService;

    @GetMapping
    public ResponseEntity<List<AreaAtuacao>> findAll() {
        return ResponseEntity.ok().body(this.areaAtuacaoService.findByAtivoTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(this.areaAtuacaoService.findById(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody AreaAtuacao areaAtuacao) {
        try {
            this.areaAtuacaoService.save(areaAtuacao);
            return ResponseEntity.ok().body("AreaAtuacao Cadastrado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AreaAtuacao areaAtuacao) {
        try {
            this.areaAtuacaoService.update(id, areaAtuacao);
            return ResponseEntity.ok().body("AreaAtuacao Atualizado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.areaAtuacaoService.setAtivoFalse(id);
            return ResponseEntity.ok().body("AreaAtuacao Excluido com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}