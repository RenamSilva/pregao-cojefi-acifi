package br.com.uniamerica.pregao.pregaoapi.entity;

import br.com.uniamerica.pregao.pregaoapi.helper.CustomLocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 25, nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime dataCadastro;

    @Getter @Setter
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
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
