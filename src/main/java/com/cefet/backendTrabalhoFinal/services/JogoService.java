package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Jogo;
import com.cefet.backendTrabalhoFinal.entities.Usuario;
import com.cefet.backendTrabalhoFinal.entities.dtos.JogoDTO;
import com.cefet.backendTrabalhoFinal.repositories.JogoRepository;
import com.cefet.backendTrabalhoFinal.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public JogoService() {
    }

    // Listar
    public List<JogoDTO> findAll() {
        List<Jogo> lista = jogoRepository.findAll();
        return lista.stream().map(JogoDTO::new).toList();
    }

    // Buscar por ID
    public JogoDTO findById(Long id) {
        Jogo objeto = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + id));
        return new JogoDTO(objeto);
    }

    // Inserir
    public JogoDTO insert(JogoDTO dto) {
        // Busca o criador
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário (criador) não encontrado"));

        // Cria o jogo
        Jogo jogo = new Jogo();
        jogo.setNome(dto.getNome());
        jogo.setDescricao(dto.getDescricao());
        jogo.setTamanhoBaralho(dto.getTamanhoBaralho());
        jogo.setUsuario(usuario);

        // Salva o jogo no repositório
        Jogo salvo = jogoRepository.save(jogo);
        return new JogoDTO(salvo);
    }

    // Atualizar
    public JogoDTO update(Long id, JogoDTO dto) {
        Jogo jogo = jogoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + id));

        jogo.setNome(dto.getNome());
        jogo.setDescricao(dto.getDescricao());
        jogo.setTamanhoBaralho(dto.getTamanhoBaralho());

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário inválido"));
        jogo.setUsuario(usuario);

        Jogo atualizado = jogoRepository.save(jogo);
        return new JogoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!jogoRepository.existsById(id)) {
            throw new EntityNotFoundException("Jogo não encontrado com ID: " + id);
        }
        jogoRepository.deleteById(id);
    }
}
