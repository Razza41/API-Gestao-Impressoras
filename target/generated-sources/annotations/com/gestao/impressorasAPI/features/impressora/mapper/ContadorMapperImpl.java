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
    date = "2026-07-20T14:44:24-0300",
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

        Long impressoraId = null;
        String marcaModelo = null;
        String numeroSerie = null;
        Long id = null;
        Integer contadorPB = null;
        Integer contadorColor = null;
        LocalDate dataLeitura = null;

        impressoraId = entityImpressoraId( entity );
        marcaModelo = entityImpressoraMarcaModelo( entity );
        numeroSerie = entityImpressoraNumeroSerie( entity );
        id = entity.getId();
        contadorPB = entity.getContadorPB();
        contadorColor = entity.getContadorColor();
        dataLeitura = entity.getDataLeitura();

        ContadorResponseDTO contadorResponseDTO = new ContadorResponseDTO( id, contadorPB, contadorColor, dataLeitura, impressoraId, marcaModelo, numeroSerie );

        return contadorResponseDTO;
    }

    private Long entityImpressoraId(ContadorEntity contadorEntity) {
        ImpressoraEntity impressora = contadorEntity.getImpressora();
        if ( impressora == null ) {
            return null;
        }
        return impressora.getId();
    }

    private String entityImpressoraMarcaModelo(ContadorEntity contadorEntity) {
        ImpressoraEntity impressora = contadorEntity.getImpressora();
        if ( impressora == null ) {
            return null;
        }
        return impressora.getMarcaModelo();
    }

    private String entityImpressoraNumeroSerie(ContadorEntity contadorEntity) {
        ImpressoraEntity impressora = contadorEntity.getImpressora();
        if ( impressora == null ) {
            return null;
        }
        return impressora.getNumeroSerie();
    }
}
