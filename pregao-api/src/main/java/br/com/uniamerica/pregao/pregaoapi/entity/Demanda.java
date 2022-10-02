package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

public class Demanda{

    @Id
    @Getter @Setter
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "titulo", length = 64, nullable = false)
    private String titulo;

    @Getter @Setter
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusDemanda status;

    @Getter @Setter
    @JoinColumn(name = "id_demandante", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Empresa demandante;

    @Getter @Setter
    @JoinTable(name = "tb_demanda_empresa", schema = "pregao",
            joinColumns = {@JoinColumn(name = "id_emanda", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_empresa", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<HistoricoAtualizacaoStatusDemanda> historicoAtualizacao;
}
