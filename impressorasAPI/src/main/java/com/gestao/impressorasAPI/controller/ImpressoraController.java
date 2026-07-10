package com.gestao.impressorasAPI.controller;


import com.gestao.impressorasAPI.ImpressorasApiApplication;
import com.gestao.impressorasAPI.dto.ImpressoraDTO;
import com.gestao.impressorasAPI.entity.ImpressoraEntity;
import com.gestao.impressorasAPI.service.ImpressoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/impressora")
public class ImpressoraController {

    private final ImpressoraService service;

}
