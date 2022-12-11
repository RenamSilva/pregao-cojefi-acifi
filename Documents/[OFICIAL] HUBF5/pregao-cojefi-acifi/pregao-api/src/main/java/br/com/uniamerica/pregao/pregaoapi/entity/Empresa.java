package br.com.uniamerica.pregao.pregaoapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    @JsonManagedReference
    @OneToMany(mappedBy = "empresa")
    private List<Contato> contatos;

    @Getter @Setter
    @JsonManagedReference
    @OneToMany(mappedBy = "empresa")
    private List<Demanda> demandas;

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
