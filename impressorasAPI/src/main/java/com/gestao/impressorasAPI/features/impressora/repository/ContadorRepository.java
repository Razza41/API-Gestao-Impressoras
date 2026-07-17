package com.gestao.impressorasAPI.features.impressora.repository;

import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContadorRepository extends JpaRepository<ContadorEntity, Long> {
}
