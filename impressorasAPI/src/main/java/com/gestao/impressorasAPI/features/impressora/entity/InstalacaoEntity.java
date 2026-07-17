package com.gestao.impressorasAPI.features.impressora.entity;


import com.gestao.impressorasAPI.features.shared.dto.EnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "instalacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstalacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer itemPedido;

    @Column(nullable = false)
    private String localInstalacao;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String bairro;

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
    // Chave estrangeira: vÃ¡rias InstalaÃ§Ãµes -> uma Impressora
    // -------------------------------------------------------------
/**
    @ManyToOne(fetch = FetchType.LAZY) //evita carregar uma impressora sempre que houver um instalaÃ§Ã£o
    @JoinColumn(name = "id_impressora", nullable = false, foreignKey = @ForeignKey(name = "fk_instalacao_impressora"))
    private ImpressoraEntity impressora;
    */


}