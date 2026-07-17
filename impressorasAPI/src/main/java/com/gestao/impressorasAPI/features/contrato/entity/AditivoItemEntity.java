package com.gestao.impressorasAPI.features.contrato.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "aditivo_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AditivoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aditivo_item_item"))
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aditivo_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aditivo_item_aditivo"))
    private AditivoEntity aditivo;
}
