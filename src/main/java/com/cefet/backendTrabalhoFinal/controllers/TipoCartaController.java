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

import com.cefet.backendTrabalhoFinal.entities.dtos.TipoCartaDTO;
import com.cefet.backendTrabalhoFinal.services.TipoCartaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tiposCarta")
@Tag(name = "Tipos de Carta", description = "Gerenciamento de tipos de carta")
public class TipoCartaController {

	@Autowired
	private TipoCartaService tipoCartaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar tipo de carta por ID", description = "Retorna um tipo de carta pelo seu ID")
	public ResponseEntity<TipoCartaDTO> findById(@PathVariable Long id) {
		TipoCartaDTO dto = tipoCartaService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos os tipos de carta", description = "Retorna uma lista de todos os tipos de carta")
	public ResponseEntity<List<TipoCartaDTO>> findAll() {
		List<TipoCartaDTO> dtos = tipoCartaService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar novo tipo de carta", description = "Cria um novo tipo de carta com os dados fornecidos")
	public ResponseEntity<TipoCartaDTO> create(@RequestBody TipoCartaDTO dto) {
		TipoCartaDTO novo = tipoCartaService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar tipo de carta", description = "Atualiza os dados de um tipo de carta existente")
	public ResponseEntity<TipoCartaDTO> update(@PathVariable Long id, @RequestBody TipoCartaDTO dto) {
		TipoCartaDTO salvo = tipoCartaService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover tipo de carta", description = "Remove um tipo de carta pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tipoCartaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
