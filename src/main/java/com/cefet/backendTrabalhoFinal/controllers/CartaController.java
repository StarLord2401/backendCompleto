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

import com.cefet.backendTrabalhoFinal.entities.dtos.CartaDTO;
import com.cefet.backendTrabalhoFinal.services.CartaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cartas")
@Tag(name = "Cartas", description = "Gerenciamento de cartas")
public class CartaController {

	@Autowired
	private CartaService cartaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar carta por ID", description = "Retorna um carta pelo seu ID")
	public ResponseEntity<CartaDTO> findById(@PathVariable Long id) {
		CartaDTO dto = cartaService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos as cartas", description = "Retorna uma lista de todos as cartas")
	public ResponseEntity<List<CartaDTO>> findAll() {
		List<CartaDTO> dtos = cartaService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova carta", description = "Cria uma nova carta com os dados fornecidos")
	public ResponseEntity<CartaDTO> create(@RequestBody CartaDTO dto) {
		CartaDTO novo = cartaService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar carta", description = "Atualiza os dados de um carta existente")
	public ResponseEntity<CartaDTO> update(@PathVariable Long id, @RequestBody CartaDTO dto) {
		CartaDTO salvo = cartaService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover carta", description = "Remove um carta pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cartaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
