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
@Table(name = "tb_historicosAtualizacaoStatusDemandas", schema = "pregao")
public class HistoricoAtualizacaoStatusDemanda extends AbstractEntity {
    @Getter @Setter
    @Column(name = "dataCadastro", nullable = false, scale = 3, precision = 6)
    private LocalDateTime dataCadastro;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusDemanda status;

    @Getter @Setter
    @JoinColumn(name = "id_usuario", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Usuario usuario;

    @PrePersist
    public void dataDataCadastro(){
        this.setDataCadastro(LocalDateTime.now());
    }
}
