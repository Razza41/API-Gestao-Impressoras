package com.gestao.impressorasAPI.service;

import aj.org.objectweb.asm.TypeReference;
import com.gestao.impressorasAPI.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.mapper.InstalacaoMapper;
import com.gestao.impressorasAPI.repository.ImpressoraRepository;
import com.gestao.impressorasAPI.repository.InstalacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstalacaoService {

    private final ImpressoraRepository impressoraRepository;
    private final InstalacaoRepository instalacaoRepository;
    private final InstalacaoMapper mapper;

    public InstalacaoEntity cadastrarInstalacao(InstalacaoDTO instalacaoDTO){
        //busca a impressora no banco de dados
        ImpressoraEntity impressora = impressoraRepository.findById(instalacaoDTO.id_impressora())
                .orElseThrow(() -> new RuntimeException("Impressora não encontrada"));

        //cria objeto instalação com base nos dados passados no JSON
        InstalacaoEntity instalacao = mapper.toEntity(instalacaoDTO);

        //salva no banco de dados
        return instalacaoRepository.save(instalacao);
    }

    public InstalacaoEntity atualizarInstalacao(Integer itemPedido, InstalacaoDTO instalacaoDTO){
        //valida se existe no banco de dados
        InstalacaoEntity instalacao = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(()-> new EntityNotFoundException("Informe um número de item de pedido válido por favor!"));

        instalacao.setLocalInstalacao(instalacaoDTO.localInstalacao());
        instalacao.setEndereco(instalacaoDTO.endereco());
        instalacao.setTransformador(instalacaoDTO.transformador());
        instalacao.setResponsavelInstalacao(instalacaoDTO.responsavelInstalacao());
        instalacao.setIp(instalacaoDTO.ip());
        instalacao.setDataInstalacao(instalacaoDTO.dataInstalacao());
        instalacao.setContadorInstalacao(instalacaoDTO.contadorInstalacao());
        instalacao.setDataRetirada(instalacaoDTO.dataRetirada());
        instalacao.setContadorRetirada(instalacaoDTO.contadorRetirada());
        //PRECISO SETTAR O ID DE IMPRESSORA
        return instalacaoRepository.save(instalacao);
    }

    public void deletarInstalacao(Integer itemPedido){
        if(!instalacaoRepository.existsByItemPedido(itemPedido)){
            throw new EntityNotFoundException("Dados de instalação não encontrados!");
        }
        instalacaoRepository.deleteByItemPedido(itemPedido);
    }

    }



