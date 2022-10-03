package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_area_atuacoes", schema = "pregao")
public class AreaAtuacao {

    @Id
    @Getter @Setter
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "nome", length = 64, nullable = false, unique = true)
    private String nome;

    @Getter @Setter
    @ManyToMany(mappedBy = "areas_atuacoes")
    private Set<Demanda> demanda;

    @Getter @Setter
    @ManyToMany(mappedBy = "areas_atuacoes")
    private Set<Empresa> empresas;
}
