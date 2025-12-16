package com.example.ProfesseursClasse.services;

import com.example.ProfesseursClasse.model.Classe;
import com.example.ProfesseursClasse.model.Professeur;
import com.example.ProfesseursClasse.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private ClassRepository classRepository;
    private List<Classe> listeClass = new ArrayList<>();

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;

    }
  //lister toutes les classes
    public List<Classe> getAllClass()
    {
        return classRepository.findAll();
    }
   //Obtenir une classe par son ID
   public Classe getClassById(Long id) {
       return classRepository.findById(id)
               .orElseThrow(
                       ()-> new IllegalArgumentException("la classe " +id+" non trouvable")
               );
   }

    //Créer une nouvelle classe
    public Classe createNewClass(Classe c)
    {
        return classRepository.save(c);
    }

     //Modifier une classe
     public Classe modifierClass(Classe c)
     {
         return classRepository.save(c);
     }

     // Supprimer une classe

    public void effacerClassById(Long id)
    {
        classRepository.deleteById(id);
    }

}
