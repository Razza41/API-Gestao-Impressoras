package com.gestao.impressorasAPI.features.shared.dto;


import jakarta.persistence.Embeddable;

@Embeddable
public record EnderecoDTO(
        String bairro,
        Integer numero,
        String rua) {
}
