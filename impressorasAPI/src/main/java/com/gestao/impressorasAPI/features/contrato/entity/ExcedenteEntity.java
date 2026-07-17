package com.gestao.impressorasAPI.features.contrato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.shared.entity.ProdutoEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "excedente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcedenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Integer saldo;

    @Column(nullable = false)
    private BigDecimal valorAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_excedente_produto"))
    private ProdutoEntity produto;
}
