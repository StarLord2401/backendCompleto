package com.cefet.backendTrabalhoFinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.backendTrabalhoFinal.entities.dtos.UsuarioDTO;
import com.cefet.backendTrabalhoFinal.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário pelo seu ID")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		UsuarioDTO dto = usuarioService.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Operation(summary = "Listar todos os usuários", description = "Retorna uma lista de todos os usuários")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> dtos = usuarioService.findAll();
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	@Operation(summary = "Criar novo usuário", description = "Cria um novo usuário com os dados fornecidos")
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) {
		UsuarioDTO novo = usuarioService.insert(dto);
		return ResponseEntity.status(201).body(novo);
	}

	/*
	 * @PutMapping("/{id}")
	 * public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody
	 * UsuarioDTO dto) {
	 * UsuarioDTO salvo = usuarioService.update(id, dto);
	 * return ResponseEntity.ok(salvo);
	 * }
	 * 
	 * @DeleteMapping("/{id}")
	 * public ResponseEntity<Void> delete(@PathVariable Long id) {
	 * usuarioService.delete(id);
	 * return ResponseEntity.noContent().build();
	 * }
	 */

	@GetMapping("/existe")
	@Operation(summary = "Verificar se o login existe", description = "Retorna verdadeiro se o login já existir, falso caso contrário")
	public ResponseEntity<Boolean> existsByLogin(@RequestParam String login) {
		boolean existe = usuarioService.existsByLogin(login);
		return ResponseEntity.ok(existe);
	}
}
