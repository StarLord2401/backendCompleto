package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Jogo;

import io.swagger.v3.oas.annotations.media.Schema;

public class JogoDTO {
    @Schema(description = "ID do jogo", example = "1")
    private Long id;

    @Schema(description = "Nome do jogo", example = "Magic: The Gathering")
    private String nome;

    @Schema(description = "Descrição do jogo", example = "Um jogo de cartas colecionáveis onde os jogadores usam feitiços, criaturas e artefatos para derrotar seus oponentes.")    
    private String descricao;

    @Schema(description = " Tamanho máximo do baralho", example = "4")
    private int tamanhoBaralho;

    @Schema(description = "ID do usuário criador do jogo", example = "69")
    private Long usuarioId;

    public JogoDTO() {
    }

    public JogoDTO(Jogo jogo) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.descricao = jogo.getDescricao();
        this.tamanhoBaralho = jogo.getTamanhoBaralho();
        this.usuarioId = jogo.getUsuario() != null ? jogo.getUsuario().getId() : null;
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

    public int getTamanhoBaralho() {
        return tamanhoBaralho;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
}
