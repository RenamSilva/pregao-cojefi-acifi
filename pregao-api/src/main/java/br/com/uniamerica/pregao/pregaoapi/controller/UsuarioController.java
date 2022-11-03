package br.com.uniamerica.pregao.pregaoapi.controller;

import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import br.com.uniamerica.pregao.pregaoapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok().body(this.usuarioService.findByAtivoTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.save(usuario);
            return ResponseEntity.ok().body("Usuario Cadastrado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        try {
            this.usuarioService.update(id, usuario);
            return ResponseEntity.ok().body("Usuario Atualizado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            this.usuarioService.setAtivoFalse(id);
            return ResponseEntity.ok().body("Usuario Excluido com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}