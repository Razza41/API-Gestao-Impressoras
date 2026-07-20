package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ImpressoraMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpressoraService {

    private final ImpressoraRepository repository;
    private final ImpressoraMapper mapper;

    public List<ImpressoraResponseDTO> listarTodas() {
        return mapper.toResponseDTOList(repository.findAll());
    }

    public ImpressoraResponseDTO buscarPorId(Long id) {
        ImpressoraEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));
        return mapper.toResponseDTO(entity);
    }

    public ImpressoraResponseDTO buscarPorNumeroSerie(String numeroSerie) {
        ImpressoraEntity entity = repository.findByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public ImpressoraResponseDTO cadastrar(ImpressoraRequestDTO dto) {
        ImpressoraEntity entity = mapper.toEntity(dto);
        ImpressoraEntity saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Transactional
    public ImpressoraResponseDTO atualizar(Long id, ImpressoraRequestDTO dto) {
        ImpressoraEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));

        entity.setMarcaModelo(dto.marcaModelo());
        entity.setNumeroSerie(dto.numeroSerie());

        ImpressoraEntity updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Impressora não encontrada");
        }
        repository.deleteById(id);
    }

    // 👇 Método para uso interno de outros Services
    public ImpressoraEntity buscarEntityPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));
    }
}