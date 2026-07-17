package com.gestao.impressorasAPI.features.impressora.repository;

import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstalacaoRepository extends JpaRepository<InstalacaoEntity, Long> {

    //verifica se existe pelo itemPedido (para delete)
    boolean existsByItemPedido(Integer itemPedido);

    //procura no banco de dados para retornar, caso encontre
    Optional<InstalacaoEntity> findByItemPedido(Integer itemPedido);

    void deleteByItemPedido(Integer itemPedido);
}
