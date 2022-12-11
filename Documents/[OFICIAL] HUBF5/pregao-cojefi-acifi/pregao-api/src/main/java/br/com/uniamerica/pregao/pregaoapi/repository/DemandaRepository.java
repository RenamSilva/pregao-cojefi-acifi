package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DemandaRepository extends JpaRepository<Demanda, Long> {

    public List<Demanda> findByAtivoTrue();

    @Query(value = "SELECT * FROM pregao.tb_demandas WHERE id = :id AND ativo = true", nativeQuery = true)
    public Optional<Demanda> findByIdAtivoTrue(@Param("id") final Long id);


    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Demanda SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

}
