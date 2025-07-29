package com.cefet.backendTrabalhoFinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.backendTrabalhoFinal.entities.dtos.FrameDTO;
import com.cefet.backendTrabalhoFinal.services.FrameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/frames")
@Tag(name = "Coleções", description = "Gerenciamento de frames")
public class FrameController {

	@Autowired
	private FrameService frameService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar frame por ID", description = "Retorna um frame pelo seu ID")
	public ResponseEntity<FrameDTO> findById(@PathVariable Long id) {
		FrameDTO dto = frameService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos as frames", description = "Retorna uma lista de todos as frames")
	public ResponseEntity<List<FrameDTO>> findAll() {
		List<FrameDTO> dtos = frameService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova frame", description = "Cria uma nova frame com os dados fornecidos")
	public ResponseEntity<FrameDTO> create(@RequestBody FrameDTO dto) {
		FrameDTO novo = frameService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar frame", description = "Atualiza os dados de um frame existente")
	public ResponseEntity<FrameDTO> update(@PathVariable Long id, @RequestBody FrameDTO dto) {
		FrameDTO salvo = frameService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover frame", description = "Remove um frame pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		frameService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
