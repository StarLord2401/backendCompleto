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
@Table(name = "Jogo")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private int tamanhoBaralho;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "jogo")
    List<Baralho> baralhos;

    @OneToMany(mappedBy = "jogo")
    List<Partida> partidas;

    @OneToMany(mappedBy = "jogo")
    List<Colecao> colecoes;

    @OneToMany(mappedBy = "jogo")
    List<Frame> frames;

    public Jogo() {
    }

    public Jogo(Long id, String nome, String descricao, int tamanhoBaralho, Usuario usuario, List<Baralho> baralhos, List<Partida> partidas, List<Colecao> colecoes, List<Frame> frames) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanhoBaralho = tamanhoBaralho;
        this.usuario = usuario;
        this.baralhos = baralhos;
        this.partidas = partidas;
        this.colecoes = colecoes;
        this.frames = frames;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTamanhoBaralho() {
        return tamanhoBaralho;
    }

    public void setTamanhoBaralho(int tamanhoBaralho) {
        this.tamanhoBaralho = tamanhoBaralho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Baralho> getBaralhos() {
        return baralhos;
    }

    public void setBaralhos(List<Baralho> baralhos) {
        this.baralhos = baralhos;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public List<Colecao> getColecoes() {
        return colecoes;
    }

    public void setColecoes(List<Colecao> colecoes) {
        this.colecoes = colecoes;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
