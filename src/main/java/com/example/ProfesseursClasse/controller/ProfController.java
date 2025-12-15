package com.example.ProfesseursClasse.controller;

import com.example.ProfesseursClasse.model.Classe;

import com.example.ProfesseursClasse.model.Professeur;
import com.example.ProfesseursClasse.services.ClassService;
import com.example.ProfesseursClasse.services.ProfService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//le chemin de tous les mapping
@RequestMapping ("/professeur")
public class ProfController {

    private ProfService profService;

    public ProfController(ProfService profService) {
        this.profService = profService;
    }

   //vue pour tt les prof
    @GetMapping()
    public String getAllProf(Model model) {
        model.addAttribute("listArticle", profService.getAllProf());
        return "/index";
    }
    //formulaire de creation
    @GetMapping("/nouveau")
    public String getForm(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "formulaire";
    }

    //creer un nouveau professeur
    @PostMapping("/nouveau")
    public String ajouterUnProf(@ModelAttribute Professeur professeur, Model model) {
        profService.createNewProf(professeur);
        return "redirect:/";
    }

    //voir les details d un professeur
    @GetMapping("/{id}")
    public String voirDetail(Model model, @PathVariable Long id) {
        model.addAttribute("article", profService.getProfById(id));
        return "detail";
    }
    //modifier formulaire par id
    @GetMapping("/{id}/modifier")
    public String modifierProf(@PathVariable Long id, Model model) {
        Professeur professeur = profService.getProfById(id);
        if (professeur != null) {
            model.addAttribute("professeur", professeur);
            return "formulaire";
        }
        return "redirect:/";

    }


        @PostMapping("/{id}/modifier")
        public String modifierProf(@ModelAttribute Professeur professeur) {
            profService.modifierProf(professeur);
            return "redirect:/";
        }

  //effacer un professeur

    @GetMapping("/{id}/delete")
    public String effacerProf(@PathVariable Long id) {
        profService.effacerProfById(id);
        return "redirect:/";
    }

    }








