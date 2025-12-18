package com.example.ProfesseursClasse.repository;

import com.example.ProfesseursClasse.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfRepository extends JpaRepository<Professeur, Long> {

    List<Professeur> findAllByOrderByNomAsc();
}
