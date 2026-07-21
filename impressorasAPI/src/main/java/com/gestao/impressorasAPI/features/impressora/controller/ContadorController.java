package com.gestao.impressorasAPI.features.impressora.controller;

import com.gestao.impressorasAPI.features.impressora.dto.ContadorRequestDTO;
import com.gestao.impressorasAPI.features.impressora.dto.ContadorResponseDTO;
import com.gestao.impressorasAPI.features.impressora.service.ContadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/contador")
public class ContadorController {

    private final ContadorService service;


    //Cadastra uma nova leitura a impressora
    @PostMapping
    public ResponseEntity<ContadorResponseDTO> post(@Valid @RequestBody ContadorRequestDTO dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    //busca contador por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContadorResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    //Lista contadores por Impressora com paginação
    @GetMapping("/impressora/{impressoraId}")
    public ResponseEntity<Page<ContadorResponseDTO>> getByImpressora(
            @PathVariable Long impressoraId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("dataLeitura").descending());
        return ResponseEntity.ok(service.listarPorImpressora(impressoraId, pageable));
    }


    //busca o ultimo contador da impressora
    @GetMapping("/ultimo-contador/{impressoraId}")
    public ResponseEntity<ContadorResponseDTO> getUltimo(@PathVariable Long impressoraId) {
        return ResponseEntity.ok(service.buscarUltimoPorImpressora(impressoraId));
    }

//busca histórico completo de uma impressora com paginação
    @GetMapping("/impressora/{impressoraId}/historico")
    public ResponseEntity<Page<ContadorResponseDTO>> getHistorico(
            @PathVariable Long impressoraId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("dataLeitura").descending());
        return ResponseEntity.ok(service.buscarHistorico(impressoraId, pageable));
    }

//verifica se a impressora tem contador
    @GetMapping("/impressora/{impressoraId}/existe")
    public ResponseEntity<Boolean> existeContador(@PathVariable Long impressoraId) {
        return ResponseEntity.ok(service.existeContador(impressoraId));
    }

    //deletar contador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //deletar todos os contadores de uma impressora
    @DeleteMapping("/impressora/{impressoraId}")
    public ResponseEntity<Void> deleteAllByImpressora(@PathVariable Long impressoraId) {
        service.deletarTodosPorImpressora(impressoraId);
        return ResponseEntity.noContent().build();
    }
}