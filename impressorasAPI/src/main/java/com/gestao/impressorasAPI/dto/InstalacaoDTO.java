package com.gestao.impressorasAPI.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record InstalacaoDTO(

        @NotNull(message = "Item do pedido é obrigatório")
        Long itemPedido,

        @NotBlank(message = "Local de instalação é obrigatório")
        String localInstalacao,

        // DTO não utiliza @Embedded, pois não é uma entidade JPA.
        // O EnderecoDTO é apenas um objeto utilizado para transportar dados.
        @Valid
        EnderecoDTO endereco,

        String transformador,

        @NotBlank(message = "Responsável de instalação é obrigatório")
        String responsavelInstalacao,

        @NotBlank(message = "Informe o IP/Rede da impressora")
        String ip,

        @JsonSerialize(using = com.gestao.impressorasAPI.jackson.DataConversor.LocalDateSerializer.class) //recebe a data em formato JSON (ex: 01/01/2026)
        @JsonDeserialize(using = com.gestao.impressorasAPI.jackson.DataConversor.LocalDateDeserializer.class) //passa para o formato LocalDate 2026-01-01
        @NotNull(message = "Informe a data de instalação")
        LocalDate dataInstalacao,

        @NotNull(message = "Informe o contador atual da impressora")
        Integer contadorInstalacao,

        @JsonSerialize(using = com.gestao.impressorasAPI.jackson.DataConversor.LocalDateSerializer.class)
        @JsonDeserialize(using = com.gestao.impressorasAPI.jackson.DataConversor.LocalDateDeserializer.class)
        @NotNull(message = "Informe a data de retirada")
        LocalDate dataRetirada,

        @NotNull(message = "Informe o contador de retirada da impressora")
        Integer contadorRetirada
) {
}
