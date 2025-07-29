package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Baralho;
import com.cefet.backendTrabalhoFinal.entities.BaralhoTemCarta;
import com.cefet.backendTrabalhoFinal.entities.Carta;
import com.cefet.backendTrabalhoFinal.entities.dtos.BaralhoTemCartaDTO;
import com.cefet.backendTrabalhoFinal.entities.keys.BaralhoTemCartaKey;
import com.cefet.backendTrabalhoFinal.repositories.BaralhoRepository;
import com.cefet.backendTrabalhoFinal.repositories.BaralhoTemCartaRepository;
import com.cefet.backendTrabalhoFinal.repositories.CartaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BaralhoTemCartaService {
    @Autowired
    private BaralhoTemCartaRepository baralhoTemCartaRepository;

    @SuppressWarnings("unused")
    @Autowired
    private BaralhoRepository baralhoRepository;

    @SuppressWarnings("unused")
    @Autowired
    private CartaRepository cartaRepository;

    public BaralhoTemCartaService() {
    }

    // Inserir
    public BaralhoTemCartaDTO insert(BaralhoTemCartaDTO dto) {
        Baralho baralho = baralhoRepository.findById(dto.getBaralhoId())
                .orElseThrow(() -> new EntityNotFoundException("Baralho não encontrado com ID: " + dto.getBaralhoId()));

        Carta carta = cartaRepository.findById(dto.getCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Carta não encontrada com ID: " + dto.getCartaId()));

        BaralhoTemCartaKey chave = new BaralhoTemCartaKey(dto.getBaralhoId(), dto.getCartaId());

        BaralhoTemCarta btc = new BaralhoTemCarta();
        btc.setId(chave);
        btc.setBaralho(baralho);
        btc.setCarta(carta);
        btc.setQuantidade(dto.getQuantidade());

        BaralhoTemCarta salvo = baralhoTemCartaRepository.save(btc);
        return new BaralhoTemCartaDTO(salvo);
    }

    // Listar
    public List<BaralhoTemCartaDTO> findAll() {
        List<BaralhoTemCarta> lista = baralhoTemCartaRepository.findAll();
        return lista.stream().map(BaralhoTemCartaDTO::new).toList();
    }

    // Buscar por ID
    public BaralhoTemCartaDTO findById(BaralhoTemCartaKey id) {
        BaralhoTemCarta objeto = baralhoTemCartaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Realação Baralho-Carta não encontrada com ID: " + id));
        return new BaralhoTemCartaDTO(objeto);
    }
}
