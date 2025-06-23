package com.turtoblock.blockchain_web_app.service;

import com.turtoblock.blockchain_web_app.model.Transaccion;
import com.turtoblock.blockchain_web_app.model.UserDetail;
import com.turtoblock.blockchain_web_app.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BlockchainService blockchainService;

    public boolean registrarTransaccion(Long id1, Long id2, double monto) {
        UserDetail emisor = userService.getById(id1).orElseThrow();
        UserDetail receptor = userService.getById(id2).orElseThrow();

        if (emisor.getSaldo() >= monto) {
            // Descontar y actualizar saldo
            userService.actualizarSaldo(id1, emisor.getSaldo() - monto);
            userService.actualizarSaldo(id2, receptor.getSaldo() + monto);

            // Registrar transacción
            Transaccion t = new Transaccion(null, LocalDate.now(), LocalTime.now(), id1, id2, monto, "PENDIENTE");
            transaccionRepo.save(t);

            // Enviar correo
            emailService.enviarCorreo(emisor.getEmail(), "Transferencia realizada",
                    "Tu transferencia de S/. " + monto + " fue registrada correctamente.");

            // Verificar si toca minar
            blockchainService.verificarTransaccionesPendientesYMinar();

            return true;
        }

        return false; // saldo insuficiente
    }
}
