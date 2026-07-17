package com.gestao.impressorasAPI.features.contrato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.shared.entity.ProdutoEntity;
import com.gestao.impressorasAPI.features.shared.entity.SecretariaEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Integer saldo;

    @Column(nullable = false)
    private BigDecimal valorAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrato_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_item_contrato"))
    private ContratoEntity contrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_item_produto"))
    private ProdutoEntity produto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_secretaria_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_item_secretaria"))
    private SecretariaEntity secretaria;
}
