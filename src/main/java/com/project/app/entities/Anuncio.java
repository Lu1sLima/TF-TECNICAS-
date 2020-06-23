package com.project.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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



    //Byte imagem; learn how to do

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    public Anuncio(User user, String title, String description, Vehicle vehicle){
        this.user = user;
        this.title = title;
        this.description = description;
        this.vehicle = vehicle;

    }



}
