package br.com.uniamerica.pregao.pregaoapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name = "tb_demandas", schema = "pregao")
public class Demanda extends AbstractEntity {

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Empresa demandante;

    @Getter @Setter
    // @JoinColumn(name = "id_demanda", nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HistoricoAtualizacaoStatusDemanda> historicoAtualizacao;

    @Getter @Setter
    @JoinTable(name = "tb_demanda_area_atuacao", schema = "pregao",
            joinColumns = {@JoinColumn(name = "id_demandas", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_area_atuacao", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<AreaAtuacao> areasAtuacao;
}
