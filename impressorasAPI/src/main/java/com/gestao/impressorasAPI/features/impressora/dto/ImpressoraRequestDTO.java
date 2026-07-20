package com.gestao.impressorasAPI.features.impressora.dto;

import jakarta.validation.constraints.NotBlank;

public record ImpressoraRequestDTO(
        @NotBlank(message = "Marca/Modelo é obrigatório")
        String marcaModelo,

        @NotBlank(message = "Número de série é obrigatório")
        String numeroSerie
) {
}