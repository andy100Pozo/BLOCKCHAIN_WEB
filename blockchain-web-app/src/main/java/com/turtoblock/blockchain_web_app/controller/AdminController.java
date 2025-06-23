package com.turtoblock.blockchain_web_app.controller;

import com.turtoblock.blockchain_web_app.repository.GananciaRepository;
import com.turtoblock.blockchain_web_app.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TransaccionRepository transaccionRepo;

    @Autowired
    private GananciaRepository gananciaRepo;

    @GetMapping("/transacciones")
    public String mostrarTransacciones(Model model) {
        model.addAttribute("transacciones", transaccionRepo.findAll());
        return "transacciones";
    }

    @GetMapping("/ganancias")
    public String mostrarGanancias(Model model) {
        model.addAttribute("ganancias", gananciaRepo.findAll());
        return "ganancias";
    }
}
