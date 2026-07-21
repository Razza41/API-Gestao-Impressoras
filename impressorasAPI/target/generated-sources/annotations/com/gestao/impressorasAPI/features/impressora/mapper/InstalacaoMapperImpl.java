package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-21T10:38:43-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.3 (Microsoft)"
)
@Component
public class InstalacaoMapperImpl implements InstalacaoMapper {

    @Autowired
    private ImpressoraMapper impressoraMapper;

    @Override
    public InstalacaoEntity toEntity(InstalacaoRequestDTO dto) {
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

    @Override
    public InstalacaoResponseDTO toResponseDTO(InstalacaoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        ImpressoraResponseDTO impressora = null;
        Integer itemPedido = null;
        String localInstalacao = null;
        String rua = null;
        Integer numero = null;
        String bairro = null;
        String transformador = null;
        String responsavelInstalacao = null;
        String ip = null;
        LocalDate dataInstalacao = null;
        Integer contadorInstalacao = null;
        LocalDate dataRetirada = null;
        Integer contadorRetirada = null;

        id = entity.getId();
        impressora = impressoraMapper.toResponseDTO( entity.getImpressora() );
        itemPedido = entity.getItemPedido();
        localInstalacao = entity.getLocalInstalacao();
        rua = entity.getRua();
        numero = entity.getNumero();
        bairro = entity.getBairro();
        transformador = entity.getTransformador();
        responsavelInstalacao = entity.getResponsavelInstalacao();
        ip = entity.getIp();
        dataInstalacao = entity.getDataInstalacao();
        contadorInstalacao = entity.getContadorInstalacao();
        dataRetirada = entity.getDataRetirada();
        contadorRetirada = entity.getContadorRetirada();

        InstalacaoResponseDTO instalacaoResponseDTO = new InstalacaoResponseDTO( id, itemPedido, localInstalacao, rua, numero, bairro, transformador, responsavelInstalacao, ip, dataInstalacao, contadorInstalacao, dataRetirada, contadorRetirada, impressora );

        return instalacaoResponseDTO;
    }

    @Override
    public List<InstalacaoResponseDTO> toResponseDTOList(List<InstalacaoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<InstalacaoResponseDTO> list = new ArrayList<InstalacaoResponseDTO>( entities.size() );
        for ( InstalacaoEntity instalacaoEntity : entities ) {
            list.add( toResponseDTO( instalacaoEntity ) );
        }

        return list;
    }
}
