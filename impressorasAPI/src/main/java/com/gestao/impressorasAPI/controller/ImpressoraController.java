package com.gestao.impressorasAPI.controller;

import com.gestao.impressorasAPI.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.service.ImpressoraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/impressora")
public class ImpressoraController {

    private final ImpressoraService service;

    @PostMapping
    public ResponseEntity<ImpressoraEntity> postImpressora(@Valid @RequestBody ImpressoraDTO impressoraDTO){
         ImpressoraEntity impressora = service.cadastrarImpressora(impressoraDTO);
         return ResponseEntity.ok().body(impressora);
    }

    @GetMapping
    public ResponseEntity<List<ImpressoraEntity>> getAll(){
        List<ImpressoraEntity> listaImpressoras = service.listarImpressoras();
        return ResponseEntity.ok(listaImpressoras);
    }


    @DeleteMapping("/{numeroSerie}")
    public ResponseEntity<Void> deleteImpressora(@Valid @PathVariable String numeroSerie) {
        service.deletarImpressora(numeroSerie);
        return ResponseEntity.noContent().build();
    }

}
