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
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("FROM Empresa WHERE ativo = true AND id = :id")
    public Optional<Empresa> findByIdAndAtivoTrue(@Param("id") final Long id);

    public List<Empresa> findByAtivoTrue();

    @Transactional()
    @Query(value = "SELECT * FROM pregao.tb_empresas WHERE cnpj = :cnpj AND ativo = true", nativeQuery = true)
    public Optional<Empresa> findByCnpjAndAtivoTrue(@Param("cnpj") final String cnpj);

    @Modifying
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Query("UPDATE FROM Empresa SET ativo = false WHERE id = :id")
    public void setAtivoFalse(@Param("id") final Long id);

    @Modifying
    @Query("UPDATE FROM Empresa SET nome = :nome WHERE id = :id")
    public void update(@Param("id") final Long id, @Param("nome") final String nome);

}
