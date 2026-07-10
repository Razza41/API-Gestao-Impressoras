package com.gestao.impressorasAPI.controller;

import com.gestao.impressorasAPI.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.service.InstalacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/instalacao")
public class InstalacaoController {

    private final InstalacaoService service;

    @PostMapping
    public ResponseEntity<InstalacaoEntity> postInstalacao(@Valid @RequestBody InstalacaoDTO instalacaoDTO){
        InstalacaoEntity instalacao = service.cadastrarInstalacao(instalacaoDTO);
        return ResponseEntity.ok().body(instalacao);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteInstalacao(@RequestBody Integer itemPedido){
        service.deletarInstalacao(itemPedido);
        return ResponseEntity.noContent().build();
    }
}
