package com.gestao.impressorasAPI.features.shared.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer franquiapb;

    @Column(nullable = false)
    private Integer franquiaColor;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String copiaLocacao;

    @Column(nullable = false)
    private Boolean color;
}
