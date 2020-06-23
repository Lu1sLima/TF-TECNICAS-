package com.project.app.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class User {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String name;
        @Column(unique=true)
        String email;

        String password;
        String contact;
        String city;





        //List<String> lastSearchs;

        public User(String name, String email, String password, String contact,String city){
                this.name = name;
                this.email = email;
                this.password = password;
                this.contact = contact;
                this.city = city;
        }


}