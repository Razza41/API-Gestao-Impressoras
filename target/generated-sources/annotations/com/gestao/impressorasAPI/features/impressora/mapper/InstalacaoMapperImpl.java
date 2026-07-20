package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-20T14:44:25-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class InstalacaoMapperImpl implements InstalacaoMapper {

    @Override
    public InstalacaoEntity toEntity(InstalacaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InstalacaoEntity.InstalacaoEntityBuilder instalacaoEntity = InstalacaoEntity.builder();

        instalacaoEntity.itemPedido( dto.itemPedido() );
        instalacaoEntity.localInstalacao( dto.localInstalacao() );
        instalacaoEntity.rua( dto.rua() );
        instalacaoEntity.numero( dto.numero() );
        instalacaoEntity.bairro( dto.bairro() );
        instalacaoEntity.transformador( dto.transformador() );
        instalacaoEntity.responsavelInstalacao( dto.responsavelInstalacao() );
        instalacaoEntity.ip( dto.ip() );
        instalacaoEntity.dataInstalacao( dto.dataInstalacao() );
        instalacaoEntity.contadorInstalacao( dto.contadorInstalacao() );
        instalacaoEntity.dataRetirada( dto.dataRetirada() );
        instalacaoEntity.contadorRetirada( dto.contadorRetirada() );

        return instalacaoEntity.build();
    }
}
