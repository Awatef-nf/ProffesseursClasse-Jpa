package com.example.ProfesseursClasse.repository;

import com.example.ProfesseursClasse.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Classe, Long> {

}
