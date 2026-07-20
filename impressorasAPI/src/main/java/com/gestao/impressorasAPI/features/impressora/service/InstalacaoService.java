package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.InstalacaoMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import com.gestao.impressorasAPI.features.impressora.repository.InstalacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalacaoService {

    private final ImpressoraRepository impressoraRepository;
    private final InstalacaoRepository instalacaoRepository;
    private final InstalacaoMapper mapper;

    @Transactional
    public InstalacaoEntity cadastrarInstalacao(InstalacaoDTO instalacaoDTO) {
        // 1. Buscar a impressora
        ImpressoraEntity impressora = impressoraRepository.findById(instalacaoDTO.idImpressora())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Impressora com ID " + instalacaoDTO.idImpressora() + " não encontrada"
                ));

        // 2. Converter DTO para Entity
        InstalacaoEntity instalacao = mapper.toEntity(instalacaoDTO);

        // 3. Associar a impressora
        instalacao.setImpressora(impressora);

        // 4. Salvar
        return instalacaoRepository.save(instalacao);
    }

    @Transactional
    public InstalacaoEntity atualizarInstalacao(Integer itemPedido, InstalacaoDTO instalacaoDTO) {
        // 1. Buscar instalação existente
        InstalacaoEntity instalacao = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(() -> new EntityNotFoundException("Instalação com item pedido " + itemPedido + " não encontrada"));

        // 2. Atualizar dados
        instalacao.setLocalInstalacao(instalacaoDTO.localInstalacao());
        instalacao.setRua(instalacaoDTO.rua());
        instalacao.setNumero(instalacaoDTO.numero());
        instalacao.setBairro(instalacaoDTO.bairro());
        instalacao.setTransformador(instalacaoDTO.transformador());
        instalacao.setResponsavelInstalacao(instalacaoDTO.responsavelInstalacao());
        instalacao.setIp(instalacaoDTO.ip());
        instalacao.setDataInstalacao(instalacaoDTO.dataInstalacao());
        instalacao.setContadorInstalacao(instalacaoDTO.contadorInstalacao());
        instalacao.setDataRetirada(instalacaoDTO.dataRetirada());
        instalacao.setContadorRetirada(instalacaoDTO.contadorRetirada());

        // 3. Atualizar impressora se necessário
        if (instalacaoDTO.idImpressora() != null) {
            ImpressoraEntity impressora = impressoraRepository.findById(instalacaoDTO.idImpressora())
                    .orElseThrow(() -> new EntityNotFoundException("Impressora não encontrada"));
            instalacao.setImpressora(impressora);
        }

        return instalacaoRepository.save(instalacao);
    }

    @Transactional
    public void deletarInstalacao(Long id) {
        if (!instalacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Dados de instalação não encontrados!");
        }
        instalacaoRepository.deleteById(id);
    }

    public List<InstalacaoEntity> listarInstalacoes() {
        return instalacaoRepository.findAll();
    }
}