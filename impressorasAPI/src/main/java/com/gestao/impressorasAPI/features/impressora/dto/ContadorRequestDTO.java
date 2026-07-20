package com.gestao.impressorasAPI.features.impressora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ContadorRequestDTO(
        @PositiveOrZero(message = "Contador PB deve ser zero ou positivo")
        Integer contadorPB,

        @PositiveOrZero(message = "Contador Color deve ser zero ou positivo")
        Integer contadorColor,

        @NotNull(message = "ID da impressora é obrigatório")
        Long impressoraId
) {
}