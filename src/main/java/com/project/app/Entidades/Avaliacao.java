package com.project.app.Entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Anuncio anuncio;

    @ManyToOne
    User user;

    String comentario;
    int pontuacao;

    public Avaliacao(Anuncio anuncio, User user, String comentario, int pontuacao) {
        this.pontuacao = pontuacao;
        this.anuncio = anuncio;
        this.user = user;
        this.comentario = comentario;
    }


}
