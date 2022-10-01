package br.com.uniamerica.pregao.pregaoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuarios", schema = "pregao")
public class Usuario {
    @Id
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "nome", length = 64, unique = false, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "senha", length = 1024, unique = false, nullable = false)
    private String senha;

    @Getter @Setter
    @Column(name = "data_cadastro", unique = false, nullable = false)
    private LocalDate dataCadastro;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", unique = false, nullable = false)
    private TipoUsuario tipo;
}
