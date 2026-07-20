package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstalacaoMapper {

    InstalacaoMapper INSTANCE = Mappers.getMapper(InstalacaoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "impressora", ignore = true) // Será setado no Service
    InstalacaoEntity toEntity(InstalacaoDTO dto);
}