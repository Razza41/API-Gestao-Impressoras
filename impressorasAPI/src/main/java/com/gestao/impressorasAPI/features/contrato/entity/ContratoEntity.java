package com.gestao.impressorasAPI.features.contrato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "contrato")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataInicial;

    @Column(nullable = false)
    private LocalDate dataFinal;

    @Column(nullable = false)
    private LocalDate dataFinalAtual;
}
