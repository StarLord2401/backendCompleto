package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Frame;

import io.swagger.v3.oas.annotations.media.Schema;


public class FrameDTO {
    @Schema(description = "ID do Frame", example = "1")
    private Long id;

    @Schema(description = "Caminho do Frame", example = "/images/frames/frame1.png")   
    private String path;

    @Schema(description = "ID do jogo associado ao frame", example = "42")
    private Long jogoId;

    public FrameDTO() {
    }

    public FrameDTO(Frame frame) {
        this.id = frame.getId();
        this.path = frame.getPath();
        this.jogoId = frame.getJogo() != null ? frame.getJogo().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Long getJogoId() {
        return jogoId;
    }
}
