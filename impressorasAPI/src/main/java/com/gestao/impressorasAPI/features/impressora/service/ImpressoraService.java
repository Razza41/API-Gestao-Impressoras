package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ImpressoraMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpressoraService {

    private final ImpressoraRepository repository;
    private final ImpressoraMapper mapper;

    public ImpressoraEntity cadastrarImpressora(ImpressoraDTO impressoraDTO){
        if (repository.existsByNumeroSerie(impressoraDTO.numeroSerie())){
            throw new IllegalArgumentException("NÃºmero de sÃ©rie jÃ¡ cadastrado");
        }
        ImpressoraEntity impressora = mapper.toEntity(impressoraDTO);
        return repository.save(impressora);
    }

    public void deletarImpressora(String numeroSerie){
        if (!repository.existsByNumeroSerie(numeroSerie)){
            throw new EntityNotFoundException("Impressora com nÃºmero de sÃ©rie nÃ£o existente");
        }else{
            repository.deleteByNumeroSerie(numeroSerie);
        }
    }

    public void deletarImpressoraId(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Impressora com ID nÃ£o existente");
        }else{
            repository.deleteById(id);
        }
    }

    public List<ImpressoraEntity> listarImpressoras(){
        return repository.findAll();
    }

}
