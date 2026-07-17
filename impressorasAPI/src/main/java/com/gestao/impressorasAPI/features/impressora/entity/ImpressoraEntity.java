package com.gestao.impressorasAPI.features.impressora.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Impressora")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImpressoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marcaModelo;

    @Column(nullable = false, unique = true)
    private String numeroSerie;

    // Relação inversa: uma Impressora tem um Contador
    @OneToOne(mappedBy = "impressora", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private ContadorEntity contador;

}
