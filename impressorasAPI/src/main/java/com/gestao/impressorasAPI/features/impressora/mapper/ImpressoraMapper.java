package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImpressoraMapper {


    ImpressoraMapper INSTANCE = Mappers.getMapper(ImpressoraMapper.class);


    // converte entidade para dto
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contadores", ignore = true)
    ImpressoraEntity toEntity(ImpressoraRequestDTO dto);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "marcaModelo", source = "marcaModelo")
    @Mapping(target = "numeroSerie", source = "numeroSerie")
    //não mapeia "ultimoContador" - será setado no Service
    ImpressoraResponseDTO toResponseDTO(ImpressoraEntity entity);

//converte lista de entidades para response
    List<ImpressoraResponseDTO> toResponseDTOList(List<ImpressoraEntity> entities);
}