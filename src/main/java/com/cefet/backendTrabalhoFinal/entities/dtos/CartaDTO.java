package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Carta;

import io.swagger.v3.oas.annotations.media.Schema;

public class CartaDTO {
    @Schema(description = "ID da carta", example = "1")
    private Long id;

    @Schema(description = "ID do tipo de carta", example = "2")
    private Long tipoCartaId;

    @Schema(description = "ID da coleção da carta", example = "3")
    private Long colecaoId;

    @Schema(description = "Nome da carta", example = "Dragão de Fogo")
    private String nome;

    @Schema(description = "Descrição da carta", example = "Um dragão poderoso que lança chamas.")
    private String descricao;

    @Schema(description = "Quantidade da carta", example = "10")
    private int quantidade;

    public CartaDTO() {
    }

    public CartaDTO(Carta carta) {
        this.id = carta.getId();
        this.tipoCartaId = carta.getTipoCarta() != null ? carta.getTipoCarta().getId() : null;
        this.colecaoId = carta.getColecao() != null ? carta.getColecao().getId() : null;
        this.nome = carta.getNome();
        this.descricao = carta.getDescricao();
        this.quantidade = carta.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public Long getTipoCartaId() {
        return tipoCartaId;
    }

    public Long getColecaoId() {
        return colecaoId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
