package com.gestao.impressorasAPI.features.impressora.dto;

public record ImpressoraResponseDTO(
        Long id,
        String marcaModelo,
        String numeroSerie,
        ContadorResponseDTO contador  // 👈 Contém o contador, mas sem referência de volta
) {
}