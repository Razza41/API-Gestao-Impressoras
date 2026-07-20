package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T19:24:49-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class ImpressoraMapperImpl implements ImpressoraMapper {

    @Autowired
    private ContadorMapper contadorMapper;

    @Override
    public ImpressoraEntity toEntity(ImpressoraRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ImpressoraEntity.ImpressoraEntityBuilder impressoraEntity = ImpressoraEntity.builder();

        impressoraEntity.marcaModelo( dto.marcaModelo() );
        impressoraEntity.numeroSerie( dto.numeroSerie() );

        return impressoraEntity.build();
    }

    @Override
    public ImpressoraResponseDTO toResponseDTO(ImpressoraEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String marcaModelo = null;
        String numeroSerie = null;
        ContadorResponseDTO contador = null;

        id = entity.getId();
        marcaModelo = entity.getMarcaModelo();
        numeroSerie = entity.getNumeroSerie();
        contador = contadorMapper.toResponseDTO( entity.getContador() );

        ImpressoraResponseDTO impressoraResponseDTO = new ImpressoraResponseDTO( id, marcaModelo, numeroSerie, contador );

        return impressoraResponseDTO;
    }

    @Override
    public List<ImpressoraResponseDTO> toResponseDTOList(List<ImpressoraEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ImpressoraResponseDTO> list = new ArrayList<ImpressoraResponseDTO>( entities.size() );
        for ( ImpressoraEntity impressoraEntity : entities ) {
            list.add( toResponseDTO( impressoraEntity ) );
        }

        return list;
    }
}
