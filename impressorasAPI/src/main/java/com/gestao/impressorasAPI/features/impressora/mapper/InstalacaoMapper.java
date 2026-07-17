package com.gestao.impressorasAPI.features.impressora.mapper;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper (componentModel = "spring")  /*faz com que ao criar a implementaÃ§Ã£o, jÃ¡ venha com a injeÃ§Ã£o de dependÃªncias */
public interface InstalacaoMapper{
    @Mapping(target = "id", ignore = true)
    InstalacaoEntity toEntity(InstalacaoDTO instalacaoDTO); //para o mapper funcionar, o nome das variÃ¡veis de Entity e DTO precisam ser iguais
}
