package com.project.app.Entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Avaliacao implements Comparable<Anuncio>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Anuncio anuncio;

    @ManyToOne
    User user;

    String comentario;
    int pontuacao;

    Integer visitas;

    public Avaliacao(Anuncio anuncio, User user, String comentario, int pontuacao) {
        if(pontuacao < 0 || pontuacao > 5){
            throw new IllegalArgumentException("Pontuacao inválida");
        }else{
            this.pontuacao = pontuacao;
        }
        this.anuncio = anuncio;
        this.user = user;
        this.comentario = comentario;
    }

    public void setPontuacao(int pontuacao){
        if(pontuacao < 0 || pontuacao > 5){
            throw new IllegalArgumentException("Pontuacao inválida");
        }else{
            this.pontuacao = pontuacao;
        }
    }
    @Override
    public int compareTo(Anuncio o) {
        return visitas.compareTo(o.visitas);
    }


}
