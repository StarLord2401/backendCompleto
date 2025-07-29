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
@Table(name = "Carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "carta")
    private List<Texto> textos;

    @OneToMany(mappedBy = "carta")
    private List<BaralhoTemCarta> baralhosTemCartas;

    @ManyToOne
    @JoinColumn(name = "tipo_carta_id", nullable = false)   
    private TipoCarta tipoCarta;

    @ManyToOne
    @JoinColumn(name = "colecao_id", nullable = false)
    private Colecao colecao;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

    public Carta() {
    }

    public Carta(Long id, List<Texto> textos, List<BaralhoTemCarta> baralhosTemCartas, TipoCarta tipoCarta, Colecao colecao, String nome, String descricao, int quantidade) {
        this.id = id;
        this.textos = textos;
        this.baralhosTemCartas = baralhosTemCartas;
        this.tipoCarta = tipoCarta;
        this.colecao = colecao;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Texto> getTextos() {
        return textos;
    }

    public void setTextos(List<Texto> textos) {
        this.textos = textos;
    }

    public List<BaralhoTemCarta> getBaralhosTemCartas() {
        return baralhosTemCartas;
    }

    public void setBaralhosTemCartas(List<BaralhoTemCarta> baralhosTemCartas) {
        this.baralhosTemCartas = baralhosTemCartas;
    }

    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(TipoCarta tipoCarta) {
        this.tipoCarta = tipoCarta;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
