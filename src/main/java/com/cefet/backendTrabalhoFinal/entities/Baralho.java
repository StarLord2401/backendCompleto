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
@Table(name = "Baralho")
public class Baralho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "baralho")
    private List<BaralhoTemCarta> cartasNoBaralho;

    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, length = 255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    // @ManyToMany
    // @JoinTable(name = "tb_baralho_carta",
    //         joinColumns = @JoinColumn(name = "baralho_id"),
    //         inverseJoinColumns = @JoinColumn(name = "carta_id"))
    // private List<Carta> cartas;

    public Baralho() {
    }

    public Baralho(Long id, String nome, String descricao, Usuario usuario, Jogo jogo, List<BaralhoTemCarta> cartasNoBaralho) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.jogo = jogo;
        this.cartasNoBaralho = cartasNoBaralho;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<BaralhoTemCarta> getCartasNoBaralho() {
        return cartasNoBaralho;
    }

    public void setBaralhosTemCartas(List<BaralhoTemCarta> cartasNoBaralho) {
        this.cartasNoBaralho = cartasNoBaralho;
    }
}
