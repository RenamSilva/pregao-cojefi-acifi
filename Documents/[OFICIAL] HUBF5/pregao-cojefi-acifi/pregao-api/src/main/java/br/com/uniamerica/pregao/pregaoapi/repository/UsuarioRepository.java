package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByAtivoTrue();

    @Query("FROM Usuario WHERE ativo = true AND id = :id")
    public Usuario findByIdAndAtivoTrue(@Param("id") final Long id);

    @Query(value = "SELECT * FROM pregao.tb_usuarios WHERE ativo = true AND email = :email", nativeQuery = true)
    public Optional<Usuario> findByEmailAndAtivoTrue(@Param("email") final String email);

    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Usuario SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

    @Modifying
    @Query("UPDATE FROM Usuario SET nome = :nome WHERE id = :id")
    public void update(@Param("id") final Long id, @Param("nome") final String nome);
}
