package com.project.app.Entidades;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String placa;

    private String modelo;
    private Tipo tipo;
    private Marca marca;
    private Boolean novo;


    public static class Builder {

        private String placa;
        private String modelo;
        private Tipo tipo;
        private Marca marca;
        private Boolean novo;

        public Builder placa(String digitaPlaca) {
            placa = digitaPlaca;
            return this;
        }

        public Builder modelo(String digitaModelo) {
            modelo = digitaModelo;
            return this;
        }

        public Builder tipo(Tipo digitaTipo) {
            tipo = digitaTipo;
            return this;
        }

        public Builder marca(Marca digitaMarca) {
            marca = digitaMarca;
            return this;
        }

        public Builder novo(Boolean digitaNovo) {
            novo = digitaNovo;
            return this;
        }


        public Vehicle build() {
            return new Vehicle(this);
        }



    }

    private Vehicle (Builder builder){
        placa = builder.placa;
        modelo = builder.modelo;
        tipo = builder.tipo;
        marca = builder.marca;
        novo = builder.novo;

    }

    public Marca getMarca(){
        return this.marca;
    }


}
