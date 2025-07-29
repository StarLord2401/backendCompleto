package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.BaralhoTemCarta;

import io.swagger.v3.oas.annotations.media.Schema;

public class BaralhoTemCartaDTO {
    @Schema(description = "ID do Baralho", example = "1")
    private Long baralhoId;

    @Schema(description = "ID da Carta", example = "42")
    private Long cartaId;

    @Schema(description = "Quantidade de cartas no baralho", example = "3")
    private int quantidade;

    public BaralhoTemCartaDTO() {
    }

    public BaralhoTemCartaDTO(BaralhoTemCarta baralhoTemCarta) {
        this.baralhoId = baralhoTemCarta.getBaralho().getId();
        this.cartaId = baralhoTemCarta.getCarta().getId();
        this.quantidade = baralhoTemCarta.getQuantidade();
    }

    public Long getBaralhoId() {
        return baralhoId;
    }

    public Long getCartaId() {
        return cartaId;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
