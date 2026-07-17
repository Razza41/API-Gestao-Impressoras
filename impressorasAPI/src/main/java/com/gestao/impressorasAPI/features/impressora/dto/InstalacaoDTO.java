package com.gestao.impressorasAPI.features.impressora.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


import java.time.LocalDate;

@Builder
public record InstalacaoDTO(

        @NotNull(message = "Item do pedido Ã© obrigatÃ³rio")
        Integer itemPedido,

        @NotBlank(message = "Local de instalaÃ§Ã£o Ã© obrigatÃ³rio")
        String localInstalacao,

        String rua,

        Integer numero,

        String bairro,

        String transformador,

        @NotBlank(message = "ResponsÃ¡vel de instalaÃ§Ã£o Ã© obrigatÃ³rio")
        String responsavelInstalacao,

        @NotBlank(message = "Informe o IP/Rede da impressora")
        String ip,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "Informe a data de instalaÃ§Ã£o")
        LocalDate dataInstalacao,

        @NotNull(message = "Informe o contador atual da impressora")
        Integer contadorInstalacao,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "Informe a data de retirada")
        LocalDate dataRetirada,

        @NotNull(message = "Informe o contador de retirada da impressora")
        Integer contadorRetirada

        /**
        @NotNull(message = "Informe o ID do tipo de impressora que serÃ¡ instalada!")
        Long id_impressora
        */
) {
}
