package br.com.uniamerica.pregao.pregaoapi.service;

import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import br.com.uniamerica.pregao.pregaoapi.repository.EmpresaRepository;
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

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Usuario> findByAtivoTrue() {
        return this.usuarioRepository.findByAtivoTrue();
    }

    public Usuario findByIdAndAtivoTrue(Long id) throws Exception {
        Usuario usuarioExiste = this.usuarioRepository.findByIdAndAtivoTrue(id).orElse(null);
        if(usuarioExiste == null){
            throw new Exception("Usuario nao existe");
        }
        return usuarioExiste;
    }

    public Usuario save(Usuario usuario) throws Exception{
        Usuario emailExiste = this.usuarioRepository.findByEmailAndAtivoTrue(usuario.getEmail()).orElse(null);
        Empresa empresaExiste = this.empresaRepository.findByIdAndAtivoTrue(usuario.getEmpresa().getId()).orElse(null);

        if (emailExiste != null ) {
            throw new Exception("Email já cadastrado");
        }

        if(empresaExiste == null){
            throw new Exception("Empresa nao existe");
        }
        return this.usuarioRepository.save(usuario);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(Long id, Usuario usuario) throws Exception {
        Usuario usuarioExiste = this.usuarioRepository.findByIdAndAtivoTrue(id).orElse(null);
        if(usuarioExiste == null){
            throw new Exception("Usuario nao existe");
        }
        this.usuarioRepository.update(id, usuario.getNome());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void setAtivoFalse(Long id) {
        this.usuarioRepository.setAtivoFalse(id);
    }
}
