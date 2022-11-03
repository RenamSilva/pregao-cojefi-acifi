package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_empresas_visualizacoes_demandas", schema = "pregao")
public class EmpresaVisualizacaoDemanda extends AbstractEntity {
    @Getter @Setter
    @JoinColumn(name = "id_empresa", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Empresa empresa;
}
