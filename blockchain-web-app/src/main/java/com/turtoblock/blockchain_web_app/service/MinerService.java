package com.turtoblock.blockchain_web_app.service;

import com.turtoblock.blockchain_web_app.model.Miner;
import com.turtoblock.blockchain_web_app.repository.MinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MinerService {

    @Autowired
    private MinerRepository minerRepo;

    public Miner obtenerMineroAleatorio() {
        List<Miner> mineros = minerRepo.findAll();
        if (mineros.isEmpty()) throw new RuntimeException("No hay mineros disponibles");
        return mineros.get(new Random().nextInt(mineros.size()));
    }
}
