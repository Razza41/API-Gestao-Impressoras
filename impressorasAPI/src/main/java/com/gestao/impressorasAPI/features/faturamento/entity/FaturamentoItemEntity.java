package com.gestao.impressorasAPI.features.faturamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.empenho.entity.EmpenhoItemEntity;

import java.math.BigDecimal;

@Entity
@Table(name = "faturamento_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaturamentoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faturamento_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_faturamento_item_faturamento"))
    private FaturamentoEntity faturamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empenho_item_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_faturamento_item_empenho_item"))
    private EmpenhoItemEntity empenhoItem;
}
