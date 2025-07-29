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

import com.cefet.backendTrabalhoFinal.entities.dtos.TextoEspacoDTO;
import com.cefet.backendTrabalhoFinal.services.TextoEspacoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/textoEspacos")
@Tag(name = "Espaços de texto", description = "Gerenciamento de espaços de texto")
public class TextoEspacoController {

	@Autowired
	private TextoEspacoService textoEspacoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar espaço de texto por ID", description = "Retorna um espaço de texto pelo seu ID")
	public ResponseEntity<TextoEspacoDTO> findById(@PathVariable Long id) {
		TextoEspacoDTO dto = textoEspacoService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos os espaços de texto", description = "Retorna uma lista de todos os espaços de texto")
	public ResponseEntity<List<TextoEspacoDTO>> findAll() {
		List<TextoEspacoDTO> dtos = textoEspacoService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar novo espaço de texto", description = "Cria uma novo espaço de texto com os dados fornecidos")
	public ResponseEntity<TextoEspacoDTO> create(@RequestBody TextoEspacoDTO dto) {
		TextoEspacoDTO novo = textoEspacoService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar espaço de texto", description = "Atualiza os dados de um espaço de texto existente")
	public ResponseEntity<TextoEspacoDTO> update(@PathVariable Long id, @RequestBody TextoEspacoDTO dto) {
		TextoEspacoDTO salvo = textoEspacoService.update(id, dto);
		return ResponseEntity.ok(salvo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Remover espaço de texto", description = "Remove um espaço de texto pelo seu ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		textoEspacoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
