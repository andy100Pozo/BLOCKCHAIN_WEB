package com.turtoblock.blockchain_web_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ganancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idmin;     // id del minero
    private Long idbloque;  // id del bloque generado
    private double ganancia;
    private LocalDate fecha;
    private LocalTime hora;
}
