package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
import br.com.uniamerica.pregao.pregaoapi.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> findAll() {
        return ResponseEntity.ok().body(this.empresaService.findByAtivoTrueAndContatoAtivoTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.empresaService.findByIdAndAtivoTrue(id));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Empresa empresa) {
        try {
            this.empresaService.save(empresa);
            return ResponseEntity.ok().body("Empresa Cadastrado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Empresa empresa) {
        try {
            this.empresaService.update(id, empresa);
            return ResponseEntity.ok().body("Empresa Atualizado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.empresaService.setAtivoFalse(id);
            return ResponseEntity.ok().body("Empresa Excluido com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}