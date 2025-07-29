package com.cefet.backendTrabalhoFinal.entities.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BaralhoTemCartaKey implements Serializable {
    @Column(name = "baralho_id")
    private Long baralhoId;

    @Column(name = "carta_id") 
    private Long cartaId;

    public BaralhoTemCartaKey() {
    }

    public BaralhoTemCartaKey(Long baralhoId, Long cartaId) {
        this.baralhoId = baralhoId;
        this.cartaId = cartaId;
    }

    public Long getBaralhoId() {
        return baralhoId;
    }

    public void setBaralhoId(Long baralhoId) {
        this.baralhoId = baralhoId;
    }

    public Long getCartaId() {
        return cartaId;
    }

    public void setCartaId(Long cartaId) {
        this.cartaId = cartaId;
    }
}
