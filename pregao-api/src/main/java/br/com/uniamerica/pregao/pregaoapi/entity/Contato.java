package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_contatos", schema = "pregao")
public class Contato {
    @Id
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "valor", length = 255, unique = false, nullable = false)
    private String valor;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", unique = false, nullable = false)
    private TipoContato tipo;
}

