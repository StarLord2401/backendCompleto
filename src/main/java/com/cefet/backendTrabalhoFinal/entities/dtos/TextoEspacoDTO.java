package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.TextoEspaco;

import io.swagger.v3.oas.annotations.media.Schema;

public class TextoEspacoDTO {
    @Schema(description = "ID do espaço de texto", example = "1")
    private Long id;

    @Schema(description = "ID do tipo de carta associado ao espaço de texto", example = "2")
    private Long tipoCartaId;

    @Schema(description = "Coordenada X do espaço de texto", example = "100")
    private int x;

    @Schema(description = "Coordenada Y do espaço de texto", example = "200")
    private int y;

    public TextoEspacoDTO() {
    }

    public TextoEspacoDTO(TextoEspaco textoEspaco) {
        this.id = textoEspaco.getId();
        this.tipoCartaId = textoEspaco.getTipoCarta() != null ? textoEspaco.getTipoCarta().getId() : null;
        this.x = textoEspaco.getX();
        this.y = textoEspaco.getY();
    }

    public Long getId() {
        return id;
    }

    public Long getTipoCartaId() {
        return tipoCartaId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
