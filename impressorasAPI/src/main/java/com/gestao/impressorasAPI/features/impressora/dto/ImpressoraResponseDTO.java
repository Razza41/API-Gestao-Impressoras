package com.gestao.impressorasAPI.features.impressora.dto;

public record ImpressoraResponseDTO(
        Long id,
        String marcaModelo,
        String numeroSerie,
        ContadorResponseDTO ultimoContador
) {
}