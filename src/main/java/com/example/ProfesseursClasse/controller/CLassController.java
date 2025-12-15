package com.example.ProfesseursClasse.controller;

import com.example.ProfesseursClasse.model.Classe;
import com.example.ProfesseursClasse.model.Professeur;
import com.example.ProfesseursClasse.services.ClassService;
import com.example.ProfesseursClasse.services.ProfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CLassController {

    private ClassService classService;

    public CLassController(ClassService classService) {
        this.classService = classService;
    }

    //vue pour tt les classes
    @GetMapping()
    public String getAllClass(Model model) {
        model.addAttribute("listArticle", classService.getAllClass());
        return "/formulaire";
    }
    //formulaire de creation
    @GetMapping("/nouveau")
    public String getForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "formulaire";
    }

    //creer une nouvelle classe
    @PostMapping("/nouveau")
    public String ajouterUneClass(@ModelAttribute Classe classe, Model model) {
        classService.createNewClass(classe);
        return "redirect:/";
    }

    //voir les details d une classe
    @GetMapping("/{id}")
    public String voirDetail(Model model, @PathVariable Long id) {
        model.addAttribute("classe", classService.getClassById(id));
        return "detail";
    }
    //modifier formulaire par id
    @GetMapping("/{id}/modifier")
    public String modifierClass(@PathVariable Long id, Model model) {
        Classe classe = classService.getClassById(id);
        if (classe != null) {
            model.addAttribute("classe", classe);
            return "formulaire";
        }
        return "redirect:/";

    }


    @PostMapping("/{id}/modifier")
    public String modifierClass(@ModelAttribute Classe classe) {
        classService.modifierClass(classe);
        return "redirect:/";
    }

    //effacer une classe

    @GetMapping("/{id}/delete")
    public String effacerClass(@PathVariable Long id) {
        classService.effacerClassById(id);
        return "redirect:/";
    }

}

