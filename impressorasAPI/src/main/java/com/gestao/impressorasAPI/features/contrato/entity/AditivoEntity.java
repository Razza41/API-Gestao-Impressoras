package com.gestao.impressorasAPI.features.contrato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "aditivo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AditivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataInicial;

    @Column(nullable = false)
    private LocalDate dataFinal;

    @Column(nullable = false)
    private String situacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrato_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aditivo_contrato"))
    private ContratoEntity contrato;
}
