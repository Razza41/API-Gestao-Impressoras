package com.gestao.impressorasAPI.features.impressora.dto;

import java.time.LocalDate;

public record InstalacaoResponseDTO(
        Long id,
        Integer itemPedido,
        String localInstalacao,
        String rua,
        Integer numero,
        String bairro,
        String transformador,
        String responsavelInstalacao,
        String ip,
        LocalDate dataInstalacao,
        Integer contadorInstalacao,
        LocalDate dataRetirada,
        Integer contadorRetirada,
        ImpressoraResponseDTO impressora  // 👈 Contém a impressora, sem referência de volta
) {
}