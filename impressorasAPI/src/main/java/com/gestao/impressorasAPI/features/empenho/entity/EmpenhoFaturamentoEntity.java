package com.gestao.impressorasAPI.features.empenho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.faturamento.entity.FaturamentoEntity;

@Entity
@Table(name = "empenho_faturamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpenhoFaturamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empenho_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_faturamento_empenho"))
    private EmpenhoEntity empenho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faturamento_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_faturamento_faturamento"))
    private FaturamentoEntity faturamento;
}
