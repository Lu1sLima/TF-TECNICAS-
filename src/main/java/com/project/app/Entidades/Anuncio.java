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
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    User user;

    String title;

    String description;

    Double preco;

    //Byte imagem; learn how to do

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    public Anuncio(User user, String title, String description, Vehicle vehicle, Double preco){
        this.user = user;
        this.title = title;
        this.description = description;
        this.vehicle = vehicle;
        this.preco = preco;
    }



}
