package com.spydin.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gerar o ID automaticamente
    private Integer id;

    @Column(name = "email", unique = true) //unique não deixa cadastrar 2 usuarios com o mesmo email, ele se torna unico
    private String email;

    @Column(name = "nome")
    private String nome; //Adicionar endereço e outras coisas depois


}
