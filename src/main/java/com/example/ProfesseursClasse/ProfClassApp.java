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
            profRepository.save(new Professeur("Aumegeas", "Maxime", "maxime@gmail.com"));
            profRepository.save(new Professeur("Cukon", "Tamara", "tamara@gmail.com"));
            profRepository.save(new Professeur("Nfaidh", "Awatef", "awatef@gmail.com"));


            Professeur Aumegeas = profRepository.findById(1L).get();
            Professeur Cukon = profRepository.findById(2L).get();
            Professeur Nfaidh = profRepository.findById(3L).get();

            classRepository.save(new Classe(23, "Français", "Bac", "cls1",Aumegeas));
            classRepository.save(new Classe(45, "Anglais", "Bts", "cls2", Nfaidh));
            classRepository.save(new Classe(12, "Maths", "Bac", "cls3",Cukon));
            classRepository.save(new Classe(15, "Maths", "Bac", "cls4",Cukon));
            classRepository.save(new Classe(12, "Français", "Bac", "cls5",Aumegeas));
        };
    }
}