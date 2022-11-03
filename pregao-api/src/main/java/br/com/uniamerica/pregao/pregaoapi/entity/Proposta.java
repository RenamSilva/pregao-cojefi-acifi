package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_propostas", schema = "pregao")
public class Proposta extends AbstractEntity {

    @Getter @Setter
    @Column(name = "conteudo", length = 255, nullable = false)
    private String conteudo;


    @Getter @Setter
    @JoinColumn(name = "id_empresa", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Empresa empresa;

    @Getter @Setter
    @JoinColumn(name = "id_demanda", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Demanda demanda;
}
