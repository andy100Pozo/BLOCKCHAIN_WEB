package com.turtoblock.blockchain_web_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userdetail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String rol;
    private String nomcompleto;
    private String dni;
    private double saldo;
    private String firmadigital;
    private String email;
}
