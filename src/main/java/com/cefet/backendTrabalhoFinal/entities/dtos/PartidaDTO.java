package com.cefet.backendTrabalhoFinal.entities.dtos;

import java.util.List;

import com.cefet.backendTrabalhoFinal.entities.Partida;

import io.swagger.v3.oas.annotations.media.Schema;

public class PartidaDTO {
    @Schema(description = "ID da partida", example = "1")
    private Long id;

    @Schema(description = "ID do jogo associado", example = "2")
    private Long jogoId;

    @Schema(description = "Lista de IDs dos usuários participantes", example = "[1, 2, 3]")
    private List<Long> idUsuarios;

    public PartidaDTO() {
    }

    public PartidaDTO(Partida partida) {
        this.id = partida.getId();
        this.jogoId = partida.getJogo() != null ? partida.getJogo().getId() : null;
        this.idUsuarios = partida.getUsuarios().stream()
            .map(usuario -> usuario.getId())
            .toList();
    }

    public Long getId() {
        return id;
    }

    public Long getJogoId() {
        return jogoId;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }
}
