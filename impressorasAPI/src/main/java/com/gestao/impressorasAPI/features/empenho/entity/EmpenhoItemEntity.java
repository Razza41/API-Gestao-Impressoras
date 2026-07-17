package com.gestao.impressorasAPI.features.empenho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.contrato.entity.ItemEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "empenho_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpenhoItemEntity {

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
                foreignKey = @ForeignKey(name = "fk_empenho_item_empenho"))
    private EmpenhoEntity empenho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_item_item"))
    private ItemEntity item;

    @Column(name = "id_empenho_produto_fk")
    private Long idEmpenhoProduto;
}
