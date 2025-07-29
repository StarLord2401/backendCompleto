package com.cefet.backendTrabalhoFinal.entities.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TextoKey implements Serializable {
    @Column(name = "carta_id")
    private Long cartaId;

    @Column(name = "texto_espaco_id")
    private Long textoEspacoId;

    public TextoKey() {
    }

    public TextoKey(Long cartaId, Long textoEspacoId) {
        this.cartaId = cartaId;
        this.textoEspacoId = textoEspacoId;
    }

    public Long getCartaId() {
        return cartaId;
    }  

    public void setCartaId(Long cartaId) {
        this.cartaId = cartaId;
    }

    public Long getTextoEspacoId() {
        return textoEspacoId;
    }

    public void setTextoEspacoId(Long textoEspacoId) {
        this.textoEspacoId = textoEspacoId;
    }
}
