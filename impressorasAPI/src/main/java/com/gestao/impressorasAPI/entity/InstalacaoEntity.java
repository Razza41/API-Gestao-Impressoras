package com.gestao.impressorasAPI.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "instalacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstalacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer itemPedido;

    @Column(nullable = false)
    private String localInstalacao;

    @Embedded
    private EnderecoEntity endereco;

    private String transformador;

    @Column(nullable = false)
    private String responsavelInstalacao;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private LocalDate dataInstalacao;

    @Column(nullable = false)
    private Integer contadorInstalacao;

    @Column(nullable = false)
    private LocalDate dataRetirada;

    @Column(nullable = false)
    private Integer contadorRetirada;

    // -------------------------------------------------------------
    // Chave estrangeira: várias Instalações -> uma Impressora
    // -------------------------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY) //evita carregar uma impressora sempre que houver um instalação
    @JoinColumn(
            name = "id_impressora",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_instalacao_impressora")
    )
    private ImpressoraEntity impressora;
}