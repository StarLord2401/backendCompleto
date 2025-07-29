package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Texto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TextoDTO {
    @Schema(description = "ID da carta", example = "1")
    private Long cartaId;

    @Schema(description = "ID do espaço de texto", example = "2")
    private Long textoEspacoId;

    @Schema(description = "Texto associado ao espaço de texto", example = "Este é um texto de exemplo.")
    private String texto;

    public TextoDTO() {
    }

    public TextoDTO(Texto texto) {
        this.cartaId = texto.getCarta() != null ? texto.getCarta().getId() : null;
        this.textoEspacoId = texto.getTextoEspaco() != null ? texto.getTextoEspaco().getId() : null;
        this.texto = texto.getTexto();
    }

    public Long getCartaId() {
        return cartaId;
    }

    public Long getTextoEspacoId() {
        return textoEspacoId;
    }

    public String getTexto() {
        return texto;
    }
}
