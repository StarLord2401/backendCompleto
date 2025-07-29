package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Usuario;
import com.cefet.backendTrabalhoFinal.entities.dtos.UsuarioDTO;
import com.cefet.backendTrabalhoFinal.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService() {
    }

    // Listar
    public List<UsuarioDTO> findAll() {
        List<Usuario> lista = usuarioRepository.findAll();
        return lista.stream().map(UsuarioDTO::new).toList();
    }

    // Buscar por ID
    public UsuarioDTO findById(Long id) {
        Usuario objeto = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new UsuarioDTO(objeto);
    }

    // // Gerador de senha aleatória segura
    // private String gerarSenha(int tamanho) {
    //     String alfabeto = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
    //     SecureRandom random = new SecureRandom();
    //     StringBuilder senha = new StringBuilder();
    //     for (int i = 0; i < tamanho; i++) {
    //         int index = random.nextInt(alfabeto.length());
    //         senha.append(alfabeto.charAt(index));
    //     }
    //     return senha.toString();
    // }

    // Inserir
    public UsuarioDTO insert(UsuarioDTO dto) {
        if (usuarioRepository.existsByLogin(dto.getLogin())) {
            throw new IllegalArgumentException("Login já existe.");
        }

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setNome(dto.getNome());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setAccessLevel(dto.getAccessLevel());

        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(salvo);
    }

    // // Inserir Usuário
    // public UsuarioDTO insert(UsuarioDTO usuarioDTO) {
    // // Verifica se já existe login
    // if (usuarioRepository.existsByLogin(usuarioDTO.getLogin())) {
    // throw new IllegalArgumentException("Login já está em uso.");
    // }

    // Usuario usuario = new Usuario();
    // usuario.setNome(usuarioDTO.getNome());
    // usuario.setLogin(usuarioDTO.getLogin());
    // usuario.setSenha(gerarSenha(6));
    // Usuario usuarioSalvo = usuarioRepository.save(usuario);
    // return new UsuarioDTO(usuarioSalvo);
    // }

    // Atualizar
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        if (dto.getLogin() != null && !dto.getLogin().equals(usuario.getLogin())) {
            if (usuarioRepository.existsByLogin(dto.getLogin())) {
                throw new IllegalArgumentException("Login já está em uso.");
            }
            usuario.setLogin(dto.getLogin());
        }
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());

        Usuario atualizado = usuarioRepository.save(usuario);
        return new UsuarioDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    // Verifica login
    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }
}
