package com.ArielMelo.Agenda.Infrastructure.Entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Usuario")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
