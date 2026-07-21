package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ContadorEntity;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ContadorMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ContadorService {

    private final ContadorRepository contadorRepository;
    private final ImpressoraService impressoraService;
    private final ContadorMapper mapper;


    // cadastrar nova leitura

    @Transactional
    public ContadorResponseDTO cadastrar(ContadorRequestDTO dto) {
        // 1. Buscar a impressora
        ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.impressoraId());

        // 2. Criar o contador
        ContadorEntity entity = new ContadorEntity();
        entity.setContadorPB(dto.contadorPB());
        entity.setContadorColor(dto.contadorColor());
        entity.setDataLeitura(LocalDate.now());
        entity.setImpressora(impressora);

        // 3. Adicionar à lista da impressora (para manter a relação)
        impressora.getContadores().add(entity);

        // 4. Salvar (cascade salva o contador também)
        impressoraService.salvarEntity(impressora);

        // 5. Retornar o DTO
        return mapper.toResponseDTO(entity);
    }

//buscar contador por ID
    public ContadorResponseDTO buscarPorId(Long id) {
        ContadorEntity entity = contadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contador não encontrado com ID: " + id));
        return mapper.toResponseDTO(entity);
    }

   //listar contadores pela impressora
    public Page<ContadorResponseDTO> listarPorImpressora(Long impressoraId, Pageable pageable) {
        // Verifica se a impressora existe
        impressoraService.buscarEntityPorId(impressoraId);

        return contadorRepository.findByImpressoraId(impressoraId, pageable)
                .map(mapper::toResponseDTO);
    }

//buscar o ultimo contador da impressora
    public ContadorResponseDTO buscarUltimoPorImpressora(Long impressoraId) {
        // Verifica se a impressora existe
        impressoraService.buscarEntityPorId(impressoraId);

        ContadorEntity ultimo = contadorRepository
                .findTopByImpressoraIdOrderByDataLeituraDesc(impressoraId)
                .orElseThrow(() -> new RuntimeException(
                        "Esta impressora não possui contadores cadastrados"
                ));

        return mapper.toResponseDTO(ultimo);
    }

  //buscar historico total da impressora com paginação
    public Page<ContadorResponseDTO> buscarHistorico(Long impressoraId, Pageable pageable) {
        // Verifica se a impressora existe
        impressoraService.buscarEntityPorId(impressoraId);

        return contadorRepository.findByImpressoraId(impressoraId, pageable)
                .map(mapper::toResponseDTO);
    }

   //verifica se existe contador para a impressora
    public boolean existeContador(Long impressoraId) {
        // Verifica se a impressora existe
        impressoraService.buscarEntityPorId(impressoraId);

        return contadorRepository.existsByImpressoraId(impressoraId);
    }

   //deletar contador pelo ID
    @Transactional
    public void deletar(Long id) {
        if (!contadorRepository.existsById(id)) {
            throw new RuntimeException("Contador não encontrado com ID: " + id);
        }
        contadorRepository.deleteById(id);
    }

  //deletar todos os contadores de uma impressora pelo ID
    @Transactional
    public void deletarTodosPorImpressora(Long impressoraId) {
        // Verifica se a impressora existe
        impressoraService.buscarEntityPorId(impressoraId);

        contadorRepository.deleteByImpressoraId(impressoraId);
    }
}