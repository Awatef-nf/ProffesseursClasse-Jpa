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
@RequestMapping ("/professeurs")
public class ProfController {

    private ProfService profService;

    public ProfController(ProfService profService) {
        this.profService = profService;
    }

    @GetMapping("/aceuil")
    public String getAllProf() {
        return "aceuil/aceuil";
    }
    //vue pour tt les prof
    @GetMapping
    public String getAllProf(Model model) {
        model.addAttribute("listeProfesseur", profService.getProfesseursTriesParNom());
        model.addAttribute("nbprof",profService.nbreProf());
        return "professeurs/index";
    }



    //formulaire de creation
    @GetMapping("/nouveau")
    public String getForm(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "/professeurs/formulaire";

    }

    //creer un nouveau professeur
    @PostMapping("/nouveau")
    public String ajouterUnProf(@ModelAttribute Professeur professeur, Model model) {
        profService.createNewProf(professeur);
        return "redirect:/professeurs";
    }

    //voir les details d un professeur
    @GetMapping("/{id}")
    public String voirDetail(Model modelP, @PathVariable Long id) {
        modelP.addAttribute("professeur", profService.getProfById(id));
        modelP.addAttribute("nbreClassProf",profService.nbreClassProf(id));
        modelP.addAttribute("nbreEleveProf",profService.nbEleveProf(id));
        modelP.addAttribute("moyElvProf",profService.moyElevProf(id));

        return "/professeurs/detail";
    }

    //modifier formulaire par id
    @GetMapping("/{id}/modifier")
    public String modifierProf(@PathVariable Long id, Model modelP) {
        Professeur professeur = profService.getProfById(id);
        if (professeur != null) {
            modelP.addAttribute("professeur", professeur);
            return "/professeurs/formulaire";
        }
        return "redirect:/professeurs";

    }

    @PostMapping("/{id}/modifier")
    public String modifierProf(@ModelAttribute Professeur professeur, Model modelP) {
        profService.modifierProf(professeur);
        return "redirect:/professeurs";
    }

    //effacer un professeur

    @GetMapping("/{id}/supprimer")
    public String supprimerProf(@PathVariable Long id) {
        profService.supprimerProfById(id);
        return "redirect:/professeurs";
    }


    }








