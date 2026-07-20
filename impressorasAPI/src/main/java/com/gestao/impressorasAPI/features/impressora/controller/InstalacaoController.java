package com.gestao.impressorasAPI.features.impressora.controller;

import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.InstalacaoResponseDTO;
import com.gestao.impressorasAPI.features.impressora.service.InstalacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/instalacao")
public class InstalacaoController {

    private final InstalacaoService service;

    @PostMapping
    public ResponseEntity<InstalacaoResponseDTO> post(@Valid @RequestBody InstalacaoRequestDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<InstalacaoResponseDTO>> getAll() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/item-pedido/{itemPedido}")
    public ResponseEntity<InstalacaoResponseDTO> getByItemPedido(@PathVariable Integer itemPedido) {
        return ResponseEntity.ok(service.buscarPorItemPedido(itemPedido));
    }

    @PutMapping("/{itemPedido}")
    public ResponseEntity<InstalacaoResponseDTO> put(
            @PathVariable Integer itemPedido,
            @Valid @RequestBody InstalacaoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(itemPedido, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}