package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.InstalacaoMapper;
import com.gestao.impressorasAPI.features.impressora.repository.InstalacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalacaoService {

    private final InstalacaoRepository instalacaoRepository;
    private final ImpressoraService impressoraService;
    private final InstalacaoMapper mapper;

    @Transactional
    public InstalacaoResponseDTO cadastrar(InstalacaoRequestDTO dto) {
        // 1. Buscar impressora
        ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.idImpressora());

        // 2. Converter DTO para Entity (MapStruct)
        InstalacaoEntity entity = mapper.toEntity(dto);
        entity.setImpressora(impressora);  // Associa a impressora

        // 3. Salvar
        InstalacaoEntity saved = instalacaoRepository.save(entity);

        // 4. Retornar DTO
        return mapper.toResponseDTO(saved);
    }

    public List<InstalacaoResponseDTO> listarTodas() {
        return mapper.toResponseDTOList(instalacaoRepository.findAll());
    }

    public InstalacaoResponseDTO buscarPorItemPedido(Integer itemPedido) {
        InstalacaoEntity entity = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(() -> new EntityNotFoundException("Instalação não encontrada"));
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public InstalacaoResponseDTO atualizar(Integer itemPedido, InstalacaoRequestDTO dto) {
        InstalacaoEntity entity = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(() -> new EntityNotFoundException("Instalação não encontrada"));

        // Atualizar campos
        entity.setLocalInstalacao(dto.localInstalacao());
        entity.setRua(dto.rua());
        entity.setNumero(dto.numero());
        entity.setBairro(dto.bairro());
        entity.setTransformador(dto.transformador());
        entity.setResponsavelInstalacao(dto.responsavelInstalacao());
        entity.setIp(dto.ip());
        entity.setDataInstalacao(dto.dataInstalacao());
        entity.setContadorInstalacao(dto.contadorInstalacao());
        entity.setDataRetirada(dto.dataRetirada());
        entity.setContadorRetirada(dto.contadorRetirada());

        // Atualizar impressora se necessário
        if (dto.idImpressora() != null) {
            ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.idImpressora());
            entity.setImpressora(impressora);
        }

        InstalacaoEntity updated = instalacaoRepository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Transactional
    public void deletar(Long id) {
        if (!instalacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Instalação não encontrada");
        }
        instalacaoRepository.deleteById(id);
    }
}