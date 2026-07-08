package com.gestao.impressorasAPI.service;

import com.gestao.impressorasAPI.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.repository.ImpressoraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpressoraService {

    private final ImpressoraRepository repository;

    public ImpressoraEntity cadastrarImpressora(ImpressoraDTO impressoraDTO){
        ImpressoraEntity impressora = ImpressoraEntity.builder().
                marcaModelo(impressoraDTO.marcaModelo()).
                build();
        return repository.save(impressora);
    }

    public void deletarImpressora(Long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Impressora com ID não existente");
        }else{
            repository.deleteById(id);
        }
    }

    public List<ImpressoraEntity> listarImpressoras(){
        return repository.findAll();
    }

}
