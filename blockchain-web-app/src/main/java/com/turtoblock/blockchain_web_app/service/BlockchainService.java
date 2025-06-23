package com.turtoblock.blockchain_web_app.service;

import com.turtoblock.blockchain_web_app.model.*;
import com.turtoblock.blockchain_web_app.repository.*;
import com.turtoblock.blockchain_web_app.util.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BlockchainService {

    @Autowired
    private BlockRepository blockRepo;

    @Autowired
    private TransaccionRepository transaccionRepo;

    @Autowired
    private GananciaRepository gananciaRepo;

    @Autowired
    private MinerService minerService;

    private static final int DIFFICULTY = 1;
    private static final double REWARD = 10.0;

    public void verificarTransaccionesPendientesYMinar() {
        List<Transaccion> pendientes = transaccionRepo.findByEstado("PENDIENTE");
        if (pendientes.size() >= 3) {
            List<Transaccion> transaccionesParaBloque = pendientes.subList(0, 3);

            // Preparar datos del bloque
            String transaccionesTexto = transaccionesParaBloque.toString();
            String prevHash = blockRepo.findAll().isEmpty()
                    ? "0000000000000000000000000000000000000000000000000000000000000000"
                    : blockRepo.findAll().get(blockRepo.findAll().size() - 1).getHash();

            Block bloque = new Block();
            bloque.setTimeStamp(System.currentTimeMillis());
            bloque.setPreviousHash(prevHash);
            bloque.setTransacciones(transaccionesTexto);

            // Minado (proof of work)
            String hash;
            int nonce = 0;
            do {
                String data = bloque.getPreviousHash() + bloque.getTimeStamp() + nonce + transaccionesTexto;
                hash = SHA256Helper.generateHash(data);
                nonce++;
            } while (!hash.startsWith("0".repeat(DIFFICULTY)));

            bloque.setNonce(nonce);
            bloque.setHash(hash);
            blockRepo.save(bloque);

            // Actualizar transacciones como confirmadas
            transaccionesParaBloque.forEach(t -> {
                t.setEstado("CONFIRMADA");
                transaccionRepo.save(t);
            });

            // Registrar ganancia al minero
            Miner minero = minerService.obtenerMineroAleatorio();
            Ganancia ganancia = new Ganancia(null, minero.getId(), bloque.getId(), REWARD, LocalDate.now(), LocalTime.now());
            gananciaRepo.save(ganancia);
        }
    }
}
