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
    private List<Professeur> prof = new ArrayList<>();

    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }
   //lister tous les professeurs
    public List<Professeur> getAllProf()
    {
        return profRepository.findAll();
    }

    //obtenir un professeur par son id
   public Professeur getProfById(Long id)
   {
       return profRepository.findById(id).get();
   }
   //creer un prof
    public Professeur createNewProf(Professeur professeur)
    {
        return profRepository.save(professeur);
    }
   //modifier un prof
    public Professeur modifyProf(Professeur p)
    {
     return profRepository.save(p);
    }
    //effacer un prof
    public void effacerProfById(Long id )
    {
       profRepository.deleteById(id);
    }

}
