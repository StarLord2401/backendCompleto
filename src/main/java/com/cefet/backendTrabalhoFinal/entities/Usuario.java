package com.cefet.backendTrabalhoFinal.entities;

import java.util.List;

import com.cefet.backendTrabalhoFinal.enumerated.AccessLevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String login;

    @Column(nullable = false, length = 100)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private AccessLevel accessLevel;
    
    @OneToMany(mappedBy = "usuario")
    List<Baralho> baralhos;

    @OneToMany(mappedBy = "usuario")
    List<Jogo> jogos;

    @ManyToMany(mappedBy = "usuarios")
    List<Partida> partidas;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha, AccessLevel accessLevel, List<Baralho> baralhos, List<Jogo> jogos, List<Partida> partidas) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.accessLevel = accessLevel;
        this.baralhos = baralhos;
        this.jogos = jogos;
        this.partidas = partidas;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<Baralho> getBaralhos() {
        return baralhos;
    }

    public void setBaralhos(List<Baralho> baralhos) {
        this.baralhos = baralhos;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}
