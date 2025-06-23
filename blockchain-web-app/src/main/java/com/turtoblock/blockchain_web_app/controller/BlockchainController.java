package com.turtoblock.blockchain_web_app.controller;

import com.turtoblock.blockchain_web_app.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlockchainController {

    @Autowired
    private BlockRepository blockRepo;

    @GetMapping("/blockchain")
    public String mostrarBlockchain(Model model) {
        model.addAttribute("blocks", blockRepo.findAll());
        return "blockchain";
    }
}
