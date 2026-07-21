package com.gestao.impressorasAPI.features.impressora.dto;

import java.time.LocalDate;

public record ContadorResponseDTO(
        Long id,
        Integer contadorPB,
        Integer contadorColor,
        LocalDate dataLeitura
) {
}