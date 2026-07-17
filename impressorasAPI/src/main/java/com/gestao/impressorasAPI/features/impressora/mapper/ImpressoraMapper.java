package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ImpressoraMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contador", ignore = true)
    ImpressoraEntity toEntity(ImpressoraDTO impressoraDTO);
}
