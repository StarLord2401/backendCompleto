package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Baralho;

import io.swagger.v3.oas.annotations.media.Schema;

public class BaralhoDTO {
    @Schema(description = "ID do Baralho", example = "1")
    private Long id;

    @Schema(description = "Nome do Baralho", example = "Baralho de Magias")
    private String nome;

    @Schema(description = "Descrição do Baralho", example = "Este baralho contém cartas de magias poderosas.")
    private String descricao;

    @Schema(description = "ID do usuário que criou o baralho", example = "69")
    private Long usuarioId;

    @Schema(description = "ID do jogo associado ao baralho", example = "42")
    private Long jogoId;

    public BaralhoDTO() {
    }

    public BaralhoDTO(Baralho baralho) {
        this.id = baralho.getId();
        this.nome = baralho.getNome();
        this.descricao = baralho.getDescricao();
        this.usuarioId = baralho.getUsuario() != null ? baralho.getUsuario().getId() : null;
        this.jogoId = baralho.getJogo() != null ? baralho.getJogo().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getJogoId() {
        return jogoId;
    }
}

