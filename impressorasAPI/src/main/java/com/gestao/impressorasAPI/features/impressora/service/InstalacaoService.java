package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.InstalacaoMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ImpressoraRepository;
import com.gestao.impressorasAPI.features.impressora.repository.InstalacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalacaoService {

    private final ImpressoraRepository impressoraRepository;
    private final InstalacaoRepository instalacaoRepository;
    private final InstalacaoMapper mapper;

    public InstalacaoEntity cadastrarInstalacao(InstalacaoDTO instalacaoDTO){
        //busca a impressora no banco de dados

        //cria objeto instalaÃ§Ã£o com base nos dados passados no JSON
        InstalacaoEntity instalacao = mapper.toEntity(instalacaoDTO);
        //instalacao.setImpressora(impressora);

        //salva no banco de dados
        return instalacaoRepository.save(instalacao);
    }

    public InstalacaoEntity atualizarInstalacao(Integer itemPedido, InstalacaoDTO instalacaoDTO){
        //valida se existe no banco de dados
        InstalacaoEntity instalacao = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(()-> new EntityNotFoundException("Informe um nÃºmero de item de pedido vÃ¡lido por favor!"));

        instalacao.setLocalInstalacao(instalacaoDTO.localInstalacao());
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

    public void deletarInstalacao(Long id){
        if(!instalacaoRepository.existsById(id)){
            throw new EntityNotFoundException("Dados de instalação não encontrados!");
        }
        instalacaoRepository.deleteById(id);
    }

    public List<InstalacaoEntity> listarImpressoras(){
        return instalacaoRepository.findAll();
    }
    }



