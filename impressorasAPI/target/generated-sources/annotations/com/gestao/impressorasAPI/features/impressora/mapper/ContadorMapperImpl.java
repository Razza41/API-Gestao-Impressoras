package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-21T16:18:15-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class ContadorMapperImpl implements ContadorMapper {

    @Override
    public ContadorEntity toEntity(ContadorRequestDTO dto, ImpressoraEntity impressora) {
        if ( dto == null && impressora == null ) {
            return null;
        }

        ContadorEntity contadorEntity = new ContadorEntity();

        if ( dto != null ) {
            contadorEntity.setContadorPB( dto.contadorPB() );
            contadorEntity.setContadorColor( dto.contadorColor() );
        }
        contadorEntity.setImpressora( impressora );
        contadorEntity.setDataLeitura( java.time.LocalDate.now() );

        return contadorEntity;
    }

    @Override
    public ContadorResponseDTO toResponseDTO(ContadorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        Integer contadorPB = null;
        Integer contadorColor = null;
        LocalDate dataLeitura = null;

        id = entity.getId();
        contadorPB = entity.getContadorPB();
        contadorColor = entity.getContadorColor();
        dataLeitura = entity.getDataLeitura();

        ContadorResponseDTO contadorResponseDTO = new ContadorResponseDTO( id, contadorPB, contadorColor, dataLeitura );

        return contadorResponseDTO;
    }
}
