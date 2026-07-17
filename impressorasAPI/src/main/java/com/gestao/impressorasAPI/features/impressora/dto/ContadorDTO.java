package com.gestao.impressorasAPI.features.impressora.dto;

import java.time.LocalDate;

public record ContadorDTO(
        Integer contadorPB,
        Integer contadorColor,
        LocalDate dataLeitura,
        Long impressora //id da impressora vinculada ao contador
) {
}
