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

import com.cefet.backendTrabalhoFinal.entities.dtos.PartidaDTO;
import com.cefet.backendTrabalhoFinal.services.PartidaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/partidas")
@Tag(name = "Partidas", description = "Gerenciamento de partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar partida por ID", description = "Retorna um partida pelo seu ID")
	public ResponseEntity<PartidaDTO> findById(@PathVariable Long id) {
		PartidaDTO dto = partidaService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todas as partidas", description = "Retorna uma lista de todas as partidas")
	public ResponseEntity<List<PartidaDTO>> findAll() {
		List<PartidaDTO> dtos = partidaService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova partida", description = "Cria uma nova partida com os dados fornecidos")
	public ResponseEntity<PartidaDTO> create(@RequestBody PartidaDTO dto) {
		PartidaDTO novo = partidaService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PartidaDTO> update(@PathVariable Long id, @RequestBody PartidaDTO dto) {
		PartidaDTO salvo = partidaService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		partidaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
