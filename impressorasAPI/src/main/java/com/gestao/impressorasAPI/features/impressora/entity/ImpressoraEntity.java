package com.gestao.impressorasAPI.features.impressora.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "impressora")
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


    @OneToMany(mappedBy = "impressora", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    @Builder.Default
    private List<ContadorEntity> contadores = new ArrayList<>();
}