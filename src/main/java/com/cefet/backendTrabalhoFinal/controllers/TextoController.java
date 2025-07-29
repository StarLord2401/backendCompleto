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

import com.cefet.backendTrabalhoFinal.entities.dtos.TextoDTO;
import com.cefet.backendTrabalhoFinal.entities.keys.TextoKey;
import com.cefet.backendTrabalhoFinal.services.TextoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cartas/textoEspaços")
@Tag(name = "Relação Carta-Espaço de Texto", description = "Gerenciamento de relação entre baralhos e espaços de texto")
public class TextoController {

	@Autowired
	private TextoService textoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar relação entre carta e espaço de texto por ID", description = "Retorna um relação entre carta e espaço de texto pelo seu ID")
	public ResponseEntity<TextoDTO> findById(
			@Parameter(description = "ID do usuário a ser buscado", example = "1") @PathVariable TextoKey id) {
		TextoDTO dto = textoService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos as relações entre carta e espaço de texto", description = "Retorna uma lista de todos as relações entre carta e espaço de texto")
	public ResponseEntity<List<TextoDTO>> findAll() {
		List<TextoDTO> dtos = textoService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar nova relação entre carta e espaço de texto", description = "Cria uma nova relação entre carta e espaço de texto com os dados fornecidos")
	public ResponseEntity<TextoDTO> create(
			@Parameter(description = "Dados da relação entre carta e espaço de texto a serem criados") @RequestBody TextoDTO dto) {
		TextoDTO novo = textoService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}
}
