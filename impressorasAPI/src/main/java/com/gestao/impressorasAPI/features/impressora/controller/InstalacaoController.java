package com.gestao.impressorasAPI.features.impressora.controller;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoDTO;
import com.gestao.impressorasAPI.features.impressora.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.features.impressora.entity.InstalacaoEntity;
import com.gestao.impressorasAPI.features.impressora.service.InstalacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstalacao(@Valid @PathVariable Long id){
       service.deletarInstalacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<InstalacaoEntity>> getInstalacao(){
        List<InstalacaoEntity> listaInstalacao = service.listarInstalacoes();
        return ResponseEntity.ok(listaInstalacao);
    }
}
