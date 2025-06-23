package com.turtoblock.blockchain_web_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nonce;
    private long timeStamp;
    private String hash;
    private String previousHash;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String transacciones; // permite más de 255 caracteres
}
