package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areAtuacao", schema = "pregao")
public class AreaAtuacao {
    @Id
    @Getter @Setter
    private Long id;

    @Setter @Getter
    @Column(name = "nome", nullable = false, unique = false)
    private String nome;
}
