package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.AreaAtuacao;
import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
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
public interface AreaAtuacaoRepository extends JpaRepository<AreaAtuacao, Long> {
    public List<AreaAtuacao> findByAtivoTrue();

    @Query(value = "SELECT * FROM pregao.tb_areas_atuacao WHERE id = :id AND ativo = true", nativeQuery = true)
    public Optional<AreaAtuacao> findByAtivoTrueAndId(@Param("id") final Long id);

    @Query(value = "SELECT * FROM pregao.tb_areas_atuacao WHERE nome = :nome AND ativo = true", nativeQuery = true)
    public Optional<AreaAtuacao> findByAtivoTrueAndName(@Param("nome") final String nome);
    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM AreaAtuacao SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

    @Modifying
    @Query("UPDATE FROM AreaAtuacao SET nome = :nome WHERE id = :id")
    public void update(@Param("id") final Long id, @Param("nome") final String nome);

}
