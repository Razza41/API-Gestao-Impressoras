package com.gestao.impressorasAPI.features.impressora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "contador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "contador_preto_branco")
    @PositiveOrZero(message = "Contador preto e branco deve ser zero ou positivo")
    private Integer contadorPB;

    @Column(name = "contador_colorido")
    @PositiveOrZero(message = "Contador colorido deve ser zero ou positivo")
    private Integer contadorColor;

    @Column(nullable = false)
    @NotNull(message = "Data de leitura nÃ£o pode ser nula")
    private LocalDate dataLeitura;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_impressora_fk", nullable = false, unique = true, 
                foreignKey = @ForeignKey(name = "fk_contador_impressora"))
    @NotNull(message = "Impressora nÃ£o pode ser nula")
    private ImpressoraEntity impressora;


}
