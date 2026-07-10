package com.gestao.impressorasAPI.mapper;

import com.gestao.impressorasAPI.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.entity.InstalacaoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-10T14:29:12-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class InstalacaoMapperImpl implements InstalacaoMapper {

    @Override
    public InstalacaoEntity toEntity(InstalacaoDTO instalacaoDTO) {
        if ( instalacaoDTO == null ) {
            return null;
        }

        InstalacaoEntity.InstalacaoEntityBuilder instalacaoEntity = InstalacaoEntity.builder();

        instalacaoEntity.itemPedido( instalacaoDTO.itemPedido() );
        instalacaoEntity.localInstalacao( instalacaoDTO.localInstalacao() );
        instalacaoEntity.endereco( instalacaoDTO.endereco() );
        instalacaoEntity.transformador( instalacaoDTO.transformador() );
        instalacaoEntity.responsavelInstalacao( instalacaoDTO.responsavelInstalacao() );
        instalacaoEntity.ip( instalacaoDTO.ip() );
        instalacaoEntity.dataInstalacao( instalacaoDTO.dataInstalacao() );
        instalacaoEntity.contadorInstalacao( instalacaoDTO.contadorInstalacao() );
        instalacaoEntity.dataRetirada( instalacaoDTO.dataRetirada() );
        instalacaoEntity.contadorRetirada( instalacaoDTO.contadorRetirada() );

        return instalacaoEntity.build();
    }
}
