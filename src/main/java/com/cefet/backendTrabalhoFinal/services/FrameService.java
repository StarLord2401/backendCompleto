package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Frame;
import com.cefet.backendTrabalhoFinal.entities.Jogo;
import com.cefet.backendTrabalhoFinal.entities.dtos.FrameDTO;
import com.cefet.backendTrabalhoFinal.repositories.FrameRepository;
import com.cefet.backendTrabalhoFinal.repositories.JogoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FrameService {
    @Autowired
    private FrameRepository frameRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public FrameService() {
    }

    // Listar
    public List<FrameDTO> findAll() {
        List<Frame> lista = frameRepository.findAll();
        return lista.stream().map(FrameDTO::new).toList();
    }

    // Buscar por ID
    public FrameDTO findById(Long id) {
        Frame objeto = frameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Frame não encontrado com ID: " + id));
        return new FrameDTO(objeto);
    }

    // Inserir
    public FrameDTO insert(FrameDTO dto) {
        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));

        Frame frame = new Frame();
        frame.setPath(dto.getPath());
        frame.setJogo(jogo);

        Frame salvo = frameRepository.save(frame);
        return new FrameDTO(salvo);
    }

    // Atualizar
    public FrameDTO update(Long id, FrameDTO dto) {
        Frame frame = frameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Frame não encontrado com ID: " + id));

        frame.setPath(dto.getPath());

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));
        frame.setJogo(jogo);

        Frame atualizado = frameRepository.save(frame);
        return new FrameDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!frameRepository.existsById(id)) {
            throw new EntityNotFoundException("Frame não encontrado com ID: " + id);
        }
        frameRepository.deleteById(id);
    }
}
