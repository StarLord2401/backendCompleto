package com.cefet.backendTrabalhoFinal.entities;

import com.cefet.backendTrabalhoFinal.entities.keys.TextoKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Texto")
public class Texto {
    @EmbeddedId
    private TextoKey id;

    @ManyToOne
    @MapsId("cartaId")
    @JoinColumn(name = "carta_id")
    private Carta carta;

    @ManyToOne
    @MapsId("textoEspacoId")
    @JoinColumn(name = "texto_espaco_id")
    private TextoEspaco textoEspaco;

    @Column(nullable=false, length=500)
    private String texto;

    public Texto() {
    }

    public Texto(TextoKey id, Carta carta, TextoEspaco textoEspaco, String texto) {
        this.id = id;
        this.carta = carta;
        this.textoEspaco = textoEspaco;
        this.texto = texto;
    }

    public TextoKey getId() {
        return id;
    }

    public void setId(TextoKey id) {
        this.id = id;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public TextoEspaco getTextoEspaco() {
        return textoEspaco;
    }

    public void setTextoEspaco(TextoEspaco textoEspaco) {
        this.textoEspaco = textoEspaco;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
