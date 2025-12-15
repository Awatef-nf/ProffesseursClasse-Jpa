package com.example.ProfesseursClasse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Classe {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String niveau;
    private String matière;
    private int nombreEleves;

    @ManyToOne
    @JoinColumn(name= "professeur")
    @JsonBackReference
    private Professeur professeur;

    public Classe() {
    }

    public Classe(Long id, Professeur professeur, int nombreEleves, String matière, String niveau, String nom) {
        this.id = id;
        this.professeur = professeur;
        this.nombreEleves = nombreEleves;
        this.matière = matière;
        this.niveau = niveau;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMatière() {
        return matière;
    }

    public void setMatière(String matière) {
        this.matière = matière;
    }

    public int getNombreEleves() {
        return nombreEleves;
    }

    public void setNombreEleves(int nombreEleves) {
        this.nombreEleves = nombreEleves;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}