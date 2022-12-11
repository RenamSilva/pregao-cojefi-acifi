package br.com.uniamerica.pregao.pregaoapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name = "tb_contatos", schema = "pregao")
public class Contato extends AbstractEntity {
    @Getter @Setter
    @Column(name = "valor", length = 255, unique = false, nullable = false)
    private String valor;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", unique = false, nullable = false)
    private TipoContato tipo;

    @Getter @Setter
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;
}
