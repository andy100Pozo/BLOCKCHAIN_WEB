package com.turtoblock.blockchain_web_app.controller;

import com.turtoblock.blockchain_web_app.model.Transaccion;
import com.turtoblock.blockchain_web_app.model.UserDetail;
import com.turtoblock.blockchain_web_app.security.UserPrincipal;
import com.turtoblock.blockchain_web_app.service.TransaccionService;
import com.turtoblock.blockchain_web_app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private TransaccionService transaccionService;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserPrincipal userPrincipal, Model model) {
        UserDetail usuario = userService.getByUsername(userPrincipal.getUsername()).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "home";
    }

    @GetMapping("/transferencia")
    public String mostrarFormularioTransferencia(Model model) {
        model.addAttribute("transaccion", new Transaccion());
        return "transferencia";
    }

    @PostMapping("/transferencia")
    public String procesarTransferencia(@ModelAttribute Transaccion transaccion,
                                        @AuthenticationPrincipal UserPrincipal userPrincipal,
                                        Model model) {
        UserDetail emisor = userService.getByUsername(userPrincipal.getUsername()).orElseThrow();
        boolean exito = transaccionService.registrarTransaccion(emisor.getId(), transaccion.getId2(), transaccion.getCantidad());

        if (exito) {
            model.addAttribute("mensaje", "Transferencia realizada correctamente.");
        } else {
            model.addAttribute("mensaje", "Saldo insuficiente.");
        }
        return "transferencia";
    }
}
