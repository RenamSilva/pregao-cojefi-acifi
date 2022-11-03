package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import br.com.uniamerica.pregao.pregaoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findByAtivoTrue() {
        return this.usuarioRepository.findByAtivoTrue();
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(Long id, Usuario usuario) {
        this.usuarioRepository.update(id, usuario.getNome());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void setAtivoFalse(Long id) {
        this.usuarioRepository.setAtivoFalse(id);
    }
}
