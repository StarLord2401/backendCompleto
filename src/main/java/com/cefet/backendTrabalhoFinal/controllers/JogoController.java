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

import com.cefet.backendTrabalhoFinal.entities.dtos.JogoDTO;
import com.cefet.backendTrabalhoFinal.services.JogoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/jogos")
@Tag(name = "Jogos", description = "Gerenciamento de jogos")
public class JogoController {

	@Autowired
	private JogoService jogoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar jogo por ID", description = "Retorna um jogo pelo seu ID")
	public ResponseEntity<JogoDTO> findById(@PathVariable Long id) {
		JogoDTO dto = jogoService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos os jogos", description = "Retorna uma lista de todos os jogos")
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<JogoDTO> dtos = jogoService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar novo jogo", description = "Cria um novo jogo com os dados fornecidos")
	public ResponseEntity<JogoDTO> create(@RequestBody JogoDTO dto) {
		JogoDTO novo = jogoService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar jogo", description = "Atualiza os dados de um jogo existente")
	public ResponseEntity<JogoDTO> update(@PathVariable Long id, @RequestBody JogoDTO dto) {
		JogoDTO salvo = jogoService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover jogo", description = "Remove um jogo pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		jogoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
