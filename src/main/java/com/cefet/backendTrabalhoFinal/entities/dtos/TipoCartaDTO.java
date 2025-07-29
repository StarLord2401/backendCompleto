package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.TipoCarta;

import io.swagger.v3.oas.annotations.media.Schema;

public class TipoCartaDTO {
    @Schema(description = "ID do tipo de carta", example = "1")
    private Long id;

    @Schema(description = "Nome do tipo de carta", example = "Ataque")
    private String nome;

    @Schema(description = "Quantidade máxima de cartas desse tipo", example = "5")
    private int quantidadeMaxima;
    
    @Schema(description = "ID do frame associado ao tipo de carta", example = "2")
    private Long frameId;

    public TipoCartaDTO() {
    }

    public TipoCartaDTO(TipoCarta tipoCarta) {
        this.id = tipoCarta.getId();
        this.nome = tipoCarta.getNome();
        this.quantidadeMaxima = tipoCarta.getQuantidadeMaxima();
        this.frameId = tipoCarta.getFrame() != null ? tipoCarta.getFrame().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public Long getFrameId() {
        return frameId;
    }
}
