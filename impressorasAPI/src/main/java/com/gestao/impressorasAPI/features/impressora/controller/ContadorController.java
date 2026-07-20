package com.gestao.impressorasAPI.features.impressora.controller;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.service.ContadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/contador")
public class ContadorController {

    private final ContadorService service;

    @PostMapping
    public ResponseEntity<ContadorResponseDTO> post(@Valid @RequestBody ContadorRequestDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContadorResponseDTO>> getAll() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/impressora/{impressoraId}")
    public ResponseEntity<ContadorResponseDTO> getByImpressora(@PathVariable Long impressoraId) {
        return ResponseEntity.ok(service.buscarPorImpressoraId(impressoraId));
    }
}