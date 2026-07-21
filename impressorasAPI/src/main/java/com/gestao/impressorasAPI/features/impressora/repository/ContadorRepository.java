package com.gestao.impressorasAPI.features.impressora.repository;

import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ContadorRepository extends JpaRepository<ContadorEntity, Long> {

    //  BUSCA O ÚLTIMO CONTADOR DE UMA IMPRESSORA
    Optional<ContadorEntity> findTopByImpressoraIdOrderByDataLeituraDesc(Long impressoraId);

    //  LISTA CONTADORES DE UMA IMPRESSORA COM PAGINAÇÃO
    Page<ContadorEntity> findByImpressoraId(Long impressoraId, Pageable pageable);

    //  VERIFICA SE EXISTE CONTADOR PARA UMA IMPRESSORA
    boolean existsByImpressoraId(Long impressoraId);

    //  CONTA QUANTOS CONTADORES UMA IMPRESSORA TEM
    long countByImpressoraId(Long impressoraId);

    //  DELETA TODOS OS CONTADORES DE UMA IMPRESSORA
    @Modifying
    @Transactional
    @Query("DELETE FROM ContadorEntity c WHERE c.impressora.id = :impressoraId")
    void deleteByImpressoraId(@Param("impressoraId") Long impressoraId);
}