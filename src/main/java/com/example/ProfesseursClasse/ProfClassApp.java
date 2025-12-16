package com.example.ProfesseursClasse;

import com.example.ProfesseursClasse.model.Classe;
import com.example.ProfesseursClasse.model.Professeur;
import com.example.ProfesseursClasse.repository.ClassRepository;
import com.example.ProfesseursClasse.repository.ProfRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfClassApp {

    public static void main(String[] args) {
        SpringApplication.run(ProfClassApp.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ProfRepository profRepository, ClassRepository classRepository) {
        return args -> {
            profRepository.save(new Professeur("Prof1", "Maxime", "maxime@gmail.com"));
            profRepository.save(new Professeur("Prof2", "Tamara", "tamara@gmail.com"));

            Professeur professeur1 = profRepository.findById(1L).get();
            Professeur professeur2 = profRepository.findById(2L).get();

            classRepository.save(new Classe(23, "bac", "Math", "cls1",professeur1));
            classRepository.save(new Classe(45, "bac+1", "francais", "cls2",professeur2));
            classRepository.save(new Classe(12, "bac+2", "anglais", "cls3",professeur1));
        };
    }
}