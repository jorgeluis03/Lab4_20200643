package com.example.lab4_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo")
    private int idvuelo;
    @Column(name = "origen")
    private String origen;
    @Column(name = "destino")
    private String destino;
    @Column(name = "fecha_salida")
    private Date fecha_salida;
    @Column(name = "fecha_llegada")
    private Date fecha_llegada;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "precio")
    private int  precio;
    @Column(name = "asientos_disponibles")
    private int  asientos_disponibles;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idaerolinea")
    private Aerolinea  aerolinea;

}
