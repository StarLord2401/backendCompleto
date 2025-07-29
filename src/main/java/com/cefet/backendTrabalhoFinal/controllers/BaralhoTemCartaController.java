package com.cefet.backendTrabalhoFinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.backendTrabalhoFinal.entities.dtos.BaralhoTemCartaDTO;
import com.cefet.backendTrabalhoFinal.entities.keys.BaralhoTemCartaKey;
import com.cefet.backendTrabalhoFinal.services.BaralhoTemCartaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/baralhos/cartas")
@Tag(name = "Relação Baralho-Carta", description = "Gerenciamento de relação entre baralhos e cartas")
public class BaralhoTemCartaController {

	@Autowired
	private BaralhoTemCartaService btsService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar relação entre baralho e carta por ID", description = "Retorna um relação entre baralho e carta pelo seu ID")
	public ResponseEntity<BaralhoTemCartaDTO> findById(@PathVariable BaralhoTemCartaKey id) {
		BaralhoTemCartaDTO dto = btsService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos as relações entre baralho e carta", description = "Retorna uma lista de todos as relações entre baralho e carta")
	public ResponseEntity<List<BaralhoTemCartaDTO>> findAll() {
		List<BaralhoTemCartaDTO> dtos = btsService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova relação entre baralho e carta", description = "Cria uma nova relação entre baralho e carta com os dados fornecidos")
	public ResponseEntity<BaralhoTemCartaDTO> create(@RequestBody BaralhoTemCartaDTO dto) {
		BaralhoTemCartaDTO novo = btsService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}
}
