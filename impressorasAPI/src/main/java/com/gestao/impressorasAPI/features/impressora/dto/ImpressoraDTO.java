package com.gestao.impressorasAPI.features.impressora.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.UniqueElements;

@Builder
public record ImpressoraDTO(
        @NotNull(message = "Informe a marca e o modelo da Impressora")
        String marcaModelo,

        @NotNull(message = "Informe o nÃºmero de sÃ©rie da Impressora!")
        String numeroSerie
) {
}
