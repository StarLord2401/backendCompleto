package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.TextoEspaco;
import com.cefet.backendTrabalhoFinal.entities.Texto;
import com.cefet.backendTrabalhoFinal.entities.Carta;
import com.cefet.backendTrabalhoFinal.entities.dtos.TextoDTO;
import com.cefet.backendTrabalhoFinal.entities.keys.TextoKey;
import com.cefet.backendTrabalhoFinal.repositories.TextoRepository;
import com.cefet.backendTrabalhoFinal.repositories.TextoEspacoRepository;
import com.cefet.backendTrabalhoFinal.repositories.CartaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TextoService {
    @Autowired
    private TextoRepository textoRepository;

    @Autowired
    private TextoEspacoRepository textoEspacoRepository;

    @Autowired 
    private CartaRepository cartaRepository;


    public TextoService() {
    }

    
    // Inserir
    public TextoDTO insert(TextoDTO dto) {
        TextoEspaco textoEspaco = textoEspacoRepository.findById(dto.getTextoEspacoId())
                .orElseThrow(() -> new EntityNotFoundException("TextoEspaco não encontrado com ID: " + dto.getTextoEspacoId()));

        Carta carta = cartaRepository.findById(dto.getCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Carta não encontrada com ID: " + dto.getCartaId()));

        TextoKey chave = new TextoKey(dto.getTextoEspacoId(), dto.getCartaId());

        Texto texto = new Texto();
        texto.setId(chave);
        texto.setTextoEspaco(textoEspaco);
        texto.setCarta(carta);
        texto.setTexto(dto.getTexto());


        Texto salvo = textoRepository.save(texto);
        return new TextoDTO(salvo);
    }


    // Listar
    public List<TextoDTO> findAll() {
        List<Texto> lista = textoRepository.findAll();
        return lista.stream().map(TextoDTO::new).toList();
    }

    // Buscar por ID
    public TextoDTO findById(TextoKey id) {
        Texto objeto = textoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Relação Espaço de Texto-Carta não encontrada com ID: " + id));
        return new TextoDTO(objeto);
    }
}
