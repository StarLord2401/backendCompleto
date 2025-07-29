package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Colecao;
import com.cefet.backendTrabalhoFinal.entities.Jogo;
import com.cefet.backendTrabalhoFinal.entities.dtos.ColecaoDTO;
import com.cefet.backendTrabalhoFinal.repositories.ColecaoRepository;
import com.cefet.backendTrabalhoFinal.repositories.JogoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColecaoService {
    @Autowired
    private ColecaoRepository colecaoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public ColecaoService() {
    }

    // Listar
    public List<ColecaoDTO> findAll() {
        List<Colecao> lista = colecaoRepository.findAll();
        return lista.stream().map(ColecaoDTO::new).toList();
    }

    // Buscar por ID
    public ColecaoDTO findById(Long id) {
        Colecao objeto = colecaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coleção não encontrado com ID: " + id));
        return new ColecaoDTO(objeto);
    }

    // Inserir
    public ColecaoDTO insert(ColecaoDTO dto) {
        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));

        Colecao colecao = new Colecao();
        colecao.setNome(dto.getNome());
        colecao.setDescricao(dto.getDescricao());
        colecao.setJogo(jogo);

        Colecao salvo = colecaoRepository.save(colecao);
        return new ColecaoDTO(salvo);
    }

    // Atualizar
    public ColecaoDTO update(Long id, ColecaoDTO dto) {
        Colecao colecao = colecaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coleção não encontrado com ID: " + id));

        colecao.setNome(dto.getNome());
        colecao.setDescricao(dto.getDescricao());

        Jogo jogo = jogoRepository.findById(dto.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado com ID: " + dto.getJogoId()));
        colecao.setJogo(jogo);

        Colecao atualizado = colecaoRepository.save(colecao);
        return new ColecaoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!colecaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Coleção não encontrado com ID: " + id);
        }
        colecaoRepository.deleteById(id);
    }
}
