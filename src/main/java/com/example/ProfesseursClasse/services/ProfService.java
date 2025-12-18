package com.example.ProfesseursClasse.services;

import com.example.ProfesseursClasse.model.Classe;
import com.example.ProfesseursClasse.model.Professeur;
import com.example.ProfesseursClasse.repository.ProfRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfService {


    private ProfRepository profRepository;
    private List<Professeur> listeProfesseur = new ArrayList<>();

    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }

    //lister tous les professeurs
    public List<Professeur> getAllProf() {
        return profRepository.findAll();
    }

    //obtenir un professeur par son id
    public Professeur getProfById(Long id) {
        return profRepository.findById(id).get();
    }

    //creer un prof
    public Professeur createNewProf(Professeur professeur) {
        return profRepository.save(professeur);
    }

    //modifier un prof
    public Professeur modifierProf(Professeur p) {
        return profRepository.save(p);
    }

    //effacer un prof
    public void supprimerProfById(Long id) {
        profRepository.deleteById(id);
    }

   // nombre de classe du professeur
    public int nbreClassProf(Long id)
    {
        Professeur nbClassPro = getProfById(id);
        return nbClassPro.getClasses().size();
    }

    //nombre d'éléves par professeur

    public int nbEleveProf (Long id)
    {
        int count =0;
        Professeur nbElveProf = getProfById(id);
        for(Classe classe : nbElveProf.getClasses() )
        {
            count += classe.getNombreEleves();
        } return count;
    }
    public List<Professeur> getProfesseursTriesParNom() {
        return profRepository.findAllByOrderByNom();
    }



}
