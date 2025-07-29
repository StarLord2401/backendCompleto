package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Baralho;
import com.cefet.backendTrabalhoFinal.entities.Jogo;
import com.cefet.backendTrabalhoFinal.entities.Usuario;
import com.cefet.backendTrabalhoFinal.entities.dtos.BaralhoDTO;
import com.cefet.backendTrabalhoFinal.repositories.BaralhoRepository;
import com.cefet.backendTrabalhoFinal.repositories.JogoRepository;
import com.cefet.backendTrabalhoFinal.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BaralhoService {
    @Autowired
    private BaralhoRepository baralhoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public BaralhoService() {
    }

    // Listar
    public List<BaralhoDTO> findAll() {
        List<Baralho> lista = baralhoRepository.findAll();
        return lista.stream().map(BaralhoDTO::new).toList();
    }

    // Buscar por ID
    public BaralhoDTO findById(Long id) {
        Baralho objeto = baralhoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Baralho não encontrado com ID: " + id));
        return new BaralhoDTO(objeto);
    }

    // Inserir
    public BaralhoDTO insert(BaralhoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getUsuarioId()));

        Baralho baralho = new Baralho();
        baralho.setNome(dto.getNome());
        baralho.setDescricao(dto.getDescricao());
        baralho.setUsuario(usuario);
        baralho.setJogo(jogo);

        Baralho salvo = baralhoRepository.save(baralho);
        return new BaralhoDTO(salvo);
    }

    // Atualizar
    public BaralhoDTO update(Long id, BaralhoDTO dto) {
        Baralho baralho = baralhoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Baralho não encontrado com ID: " + id));

        baralho.setNome(dto.getNome());
        baralho.setDescricao(dto.getDescricao());

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));
        baralho.setJogo(jogo);

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));
        baralho.setUsuario(usuario);

        Baralho atualizado = baralhoRepository.save(baralho);
        return new BaralhoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!baralhoRepository.existsById(id)) {
            throw new EntityNotFoundException("Baralho não encontrado com ID: " + id);
        }
        baralhoRepository.deleteById(id);
    }
}
