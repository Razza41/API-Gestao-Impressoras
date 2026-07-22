package com.gestao.impressorasAPI.features.impressora.service;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoResponseDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.features.impressora.mapper.InstalacaoMapper;
import com.gestao.impressorasAPI.features.impressora.repository.ContadorRepository;
import com.gestao.impressorasAPI.features.impressora.repository.InstalacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstalacaoService {

    private final ContadorRepository contadorRepository;
    private final InstalacaoRepository instalacaoRepository;
    private final ImpressoraService impressoraService;
    private final InstalacaoMapper mapper;

    @Transactional
    public InstalacaoResponseDTO cadastrar(InstalacaoRequestDTO dto) {
        // busca a impressora pelo id
        ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.idImpressora());

        // converte dto para entidade e associa a impressora
        InstalacaoEntity entity = mapper.toEntity(dto);
        entity.setImpressora(impressora);

        // salva e retorna com o ultimo contador
        InstalacaoEntity saved = instalacaoRepository.save(entity);
        return toResponseDTOCompleto(saved);
    }

    public List<InstalacaoResponseDTO> listarTodas() {
        // lista todas as instalacoes com o ultimo contador de cada impressora
        return instalacaoRepository.findAll().stream()
                .map(this::toResponseDTOCompleto)
                .toList();
    }

    public InstalacaoResponseDTO buscarPorItemPedido(Integer itemPedido) {
        // busca uma instalacao pelo item do pedido
        InstalacaoEntity entity = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(() -> new EntityNotFoundException("Instalacao nao encontrada"));
        return toResponseDTOCompleto(entity);
    }

    @Transactional
    public InstalacaoResponseDTO atualizar(Integer itemPedido, InstalacaoRequestDTO dto) {
        // busca a instalacao existente
        InstalacaoEntity entity = instalacaoRepository.findByItemPedido(itemPedido)
                .orElseThrow(() -> new EntityNotFoundException("Instalacao nao encontrada"));

        // atualiza os campos
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

        // atualiza a impressora se foi enviada
        if (dto.idImpressora() != null) {
            ImpressoraEntity impressora = impressoraService.buscarEntityPorId(dto.idImpressora());
            entity.setImpressora(impressora);
        }

        // salva e retorna com o ultimo contador
        InstalacaoEntity updated = instalacaoRepository.save(entity);
        return toResponseDTOCompleto(updated);
    }

    @Transactional
    public void deletar(Long id) {
        // verifica se existe e deleta
        if (!instalacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Instalacao nao encontrada");
        }
        instalacaoRepository.deleteById(id);
    }

    // metodo privado que monta o dto de resposta com o ultimo contador da impressora
    private InstalacaoResponseDTO toResponseDTOCompleto(InstalacaoEntity entity) {
        // converte a instalacao para dto usando o mapper
        InstalacaoResponseDTO dto = mapper.toResponseDTO(entity);

        // busca o ultimo contador da impressora
        ContadorResponseDTO ultimoContador = contadorRepository
                .findTopByImpressoraIdOrderByDataLeituraDesc(entity.getImpressora().getId())
                .map(contador -> new ContadorResponseDTO(
                        contador.getId(),
                        contador.getContadorPB(),
                        contador.getContadorColor(),
                        contador.getDataLeitura()
                ))
                .orElse(null);

        // monta o dto da impressora com o ultimo contador
        ImpressoraResponseDTO impressoraDTO = new ImpressoraResponseDTO(
                entity.getImpressora().getId(),
                entity.getImpressora().getMarcaModelo(),
                entity.getImpressora().getNumeroSerie(),
                ultimoContador
        );

        // retorna a instalacao com a impressora atualizada
        return new InstalacaoResponseDTO(
                dto.id(),
                dto.itemPedido(),
                dto.localInstalacao(),
                dto.rua(),
                dto.numero(),
                dto.bairro(),
                dto.transformador(),
                dto.responsavelInstalacao(),
                dto.ip(),
                dto.dataInstalacao(),
                dto.contadorInstalacao(),
                dto.dataRetirada(),
                dto.contadorRetirada(),
                impressoraDTO
        );
    }
}