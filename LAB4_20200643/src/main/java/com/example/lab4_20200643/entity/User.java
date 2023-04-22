package com.example.lab4_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int iduser;

    @Column(name = "username")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


}
