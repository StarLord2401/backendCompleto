package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Partida;
import com.cefet.backendTrabalhoFinal.entities.Jogo;
import com.cefet.backendTrabalhoFinal.entities.Usuario;
import com.cefet.backendTrabalhoFinal.entities.dtos.PartidaDTO;
import com.cefet.backendTrabalhoFinal.repositories.JogoRepository;
import com.cefet.backendTrabalhoFinal.repositories.PartidaRepository;
import com.cefet.backendTrabalhoFinal.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartidaService {
    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public PartidaService() {
    }

    // Listar
    public List<PartidaDTO> findAll() {
        List<Partida> lista = partidaRepository.findAll();
        return lista.stream().map(PartidaDTO::new).toList();
    }

    // Buscar por ID
    public PartidaDTO findById(Long id) {
        Partida objeto = partidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Partida não encontrado com ID: " + id));
        return new PartidaDTO(objeto);
    }

    // Inserir
    public PartidaDTO insert(PartidaDTO dto) {
        Partida partida = new Partida();

        if (dto.getIdUsuarios() != null && !dto.getIdUsuarios().isEmpty()) {
            List<Usuario> usuarios = usuarioRepository.findAllById(dto.getIdUsuarios());
            if (usuarios.size() != dto.getIdUsuarios().size()) {
                throw new EntityNotFoundException("Algum usuário não foi encontrado");
            }
            partida.setUsuarios(usuarios);
        }

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));

        partida.setJogo(jogo);

        Partida salvo = partidaRepository.save(partida);
        return new PartidaDTO(salvo);
    }

    // Atualizar
    public PartidaDTO update(Long id, PartidaDTO dto) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Partida não encontrada com ID: " + id));

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));
        partida.setJogo(jogo);

        if (dto.getIdUsuarios() != null) {
            List<Usuario> usuarios = usuarioRepository.findAllById(dto.getIdUsuarios());
            if (usuarios.size() != dto.getIdUsuarios().size()) {
                throw new EntityNotFoundException("Algum usuário não foi encontrado");
            }
            partida.setUsuarios(usuarios);
        }

        Partida atualizado = partidaRepository.save(partida);
        return new PartidaDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!partidaRepository.existsById(id)) {
            throw new EntityNotFoundException("Partida não encontrado com ID: " + id);
        }
        partidaRepository.deleteById(id);
    }
}
