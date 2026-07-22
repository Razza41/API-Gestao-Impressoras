package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImpressoraMapper.class})
public interface InstalacaoMapper {

    InstalacaoMapper INSTANCE = Mappers.getMapper(InstalacaoMapper.class);

    // transforma Request para Entity (impressora será setada no Service)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "impressora", ignore = true)  // Será setada no Service
    InstalacaoEntity toEntity(InstalacaoRequestDTO dto);

    //transforma Entity para Response (com impressora)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "impressora", source = "impressora")
    InstalacaoResponseDTO toResponseDTO(InstalacaoEntity entity);

    //  Para conversão da lista de entidades para response
    List<InstalacaoResponseDTO> toResponseDTOList(List<InstalacaoEntity> entities);
}