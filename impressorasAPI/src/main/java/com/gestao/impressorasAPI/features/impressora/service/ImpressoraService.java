package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.ImpressoraMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImpressoraService {

    private final ImpressoraRepository repository;
    private final ImpressoraMapper mapper;
    private final ContadorRepository contadorRepository;

    // ============================================================
    // LISTAR TODAS AS IMPRESSORAS COM O ÚLTIMO CONTADOR
    // ============================================================
    public List<ImpressoraResponseDTO> listarTodas() {
        List<ImpressoraEntity> impressoras = repository.findAll();

        return impressoras.stream()
                .map(this::toResponseDTOComUltimoContador)  // ← NOME CORRIGIDO
                .collect(Collectors.toList());
    }

    // ============================================================
    // BUSCAR IMPRESSORA POR ID COM O ÚLTIMO CONTADOR
    // ============================================================
    public ImpressoraResponseDTO buscarPorId(Long id) {
        ImpressoraEntity impressora = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));

        return toResponseDTOComUltimoContador(impressora);
    }

    // ============================================================
    // BUSCAR IMPRESSORA POR NÚMERO DE SÉRIE
    // ============================================================
    public ImpressoraResponseDTO buscarPorNumeroSerie(String numeroSerie) {
        ImpressoraEntity impressora = repository.findByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException("Impressora com número de série " + numeroSerie + " não encontrada"));

        return toResponseDTOComUltimoContador(impressora);
    }

    // ============================================================
    // MÉTODO PRIVADO: CONVERTE ENTITY PARA DTO COM ÚLTIMO CONTADOR
    // ============================================================
    private ImpressoraResponseDTO toResponseDTOComUltimoContador(ImpressoraEntity impressora) {
        // 1. Converte a impressora para DTO (sem contador)
        ImpressoraResponseDTO dto = mapper.toResponseDTO(impressora);

        // 2. Busca o último contador
        ContadorResponseDTO ultimoContador = contadorRepository
                .findTopByImpressoraIdOrderByDataLeituraDesc(impressora.getId())
                .map(contador -> new ContadorResponseDTO(
                        contador.getId(),
                        contador.getContadorPB(),
                        contador.getContadorColor(),
                        contador.getDataLeitura()
                ))
                .orElse(null);

        // 3. Retorna um novo DTO com o último contador
        return new ImpressoraResponseDTO(
                dto.id(),
                dto.marcaModelo(),
                dto.numeroSerie(),
                ultimoContador
        );
    }

    // ============================================================
    // MÉTODOS INTERNOS (para outros services)
    // ============================================================
    public ImpressoraEntity buscarEntityPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));
    }

    @Transactional
    public ImpressoraEntity salvarEntity(ImpressoraEntity entity) {
        return repository.save(entity);
    }

    @Transactional
    public ImpressoraResponseDTO cadastrar(ImpressoraRequestDTO dto) {
        ImpressoraEntity entity = mapper.toEntity(dto);
        ImpressoraEntity saved = repository.save(entity);
        return buscarPorId(saved.getId());
    }

    @Transactional
    public ImpressoraResponseDTO atualizar(Long id, ImpressoraRequestDTO dto) {
        ImpressoraEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));

        entity.setMarcaModelo(dto.marcaModelo());
        entity.setNumeroSerie(dto.numeroSerie());

        ImpressoraEntity updated = repository.save(entity);
        return buscarPorId(updated.getId());
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Impressora não encontrada");
        }
        repository.deleteById(id);
    }
}