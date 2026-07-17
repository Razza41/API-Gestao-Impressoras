package com.gestao.impressorasAPI.features.empenho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.gestao.impressorasAPI.features.shared.entity.SecretariaEntity;

@Entity
@Table(name = "empenho")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpenhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String empenho;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_secretaria_fk", nullable = false,
                foreignKey = @ForeignKey(name = "fk_empenho_secretaria"))
    private SecretariaEntity secretaria;
}
