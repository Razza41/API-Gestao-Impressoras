package com.gestao.impressorasAPI.features.impressora.controller;

import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ImpressoraResponseDTO;
import com.gestao.impressorasAPI.features.impressora.service.ImpressoraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/impressora")
public class ImpressoraController {

    private final ImpressoraService service;

    @GetMapping
    public ResponseEntity<List<ImpressoraResponseDTO>> getAll() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImpressoraResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @GetMapping("/numero-serie/{numeroSerie}")
    public ResponseEntity<ImpressoraResponseDTO> getByNumeroSerie(@PathVariable String numeroSerie) {
        return ResponseEntity.ok(service.buscarPorNumeroSerie(numeroSerie));
    }

    @PostMapping
    public ResponseEntity<ImpressoraResponseDTO> post(@Valid @RequestBody ImpressoraRequestDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImpressoraResponseDTO> put(
            @PathVariable Long id,
            @Valid @RequestBody ImpressoraRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}