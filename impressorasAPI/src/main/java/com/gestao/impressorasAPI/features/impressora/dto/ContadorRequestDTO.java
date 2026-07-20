package com.gestao.impressorasAPI.features.impressora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ContadorRequestDTO(
        @PositiveOrZero(message = "Contador preto e branco deve ser zero ou positivo")
        Integer contadorPB,

        @PositiveOrZero(message = "Contador colorido deve ser zero ou positivo")
        Integer contadorColor,

        @NotNull(message = "ID da impressora é obrigatório")
        Long impressoraId  // Frontend envia o ID da impressora selecionada
) {
}