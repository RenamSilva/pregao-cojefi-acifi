package br.com.uniamerica.pregao.pregaoapi.data;

import br.com.uniamerica.pregao.pregaoapi.entity.TipoUsuario;
import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class DetalheUsuarioData implements UserDetails {

    private final Optional<Usuario> usuario;

    public DetalheUsuarioData(Optional<Usuario> usuario) {
        this.usuario = usuario;
    }

    private String ROLE_PREFIX = "ROLE_";
    @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        if(usuario.get().getTipo() == TipoUsuario.ADMINISTRADOR){
             list.add(new SimpleGrantedAuthority(ROLE_PREFIX + TipoUsuario.ADMINISTRADOR));
        }
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + TipoUsuario.ASSOCIADO));
        return list;
     }

    @Override
    public String getPassword() {
        return usuario.orElse(new Usuario()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new Usuario()).getNome();
    }

    public String getEmail() {
        return usuario.orElse(new Usuario()).getEmail();
    }

    public Long getId() {
        return usuario.orElse(new Usuario()).getId();
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
