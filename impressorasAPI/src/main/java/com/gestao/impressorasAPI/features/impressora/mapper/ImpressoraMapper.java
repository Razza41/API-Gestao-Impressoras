package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ContadorMapper.class})
public interface ImpressoraMapper {

    ImpressoraMapper INSTANCE = Mappers.getMapper(ImpressoraMapper.class);

    // 👇 Request → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contador", ignore = true)  // Contador será criado separadamente
    ImpressoraEntity toEntity(ImpressoraRequestDTO dto);

    // 👇 Entity → Response (com contador)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "marcaModelo", source = "marcaModelo")
    @Mapping(target = "numeroSerie", source = "numeroSerie")
    @Mapping(target = "contador", source = "contador")
    ImpressoraResponseDTO toResponseDTO(ImpressoraEntity entity);

    // 👇 Para conversão da lista
    List<ImpressoraResponseDTO> toResponseDTOList(List<ImpressoraEntity> entities);
}