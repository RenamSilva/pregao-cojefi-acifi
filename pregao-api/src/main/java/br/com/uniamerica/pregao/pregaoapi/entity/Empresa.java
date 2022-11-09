package br.com.uniamerica.pregao.pregaoapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name = "tb_empresas", schema = "pregao")
public class Empresa extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 64, unique = false, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "cnpj", length = 15, unique = true, nullable = false)
    private String cnpj;

    @Getter @Setter
    @Column(name = "imagem", length = 255, unique = false, nullable = true)
    private String imagem;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", unique = false, nullable = false)
    private StatusEmpresa status;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_empresa", nullable = false)
    private Set<Contato> contatos;

    @Getter @Setter
    @JoinTable(name = "tb_empresa_area_atuacao", schema = "pregao",
            joinColumns = {
                @JoinColumn(
                        name = "id_empresas",
                        referencedColumnName = "id"
                )
            },
            inverseJoinColumns = {
                @JoinColumn(
                        name = "id_areas_atuacao",
                        referencedColumnName = "id"
                )
            })
    @ManyToMany
    private Set<AreaAtuacao> areasAtuacao;
}
