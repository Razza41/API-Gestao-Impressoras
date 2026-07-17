package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContadorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "impressora", ignore = true) // setado manualmente no service
    ContadorEntity toEntity(ContadorDTO contadorDTO);
}
