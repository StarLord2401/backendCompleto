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

import com.cefet.backendTrabalhoFinal.entities.dtos.ColecaoDTO;
import com.cefet.backendTrabalhoFinal.services.ColecaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/colecoes")
@Tag(name = "Coleções", description = "Gerenciamento de coleções")
public class ColecaoController {

	@Autowired
	private ColecaoService colecaoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar coleção por ID", description = "Retorna uma coleção pelo seu ID")
	public ResponseEntity<ColecaoDTO> findById(@PathVariable Long id) {
		ColecaoDTO dto = colecaoService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos as coleções", description = "Retorna uma lista de todos as coleções")
	public ResponseEntity<List<ColecaoDTO>> findAll() {
		List<ColecaoDTO> dtos = colecaoService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova coleção", description = "Cria uma nova coleção com os dados fornecidos")
	public ResponseEntity<ColecaoDTO> create(@RequestBody ColecaoDTO dto) {
		ColecaoDTO novo = colecaoService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar coleção", description = "Atualiza os dados de uma coleção existente")
	public ResponseEntity<ColecaoDTO> update(@PathVariable Long id, @RequestBody ColecaoDTO dto) {
		ColecaoDTO salvo = colecaoService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover coleção", description = "Remove uma coleção pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		colecaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
