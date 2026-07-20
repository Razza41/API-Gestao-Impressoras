package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContadorMapper {

    ContadorMapper INSTANCE = Mappers.getMapper(ContadorMapper.class);

    // Converte RequestDTO para Entity (com data automática)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataLeitura", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "impressora", source = "impressora")
    ContadorEntity toEntity(ContadorRequestDTO dto, ImpressoraEntity impressora);

    // Converte Entity para ResponseDTO
    @Mapping(target = "impressoraId", source = "impressora.id")
    @Mapping(target = "marcaModelo", source = "impressora.marcaModelo")
    @Mapping(target = "numeroSerie", source = "impressora.numeroSerie")
    ContadorResponseDTO toResponseDTO(ContadorEntity entity);
}