package com.example.ProfesseursClasse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {




    @GetMapping("")
    public String getAceuil() {
        return "accueil/accueil";
    }

}
