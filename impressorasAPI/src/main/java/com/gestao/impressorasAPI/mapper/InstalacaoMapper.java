package com.gestao.impressorasAPI.mapper;

import com.gestao.impressorasAPI.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.entity.InstalacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper (componentModel = "spring")  /*faz com que ao criar a implementação, já venha com a injeção de dependências */
public interface InstalacaoMapper{
    @Mapping(target = "impressora", ignore = true)
    InstalacaoEntity toEntity(InstalacaoDTO instalacaoDTO); //para o mapper funcionar, o nome das variáveis de Entity e DTO precisam ser iguais
}
