package com.gestao.impressorasAPI.features.empenho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.contrato.entity.ExcedenteEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "empenho_excedente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpenhoExcedenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Integer saldo;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empenho_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_excedente_empenho"))
    private EmpenhoEntity empenho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_excedente_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_excedente_excedente"))
    private ExcedenteEntity excedente;
}
