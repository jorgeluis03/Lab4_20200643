package com.example.lab4_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aerolinea")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idareolinea")
    private int idareolinea;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private String codigo;
}
