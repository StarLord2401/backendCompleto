package com.cefet.backendTrabalhoFinal.entities.dtos;

import com.cefet.backendTrabalhoFinal.entities.Usuario;
import com.cefet.backendTrabalhoFinal.enumerated.AccessLevel;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDTO {
    @Schema(description = "ID do usuário", example = "69")
    private Long id;

    @Schema(description = "Nome do usuário", example = "Gabriel Kaizer")
    private String nome;

    @Schema(description = "Login do usuário", example = "kaizerlanches")
    private String login;

    @Schema(description = "Senha do usuário", example = "senhaforte123")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @Schema(description = "Nível de acesso do usuário", example = "ADMIN")
    private AccessLevel accessLevel;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.accessLevel = usuario.getAccessLevel();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
