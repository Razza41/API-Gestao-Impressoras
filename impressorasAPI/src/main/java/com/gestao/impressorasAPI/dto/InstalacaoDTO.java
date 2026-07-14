package com.gestao.impressorasAPI.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


import java.time.LocalDate;

@Builder
public record InstalacaoDTO(

        @NotNull(message = "Item do pedido é obrigatório")
        Integer itemPedido,

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

        @NotNull(message = "Informe a data de instalação")
        LocalDate dataInstalacao,

        @NotNull(message = "Informe o contador atual da impressora")
        Integer contadorInstalacao,

        @NotNull(message = "Informe a data de retirada")
        LocalDate dataRetirada,

        @NotNull(message = "Informe o contador de retirada da impressora")
        Integer contadorRetirada,

        @NotNull(message = "Informe o ID do tipo de impressora que será instalada!")
        Long id_impressora
) {
}
