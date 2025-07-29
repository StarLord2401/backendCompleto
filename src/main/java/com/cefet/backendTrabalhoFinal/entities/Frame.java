package com.cefet.backendTrabalhoFinal.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Frame")
public class Frame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)    
    private String path;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    @OneToMany(mappedBy = "frame")
    List<TipoCarta> tiposCarta;

    public Frame() {
    }

    public Frame(Long id, String path, Jogo jogo, List<TipoCarta> tiposCarta) {
        this.id = id;
        this.path = path;
        this.jogo = jogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<TipoCarta> getTiposCarta() {
        return tiposCarta;
    }

    public void setTiposCarta(List<TipoCarta> tiposCarta) {
        this.tiposCarta = tiposCarta;
    }
}
