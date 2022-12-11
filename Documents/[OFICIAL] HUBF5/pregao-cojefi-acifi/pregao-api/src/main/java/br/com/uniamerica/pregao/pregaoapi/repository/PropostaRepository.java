package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

    public List<Proposta> findByAtivoTrue();

    @Query(value = "SELECT * FROM pregao.tb_propostas WHERE id = :id AND ativo = true", nativeQuery = true)
    public Optional<Proposta> findByIdAtivoTrue(@Param("id") final Long id);


    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Proposta SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);
}
