package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.TextoEspaco;
import com.cefet.backendTrabalhoFinal.entities.TipoCarta;
import com.cefet.backendTrabalhoFinal.entities.dtos.TextoEspacoDTO;
import com.cefet.backendTrabalhoFinal.repositories.TextoEspacoRepository;
import com.cefet.backendTrabalhoFinal.repositories.TipoCartaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TextoEspacoService {
    @Autowired
    private TextoEspacoRepository textoEspacoRepository;

    @Autowired
    private TipoCartaRepository tipoCartaRepository;

    public TextoEspacoService() {
    }

    // Listar
    public List<TextoEspacoDTO> findAll() {
        List<TextoEspaco> lista = textoEspacoRepository.findAll();
        return lista.stream().map(TextoEspacoDTO::new).toList();
    }

    // Buscar por ID
    public TextoEspacoDTO findById(Long id) {
        TextoEspaco objeto = textoEspacoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Espaço de texto não encontrado com ID: " + id));
        return new TextoEspacoDTO(objeto);
    }

    // Inserir
    public TextoEspacoDTO insert(TextoEspacoDTO dto) {
        TipoCarta tipoCarta = tipoCartaRepository.findById(dto.getTipoCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de carta não encontrado com ID: " + dto.getTipoCartaId()));

        TextoEspaco textoEspaco = new TextoEspaco();
        textoEspaco.setX(dto.getX());
        textoEspaco.setY(dto.getY());
        textoEspaco.setTipoCarta(tipoCarta);

        TextoEspaco salvo = textoEspacoRepository.save(textoEspaco);
        return new TextoEspacoDTO(salvo);
    }

    // Atualizar
    public TextoEspacoDTO update(Long id, TextoEspacoDTO dto) {
        TextoEspaco textoEspaco = textoEspacoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Espaço de texto não encontrado com ID: " + id));

        textoEspaco.setX(dto.getX());
        textoEspaco.setY(dto.getY());

        TipoCarta tipoCarta = tipoCartaRepository.findById(dto.getTipoCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de carta não encontrado com ID: " + dto.getTipoCartaId()));
        textoEspaco.setTipoCarta(tipoCarta);

        TextoEspaco atualizado = textoEspacoRepository.save(textoEspaco);
        return new TextoEspacoDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!textoEspacoRepository.existsById(id)) {
            throw new EntityNotFoundException("Espaço de texto não encontrado com ID: " + id);
        }
        textoEspacoRepository.deleteById(id);
    }
}
