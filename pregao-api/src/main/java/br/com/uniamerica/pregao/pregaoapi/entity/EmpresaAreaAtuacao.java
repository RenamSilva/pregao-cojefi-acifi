package br.com.uniamerica.pregao.pregaoapi.entity;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "EmpresaAreaAtuacao", schema = "pregao")
public class EmpresaAreaAtuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @OneToMany
    @Column(name = "empresa", nullable = false)
    private Empresa empresa;

    @Getter @Setter
    @JoinColumn(name = "id_area_atuacao", nullable = false)
    @OneToMany(fetch = FetchType.EAGER)
    private AreaAtuacao areaAtuacao;



}
