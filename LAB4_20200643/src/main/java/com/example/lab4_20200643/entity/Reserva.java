package com.example.lab4_20200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private int idreserva;

    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

    @Column(name = "precio_total")
    private BigDecimal precio_total;

    @Column(name = "estado_pago")
    private String nombre;

    @Column(name = "user_iduser")
    private int user;

    @Column(name = "vuelo_idvuelo")
    private int vuelo;
}
