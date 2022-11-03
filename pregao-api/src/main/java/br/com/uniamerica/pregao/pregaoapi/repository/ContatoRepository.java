package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.Contato;
import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import br.com.uniamerica.pregao.pregaoapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public List<Contato> findByAtivoTrue();

    @Query(value = "SELECT * FROM pregao.tb_contatos WHERE id = :id AND ativo = true", nativeQuery = true)
    public Optional<Contato> findByIdAtivoTrue(@Param("id") final Long id);

    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Contato SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

    @Modifying
    @Query("UPDATE FROM Contato SET nome = :nome WHERE id = :id")
    public void update(@Param("id") final Long id, @Param("nome") final String nome);
}
