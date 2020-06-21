package com.project.app.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique=true)
    String placa;

    String modelo;
    Tipo tipo;
    Marca marca;
    Double preco;

    public Vehicle(String placa, String modelo, Tipo tipo, Marca marca, Double preco){
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.marca = marca;
        this.preco = preco;
    }


}
