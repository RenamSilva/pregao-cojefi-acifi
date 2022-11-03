package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter @Setter
    @GeneratedValue()
    private Long id;
    @Getter @Setter
    private LocalDateTime dataCadastro;
    @Getter @Setter
    private LocalDateTime dataAtualizado;
    @Getter @Setter
    private boolean ativo;

    @PrePersist
    public void dataCadastro() {
        this.setDataCadastro(LocalDateTime.now());
        this.setAtivo(true);
    }

    @PreUpdate
    public void dataAtualizado() {
        this.setDataAtualizado(LocalDateTime.now());
    }
}
