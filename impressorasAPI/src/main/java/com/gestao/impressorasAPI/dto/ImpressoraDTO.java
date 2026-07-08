package com.gestao.impressorasAPI.dto;

import jakarta.validation.constraints.NotNull;

public record ImpressoraDTO(
        @NotNull(message = "Informe a marca e o modelo da Impressora")
        String marcaModelo
) {
}
