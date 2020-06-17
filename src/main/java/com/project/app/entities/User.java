package com.project.app.entities;

import lombok.*;

import javax.persistence.*;

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
        String email;
        String password;
        

}