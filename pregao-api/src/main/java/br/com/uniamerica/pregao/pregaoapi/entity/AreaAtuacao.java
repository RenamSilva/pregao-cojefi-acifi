package br.com.uniamerica.pregao.pregaoapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name = "tb_areas_atuacao", schema = "pregao")
public class AreaAtuacao extends AbstractEntity {
    @Getter @Setter
    @Column(name = "nome", length = 64, nullable = false, unique = true)
    private String nome;

    @JsonIgnore
    @Getter @Setter
    @ManyToMany(mappedBy = "areasAtuacao")
    private Set<Demanda> demanda;

    @JsonIgnore
    @Getter @Setter
    @ManyToMany(mappedBy = "areasAtuacao")
    private Set<Empresa> empresas;
}
