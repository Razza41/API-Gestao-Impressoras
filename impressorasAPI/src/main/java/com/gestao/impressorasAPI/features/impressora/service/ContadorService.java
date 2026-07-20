package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ContadorMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContadorService {

    private final ContadorRepository repository;
    private final ContadorMapper mapper;
    private final ImpressoraRepository impressoraRepository;

    @Transactional
    public ContadorResponseDTO cadastrarContador(ContadorRequestDTO contadorRequest) {
        // 1. Buscar a impressora pelo ID
        ImpressoraEntity impressora = impressoraRepository.findById(contadorRequest.impressoraId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Impressora com ID " + contadorRequest.impressoraId() + " não encontrada"
                ));

        // 2. Verificar se já existe contador para esta impressora
        if (impressora.getContador() != null) {
            throw new RuntimeException("Esta impressora já possui um contador cadastrado");
        }

        // 3. Converter DTO para Entity (MapStruct já coloca a data automática)
        ContadorEntity contador = mapper.toEntity(contadorRequest, impressora);

        // 4. Salvar
        ContadorEntity saved = repository.save(contador);

        // 5. Retornar DTO de resposta
        return mapper.toResponseDTO(saved);
    }

    public List<ContadorResponseDTO> listarTodosContadores() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public ContadorResponseDTO buscarContadorPorImpressora(Long impressoraId) {
        ImpressoraEntity impressora = impressoraRepository.findById(impressoraId)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));

        if (impressora.getContador() == null) {
            throw new RuntimeException("Esta impressora não possui contador cadastrado");
        }

        return mapper.toResponseDTO(impressora.getContador());
    }
}