package com.gestao.impressorasAPI.mapper;

import com.gestao.impressorasAPI.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ImpressoraMapper {

    @Mapping(target = "id", ignore = true)
    ImpressoraEntity toEntity(ImpressoraDTO impressoraDTO);
}
