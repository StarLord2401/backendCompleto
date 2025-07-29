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
@Table(name = "TipoCarta")
public class TipoCarta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private int quantidadeMaxima;

    @ManyToOne
    @JoinColumn(name = "frame_id", nullable = false)
    private Frame frame;

    @OneToMany(mappedBy = "tipoCarta")
    private List<Carta> cartas;

    @OneToMany(mappedBy = "tipoCarta")
    private List<TextoEspaco> textosEspaco;

    public TipoCarta() {
    }

    public TipoCarta(Long id, String nome, int quantidadeMaxima, Frame frame, List<Carta> cartas, List<TextoEspaco> textosEspaco) {
        this.id = id;
        this.nome = nome;
        this.quantidadeMaxima = quantidadeMaxima;
        this.frame = frame;
        this.cartas = cartas;
        this.textosEspaco = textosEspaco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<TextoEspaco> getTextosEspaco() {
        return textosEspaco;
    }

    public void setTextosEspaco(List<TextoEspaco> textosEspaco) {
        this.textosEspaco = textosEspaco;
    }
}
