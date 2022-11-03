package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_historicosAtualizacaoStatusDemandas", schema = "pregao")
public class HistoricoAtualizacaoStatusDemanda extends AbstractEntity {

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusDemanda status;

    @Getter @Setter
    @JoinColumn(name = "id_usuario", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario usuario;

    @Getter @Setter
    @ManyToOne()
    @JoinColumn(name = "id_demanda")
    private Demanda demanda;

}
