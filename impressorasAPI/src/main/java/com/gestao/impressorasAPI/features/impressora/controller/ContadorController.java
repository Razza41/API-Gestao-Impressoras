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
    public ResponseEntity<ContadorResponseDTO> postContador(@Valid @RequestBody ContadorRequestDTO contadorRequest) {
        ContadorResponseDTO contador = service.cadastrarContador(contadorRequest);
        return ResponseEntity.ok(contador);
    }

    @GetMapping
    public ResponseEntity<List<ContadorResponseDTO>> getAllContadores() {
        List<ContadorResponseDTO> lista = service.listarTodosContadores();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/impressora/{impressoraId}")
    public ResponseEntity<ContadorResponseDTO> getContadorByImpressora(@PathVariable Long impressoraId) {
        ContadorResponseDTO contador = service.buscarContadorPorImpressora(impressoraId);
        return ResponseEntity.ok(contador);
    }
}