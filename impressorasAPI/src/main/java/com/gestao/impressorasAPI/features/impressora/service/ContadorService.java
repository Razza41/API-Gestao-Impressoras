package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ContadorMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContadorService {

    private final ContadorRepository contadorRepository;
    private final ImpressoraService impressoraService;
    private final ContadorMapper mapper;

    @Transactional
    public ContadorResponseDTO cadastrar(ContadorRequestDTO dto) {
        // 1. Buscar impressora
        ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.impressoraId());

        // 2. Verificar se já existe contador
        if (impressora.getContador() != null) {
            throw new RuntimeException("Esta impressora já possui um contador cadastrado");
        }

        // 3. Converter DTO para Entity (MapStruct coloca data automática)
        ContadorEntity entity = mapper.toEntity(dto, impressora);

        // 4. Salvar
        ContadorEntity saved = contadorRepository.save(entity);

        // 5. Retornar DTO
        return mapper.toResponseDTO(saved);
    }

    public List<ContadorResponseDTO> listarTodos() {
        return contadorRepository.findAll().stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public ContadorResponseDTO buscarPorImpressoraId(Long impressoraId) {
        ImpressoraEntity impressora = impressoraService.buscarEntityPorId(impressoraId);

        if (impressora.getContador() == null) {
            throw new RuntimeException("Esta impressora não possui contador cadastrado");
        }

        return mapper.toResponseDTO(impressora.getContador());
    }
}