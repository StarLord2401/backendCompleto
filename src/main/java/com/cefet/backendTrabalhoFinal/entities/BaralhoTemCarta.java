package com.cefet.backendTrabalhoFinal.entities;

import com.cefet.backendTrabalhoFinal.entities.keys.BaralhoTemCartaKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "BaralhoTemCarta")
public class BaralhoTemCarta {
    @EmbeddedId
    private BaralhoTemCartaKey id;

    @ManyToOne
    @MapsId("baralhoId")
    @JoinColumn(name = "baralho_id")
    private Baralho baralho;

    @ManyToOne
    @MapsId("cartaId")
    @JoinColumn(name = "carta_id")
    private Carta carta;

    @Column(nullable = false)
    private int quantidade;

    public BaralhoTemCarta() {
    }

    public BaralhoTemCarta(BaralhoTemCartaKey id, Baralho baralho, Carta carta, int quantidade) {
        this.id = id;
        this.baralho = baralho;
        this.carta = carta;
        this.quantidade = quantidade;
    }

    public BaralhoTemCartaKey getId() {
        return id;
    }

    public void setId(BaralhoTemCartaKey id) {
        this.id = id;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
