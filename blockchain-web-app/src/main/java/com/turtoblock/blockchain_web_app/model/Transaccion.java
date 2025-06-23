package com.turtoblock.blockchain_web_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;
    private Long id1; // emisor
    private Long id2; // receptor
    private double cantidad;
    private String estado; // puede ser "PENDIENTE" o "CONFIRMADA"
}
