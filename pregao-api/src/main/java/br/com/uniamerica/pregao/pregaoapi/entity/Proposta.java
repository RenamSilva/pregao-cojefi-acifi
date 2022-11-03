package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_propostas", schema = "pregao")
public class Proposta {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "conteudo", length = 255, nullable = false)
    private String conteudo;

    @Getter @Setter
    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Getter @Setter
    @JoinColumn(name = "id_empresa", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Empresa empresa;

    @Getter @Setter
    @JoinColumn(name = "id_demanda", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Demanda demanda;

    @PrePersist
    public void dataDataCadastro(){
        this.setDataCadastro(LocalDateTime.now());
    }
}
