package com.gestao.impressorasAPI.repository;

import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImpressoraRepository extends JpaRepository<ImpressoraEntity, Long> {

boolean existsByNumeroSerie(String numeroSerie);
boolean deleteByNumeroSerie(String numeroSerie);
Optional<ImpressoraEntity> findByNumeroSerie(String numeroSerie);
}
