package com.cefet.backendTrabalhoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.backendTrabalhoFinal.entities.Carta;
import com.cefet.backendTrabalhoFinal.entities.Colecao;
import com.cefet.backendTrabalhoFinal.entities.TipoCarta;
import com.cefet.backendTrabalhoFinal.entities.dtos.CartaDTO;
import com.cefet.backendTrabalhoFinal.repositories.CartaRepository;
import com.cefet.backendTrabalhoFinal.repositories.ColecaoRepository;
import com.cefet.backendTrabalhoFinal.repositories.TipoCartaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartaService {
    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private ColecaoRepository colecaoRepository;

    @Autowired
    private TipoCartaRepository tipoCartaRepository;

    public CartaService() {
    }

    // Listar
    public List<CartaDTO> findAll() {
        List<Carta> lista = cartaRepository.findAll();
        return lista.stream().map(CartaDTO::new).toList();
    }

    // Buscar por ID
    public CartaDTO findById(Long id) {
        Carta objeto = cartaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carta não encontrada com ID: " + id));
        return new CartaDTO(objeto);
    }

    // Inserir
    public CartaDTO insert(CartaDTO dto) {
        Colecao colecao = colecaoRepository.findById(dto.getColecaoId())
                .orElseThrow(() -> new EntityNotFoundException("Coleção não encontrada com ID: " + dto.getColecaoId()));

        TipoCarta tipoCarta = tipoCartaRepository.findById(dto.getTipoCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de carta não encontrado com ID: " + dto.getTipoCartaId()));

        Carta carta = new Carta();
        carta.setNome(dto.getNome());
        carta.setDescricao(dto.getDescricao());
        carta.setQuantidade(dto.getQuantidade());
        carta.setColecao(colecao);
        carta.setTipoCarta(tipoCarta);

        Carta salvo = cartaRepository.save(carta);
        return new CartaDTO(salvo);
    }

    // Atualizar
    public CartaDTO update(Long id, CartaDTO dto) {
        Carta carta = cartaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carta não encontrado com ID: " + id));

        carta.setNome(dto.getNome());
        carta.setDescricao(dto.getDescricao());
        carta.setQuantidade(dto.getQuantidade());

        Colecao colecao = colecaoRepository.findById(dto.getColecaoId())
                .orElseThrow(() -> new EntityNotFoundException("Coleção não encontrado com ID: " + dto.getColecaoId()));
        carta.setColecao(colecao);

        TipoCarta tipoCarta = tipoCartaRepository.findById(dto.getTipoCartaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de carta não encontrado com ID: " + dto.getTipoCartaId()));
        carta.setTipoCarta(tipoCarta);


        Carta atualizado = cartaRepository.save(carta);
        return new CartaDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
        if (!cartaRepository.existsById(id)) {
            throw new EntityNotFoundException("Carta não encontrada com ID: " + id);
        }
        cartaRepository.deleteById(id);
    }
}
