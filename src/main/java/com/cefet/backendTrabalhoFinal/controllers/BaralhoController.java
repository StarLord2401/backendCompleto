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

import com.cefet.backendTrabalhoFinal.entities.dtos.BaralhoDTO;
import com.cefet.backendTrabalhoFinal.services.BaralhoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/baralhos")
@Tag(name = "Baralhos", description = "Gerenciamento de baralhos")
public class BaralhoController {

	@Autowired
	private BaralhoService baralhoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar baralho por ID", description = "Retorna um baralho pelo seu ID")
	public ResponseEntity<BaralhoDTO> findById(@PathVariable Long id) {
		BaralhoDTO dto = baralhoService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos os baralhos", description = "Retorna uma lista de todos os baralhos")
	public ResponseEntity<List<BaralhoDTO>> findAll() {
		List<BaralhoDTO> dtos = baralhoService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar novo baralho", description = "Cria um novo baralho com os dados fornecidos")
	public ResponseEntity<BaralhoDTO> create(@RequestBody BaralhoDTO dto) {
		BaralhoDTO novo = baralhoService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BaralhoDTO> update(@PathVariable Long id, @RequestBody
	BaralhoDTO dto) {
	BaralhoDTO salvo = baralhoService.update(id, dto);
	return ResponseEntity.ok(salvo);
	}
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	baralhoService.delete(id);
	return ResponseEntity.noContent().build();
	}
}
