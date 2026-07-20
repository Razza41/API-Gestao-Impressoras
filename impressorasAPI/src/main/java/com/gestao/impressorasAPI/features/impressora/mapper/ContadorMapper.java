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

    // 👇 Request + Impressora → Entity (data automática)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataLeitura", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "impressora", source = "impressora")
    ContadorEntity toEntity(ContadorRequestDTO dto, ImpressoraEntity impressora);

    // 👇 Entity → Response (SEM impressora)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "contadorPB", source = "contadorPB")
    @Mapping(target = "contadorColor", source = "contadorColor")
    @Mapping(target = "dataLeitura", source = "dataLeitura")
    ContadorResponseDTO toResponseDTO(ContadorEntity entity);
}