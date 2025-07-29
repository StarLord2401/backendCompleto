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
@Table(name = "TextoEspaco")
public class TextoEspaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "textoEspaco")
    private List<Texto> textos;

    @Column(nullable = false)
    private int x;

    @Column(nullable = false)
    private int y;

    @ManyToOne
    @JoinColumn(name = "tipo_carta_id", nullable = false)
    private TipoCarta tipoCarta;

    public TextoEspaco() {
    }

    public TextoEspaco(Long id, List<Texto> textos, int x, int y, TipoCarta tipoCarta) {
        this.id = id;
        this.textos = textos;
        this.x = x;
        this.y = y;
        this.tipoCarta = tipoCarta;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TipoCarta getTipoCarta() {
        return tipoCarta;
    }

    public void setTipoCarta(TipoCarta tipoCarta) {
        this.tipoCarta = tipoCarta;
    }
}
