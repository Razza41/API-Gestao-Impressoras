package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ContadorMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ContadorService {

    private final ContadorRepository repository;
    private final ContadorMapper mapper;

    public ContadorEntity cadastrarContador (ContadorDTO contadorDTO){
        ContadorEntity contador = mapper.toEntity(contadorDTO);
        return  repository.save(contador);
    }




}
