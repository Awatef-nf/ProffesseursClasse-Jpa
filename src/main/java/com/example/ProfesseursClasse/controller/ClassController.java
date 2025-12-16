package com.example.ProfesseursClasse.controller;

import com.example.ProfesseursClasse.model.Classe;
import com.example.ProfesseursClasse.services.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClassController {

    private ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    //vue pour tt les classes
    @GetMapping
    public String getAllClass(Model model) {
        model.addAttribute("listeClass", classService.getAllClass());
        return "/classes/index";
    }
    //formulaire de creation
    @GetMapping("/nouveau")
    public String getForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "/classes/formulaire";
    }

    //creer une nouvelle classe
    @PostMapping("/nouveau")
    public String ajouterUneClass(@ModelAttribute Classe classe, Model model) {
        classService.createNewClass(classe);
        return "redirect:/classes/";
    }

    //voir les details d une classe
    @GetMapping("/{id}")
    public String voirDetail(Model model, @PathVariable Long id) {
        model.addAttribute("classe", classService.getClassById(id));
        return "/classes/detail";
    }
    //modifier formulaire par id
    @GetMapping("/{id}/modifier")
    public String modifierClass(@PathVariable Long id, Model model) {
        Classe classe = classService.getClassById(id);
        if (classe != null) {
            model.addAttribute("classe", classe);
            return "/classes/formulaire";
        }
        return "redirect:/classes/";

    }


    @PostMapping("/{id}/modifier")
    public String modifierClass(@ModelAttribute Classe classe) {
        classService.modifierClass(classe);
        return "redirect:/classes/";
    }

    //effacer une classe

    @GetMapping("/{id}/delete")
    public String effacerClass(@PathVariable Long id) {
        classService.effacerClassById(id);
        return "redirect:/classes/";
    }

}

