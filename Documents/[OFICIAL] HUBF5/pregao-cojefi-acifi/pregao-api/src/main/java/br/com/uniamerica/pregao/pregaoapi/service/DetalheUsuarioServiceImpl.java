package br.com.uniamerica.pregao.pregaoapi.service;
import br.com.uniamerica.pregao.pregaoapi.data.DetalheUsuarioData;

import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import br.com.uniamerica.pregao.pregaoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndAtivoTrue(email);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
