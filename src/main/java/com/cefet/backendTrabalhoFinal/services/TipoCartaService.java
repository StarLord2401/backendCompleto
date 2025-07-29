package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Frame;
import com.cefet.backendTrabalhoFinal.entities.TipoCarta;
import com.cefet.backendTrabalhoFinal.entities.dtos.TipoCartaDTO;
import com.cefet.backendTrabalhoFinal.repositories.TipoCartaRepository;
import com.cefet.backendTrabalhoFinal.repositories.FrameRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoCartaService {
    @Autowired
    private TipoCartaRepository tipoCartaRepository;

    @Autowired
    private FrameRepository frameRepository;

    public TipoCartaService() {
    }

    // Listar
    public List<TipoCartaDTO> findAll() {
        List<TipoCarta> lista = tipoCartaRepository.findAll();
        return lista.stream().map(TipoCartaDTO::new).toList();
    }

    // Buscar por ID
    public TipoCartaDTO findById(Long id) {
        TipoCarta objeto = tipoCartaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new TipoCartaDTO(objeto);
    }

    // Inserir
    public TipoCartaDTO insert(TipoCartaDTO dto) {
        Frame frame = frameRepository.findById(dto.getFrameId())
                .orElseThrow(() -> new EntityNotFoundException("Frame não encontrado com ID: " + dto.getFrameId()));

        TipoCarta tipoCarta = new TipoCarta();
        tipoCarta.setNome(dto.getNome());
        tipoCarta.setQuantidadeMaxima(dto.getQuantidadeMaxima());
        tipoCarta.setFrame(frame);

        TipoCarta salvo = tipoCartaRepository.save(tipoCarta);
        return new TipoCartaDTO(salvo);
    }

    // Atualizar
    public TipoCartaDTO update(Long id, TipoCartaDTO dto) {
        TipoCarta tipoCarta = tipoCartaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de carta não encontrado com ID: " + id));

        Frame frame = frameRepository.findById(dto.getFrameId())
                .orElseThrow(() -> new EntityNotFoundException("Frame não encontrado com ID: " + dto.getFrameId()));

        tipoCarta.setNome(dto.getNome());
        tipoCarta.setQuantidadeMaxima(dto.getQuantidadeMaxima());
        tipoCarta.setFrame(frame);

        TipoCarta atualizado = tipoCartaRepository.save(tipoCarta);
        return new TipoCartaDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!tipoCartaRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        tipoCartaRepository.deleteById(id);
    }
}
