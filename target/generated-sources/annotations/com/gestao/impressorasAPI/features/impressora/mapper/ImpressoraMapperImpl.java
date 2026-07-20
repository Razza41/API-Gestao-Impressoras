package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-16T13:02:55-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class ImpressoraMapperImpl implements ImpressoraMapper {

    @Override
    public ImpressoraEntity toEntity(ImpressoraDTO impressoraDTO) {
        if ( impressoraDTO == null ) {
            return null;
        }

        ImpressoraEntity.ImpressoraEntityBuilder impressoraEntity = ImpressoraEntity.builder();

        impressoraEntity.marcaModelo( impressoraDTO.marcaModelo() );
        impressoraEntity.numeroSerie( impressoraDTO.numeroSerie() );

        return impressoraEntity.build();
    }
}
