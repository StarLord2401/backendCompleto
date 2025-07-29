package com.cefet.backendTrabalhoFinal.entities.dtos;

public class JwtAuthenticationDTO {
    private String accessToken;
    private final String tokenType = "Bearer";

    public JwtAuthenticationDTO() {
    }

    public JwtAuthenticationDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
