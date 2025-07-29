package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Colecao;

import io.swagger.v3.oas.annotations.media.Schema;

public class ColecaoDTO {

    @Schema(description = "ID da coleção", example = "1")
    private Long id;

    @Schema(description = "Nome da coleção", example = "Coleção de Cartas Mágicas")
    private String nome;

    @Schema(description = "Descrição da coleção", example = "Esta coleção contém cartas mágicas poderosas.")
    private String descricao;

    @Schema(description = "Jogo associado à coleção")
    private Long jogoId;

    public ColecaoDTO() {
    }

    public ColecaoDTO(Colecao colecao) {
        this.id = colecao.getId();
        this.nome = colecao.getNome();
        this.descricao = colecao.getDescricao();
        this.jogoId = colecao.getJogo() != null ? colecao.getJogo().getId() : null;
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

    public Long getJogoId() {
        return jogoId;
    }
}
