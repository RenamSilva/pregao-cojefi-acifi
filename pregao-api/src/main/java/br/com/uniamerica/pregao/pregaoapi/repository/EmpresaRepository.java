package br.com.uniamerica.pregao.pregaoapi.repository;

import br.com.uniamerica.pregao.pregaoapi.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    public List<Empresa> findByAtivoTrue();

    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Empresa SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

    @Modifying
    @Query("UPDATE FROM Empresa SET nome = :nome WHERE id = :id")
    public void update(@Param("id") final Long id, @Param("nome") final String nome);
}
