package com.gestao.impressorasAPI.features.impressora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record InstalacaoDTO(
        @NotNull(message = "Item do pedido é obrigatório")
        @Positive(message = "Item do pedido deve ser positivo")
        Integer itemPedido,

        @NotNull(message = "Local de instalação é obrigatório")
        String localInstalacao,

        @NotNull(message = "Rua é obrigatória")
        String rua,

        @NotNull(message = "Número é obrigatório")
        @Positive(message = "Número deve ser positivo")
        Integer numero,

        @NotNull(message = "Bairro é obrigatório")
        String bairro,

        String transformador,

        @NotNull(message = "Responsável pela instalação é obrigatório")
        String responsavelInstalacao,

        @NotNull(message = "IP é obrigatório")
        String ip,

        @NotNull(message = "Data de instalação é obrigatória")
        LocalDate dataInstalacao,

        @NotNull(message = "Contador de instalação é obrigatório")
        Integer contadorInstalacao,

        @NotNull(message = "Data de retirada é obrigatória")
        LocalDate dataRetirada,

        @NotNull(message = "Contador de retirada é obrigatório")
        Integer contadorRetirada,

        @NotNull(message = "ID da impressora é obrigatório")
        Long idImpressora
) {
}